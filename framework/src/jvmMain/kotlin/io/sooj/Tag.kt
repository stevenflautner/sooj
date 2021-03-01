package io.sooj

import Modifier
import androidx.compose.runtime.Composable

@Composable
actual fun tag(tagName: String, modifier: Modifier, content: @Composable () -> Unit) {
    println("<$tagName ${modifier.foldIn("") { acc, elem -> "$acc $elem" }}>")
    content()
    println("</$tagName>")
}

@Composable
actual fun text(value: String) {

}