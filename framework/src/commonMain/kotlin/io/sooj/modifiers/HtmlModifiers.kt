@file:JvmName("_HtmlModifiers")

package io.sooj.modifiers

import Modifier
import androidx.compose.runtime.Composable
import io.sooj.external.Css
import kotlin.jvm.JvmName

/**
 * Adds an event listener for the target node which is applied on node recomposition
 */
expect class EventModifier : EventModifierBase

abstract class EventModifierBase(val name: String) : Modifier.Element

/**
 * Adds a css style configuration which would be applied when node is updated
 */
internal class CssModifier(val css: Css) : Modifier.Element

/**
 * Updates target node properties on recomposition
 * Properties are not cleared automatically (yet) when modifier is removed
 */
internal class AttrModifier(val name: String, val value: Any?): Modifier.Element

internal class ClassesModifier(val classes: String): Modifier.Element

class Classes : Modifier.Element {

    private var classes: String = ""

    operator fun String.unaryPlus() {
        classes += " $this"
    }

    fun build(): String {
        return toString()
    }

    inline fun toggle(classes: String, predicate: () -> Boolean) {
        if (predicate())
            +classes
    }

    override fun toString(): String {
        return classes
    }
}

///**
// * Provides access to underlying HTML element
// */
//internal class RefModifier(val configure: HTMLElement.() -> Unit): Modifier.Element

@Composable
fun Modifier.style(css: @Composable Css.() -> Unit): Modifier {
    // Apply can't take composable so we call it with context
    return this.then(CssModifier(Css().apply { css() }))
}


fun Modifier.attr(name: String, value: String): Modifier = AttrModifier(name, value)

//@Composable
//fun Modifier.classes(name: String, value: String): Modifier = AttrModifier(name, value)

expect fun Modifier.onEvent(name: String, event: Event) : Modifier