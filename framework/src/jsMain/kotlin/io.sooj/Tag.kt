package io.sooj

import Modifier
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import compose.web.internal.JsApplier
import compose.web.internal.NodeWrapper
import kotlinx.browser.document
import org.w3c.dom.Text

@Composable
actual fun Component.tag(tagName: String, modifier: Modifier, content: @Composable Component.() -> Unit) {
    ComposeNode<NodeWrapper, JsApplier>(
        factory = { NodeWrapper(tagName) },
        update = {
            set(modifier) { this.modifier = modifier }
        },
        content = {
            content()
        }
    )
}

@Composable
actual fun Component.text(value: String) {
    ComposeNode<NodeWrapper, JsApplier>(
        factory = { NodeWrapper(document.createTextNode(value)) },
        update = {
            set(value) { value ->
                (realNode as Text).data = value
            }
        },
    )
}