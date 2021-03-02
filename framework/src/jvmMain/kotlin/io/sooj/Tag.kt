package io.sooj

import Modifier
import androidx.compose.runtime.Composable

@Composable
actual fun Component.tag(tagName: String, modifier: Modifier, content: @Composable Component.() -> Unit) {
    builder.onTagStart(tagName, null, modifier)
    content()
    builder.onTagEnd(tagName)
}

@Composable
actual fun text(value: String) {

}