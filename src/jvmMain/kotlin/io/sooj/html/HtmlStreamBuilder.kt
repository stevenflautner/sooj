package io.sooj.html

import Modifier
import io.sooj.modifiers.AttrModifier
import io.sooj.modifiers.ClassesModifier
import io.sooj.modifiers.CssModifier

class HTMLStreamBuilder<out O : Appendable>(
        val out: O,
        val prettyPrint: Boolean,
) {

    private var level = 0
    private var ln = true

//    override var routeLevel: Int = 0
//    override val routerTree = ArrayDeque<String>()

//    override var currentBuildContext = rootBuildContext

    fun onTagStart(
        tagName: String,
        namespace: String?,
        modifier: Modifier
    ) {
        //todo this
//        if (prettyPrint && !tag.inlineTag) {
//            indent()
//        }
        level++

        out.append("<")
        out.append(tagName)

        if (namespace != null) {
            out.append(" xmlns=\"")
            out.append(namespace)
            out.append("\"")
        }

        modifier.foldIn(out) { acc, mod ->
            acc.apply {
                when (mod) {
                    is AttrModifier -> {
                        if (mod.value != null) {
                            out.append(' ')
                            out.append(mod.name)
                            out.append("=\"")
                            out.escapeAppend(mod.value.toString())
                            out.append('\"')
                        }
                    }
                    is CssModifier -> {
                        out.append(' ')
                        out.append("style")
                        out.append("=\"")
//                        out.escapeAppend()
                        out.append('\"')
                    }
                    is ClassesModifier -> {
                        out.append(' ')
                        out.append("class")
                        out.append("=\"")
                        out.escapeAppend(mod.classes ?: "")
                        out.append('\"')
                    }
                }
            }
        }

//        if (tag.attributes.isNotEmpty()) {
//            tag.attributesEntries.forEachIndexed { _, e ->
//                if (!e.key.isValidXmlAttributeName()) {
//                    throw IllegalArgumentException("Tag ${tag.tagName} has invalid attribute name ${e.key}")
//                }
//
//                out.append(' ')
//                out.append(e.key)
//                out.append("=\"")
//                out.escapeAppend(e.value)
//                out.append('\"')
//            }
//        }

//        if (xhtmlCompatible && tag.emptyTag) {
//            out.append("/")
//        }

        out.append(">")
        ln = false
    }

    fun onTagEnd(tagName: String) {
//        val id = tag.attributes["id"]

//        ascendRoute(id)

        level--
        if (ln) {
            indent()
        }

        //todo this
//        if (!tag.emptyTag) {
//            out.append("</")
//            out.append(tag.tagName)
//            out.append(">")
//        }
        out.append("</")
        out.append(tagName)
        out.append(">")

        //todo this
//        if (prettyPrint && !tag.inlineTag) {
//            appendln()
//        }
        if (prettyPrint) {
            appendln()
        }
    }

    fun onText(value: String) {
        out.escapeAppend(value)
        ln = false
    }

//    override fun onTagContent(content: CharSequence) {
//        out.escapeAppend(content)
//        ln = false
//    }
//
//    override fun onTagContentEntity(entity: Entities) {
//        out.append(entity.text)
//        ln = false
//    }
//
//    override fun finalize(): O = out
//
//    override fun onTagContentUnsafe(block: Unsafe.() -> Unit) {
//        UnsafeImpl.block()
//    }
//
//    override fun onTagComment(content: CharSequence) {
//        if (prettyPrint) {
//            indent()
//        }
//
//        out.append("<!--")
//        out.escapeComment(content)
//        out.append("-->")
//
//        ln = false
//    }

//    val UnsafeImpl = object : Unsafe {
//        override operator fun String.unaryPlus() {
//            out.append(this)
//        }
//    }

    private fun appendln() {
        if (prettyPrint && !ln) {
            out.append("\n")
            ln = true
        }
    }

    private fun indent() {
        if (prettyPrint) {
            if (!ln) {
                out.append("\n")
            }
            var remaining = level
            while (remaining >= 4) {
                out.append("        ")
                remaining -= 4
            }
            while (remaining >= 2) {
                out.append("    ")
                remaining -= 2
            }
            if (remaining > 0) {
                out.append("  ")
            }
            ln = false
        }
    }
}

//fun createHTML(prettyPrint: Boolean = true, xhtmlCompatible: Boolean = false) =
//    HTMLStreamBuilder(
//        StringBuilder(AVERAGE_PAGE_SIZE),
//        prettyPrint,
//    ).toString()

private const val AVERAGE_PAGE_SIZE = 32768

val escapeMap = mapOf(
        '<' to "&lt;",
        '>' to "&gt;",
        '&' to "&amp;",
        '\"' to "&quot;"
).let { mappings ->
    val maxCode = mappings.keys.map { it.toInt() }.maxOrNull() ?: -1

    Array(maxCode + 1) { mappings[it.toChar()] }
}

val letterRangeLowerCase = 'a'..'z'
val letterRangeUpperCase = 'A'..'Z'
val digitRange = '0'..'9'

fun Char._isLetter() = this in letterRangeLowerCase || this in letterRangeUpperCase
fun Char._isDigit() = this in digitRange

fun String.isValidXmlAttributeName() =
        !startsWithXml()
                && this.isNotEmpty()
                && (this[0]._isLetter() || this[0] == '_')
                && this.all { it._isLetter() || it._isDigit() || it in "._:-" }

fun String.startsWithXml() = length >= 3
        && (this[0].let { it == 'x' || it == 'X' })
        && (this[1].let { it == 'm' || it == 'M' })
        && (this[2].let { it == 'l' || it == 'L' })

fun Appendable.escapeAppend(s: CharSequence) {
    var lastIndex = 0
    val mappings = escapeMap
    val size = mappings.size

    for (idx in 0..s.length - 1) {
        val ch = s[idx].toInt()
        if (ch < 0 || ch >= size) continue
        val escape = mappings[ch]
        if (escape != null) {
            append(s.substring(lastIndex, idx))
            append(escape)
            lastIndex = idx + 1
        }
    }

    if (lastIndex < s.length) {
        append(s.substring(lastIndex, s.length))
    }
}

fun Appendable.escapeComment(s: CharSequence) {
    var start = 0
    while (start < s.length) {
        val index = s.indexOf("--")
        if (index == -1) {
            if (start == 0) {
                append(s)
            } else {
                append(s, start, s.length)
            }
            break
        }

        append(s, start, index)
        start += 2
    }
}
