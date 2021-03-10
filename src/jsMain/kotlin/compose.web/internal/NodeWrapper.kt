package compose.web.internal

import Modifier
import io.sooj.external.applyCss
import io.sooj.modifiers.*
import kotlinx.browser.document
import org.w3c.dom.*

internal class NodeWrapper internal constructor(internal val realNode: Node) {

    internal constructor(tagName: String) :
            this(document.createElement(tagName))

    internal var modifier: Modifier = Modifier
        set(value) {
            updateModifier(previous = field, next = value)
            field = value
        }

    private fun updateModifier(previous: Modifier, next: Modifier) {
        val element = realNode as HTMLElement

        previous.foldOut(Unit) { mod, _ ->
            if (mod is EventModifier) {
                element.removeEventListener(mod.name, mod.listener)
            }
        }
        if (element.style.length > 0) {
            element.style.cssText = ""
        }

        next.foldOut(Unit) { mod, _ ->
            when (mod) {
                is CssModifier -> element.style.applyCss(mod.css)
                is CssStringModifier -> element.style.cssText = mod.css
                is EventModifier -> element.addEventListener(mod.name, mod.listener)
                is AttrModifier -> element.updateAttr(mod)
                is ClassesModifier -> {
                    element.className = mod.classes ?: ""
                }

//                is PropertyModifier -> element.apply(mod.configure)
//                is RefModifier -> mod.configure(element)
            }
        }
    }

    private fun HTMLElement.updateAttr(attr: AttrModifier) {
        val value = attr.value?.toString() ?: ""
        when (attr.name) {
            "src" -> asDynamic().src = value
            "value" -> asDynamic().value = value
            else -> setAttribute(attr.name, value)
        }
    }

    fun insert(index: Int, instance: NodeWrapper) {
        if (realNode !is Element) throw IllegalStateException("Cannot add elements to $realNode")

        if (index == realNode.children.length) {
            realNode.appendChild(instance.realNode)
        } else {
            realNode.insertBefore(
                instance.realNode,
                realNode.childNodes[index]
            )
        }
    }

    fun remove(index: Int, count: Int) {
        repeat(count) {
            val removed = realNode.childNodes[index]!!
            realNode.removeChild(removed)
        }
    }

    fun move(from: Int, to: Int, count: Int) {
        // todo: simplify (copied from server-side project for now)
        if (from > to) {
            var next = to
            repeat(count) {
                val node = realNode.childNodes[from]!!
                realNode.removeChild(node)
                realNode.insertBefore(realNode.childNodes[next]!!, node)
                next++
            }
        } else {
            repeat(count) {
                val node = realNode.childNodes[from]!!
                realNode.removeChild(node)
                realNode.insertBefore(realNode.childNodes[to - 1]!!, node)
            }
        }
    }
}
