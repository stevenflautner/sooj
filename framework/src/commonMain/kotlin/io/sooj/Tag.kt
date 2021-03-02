package io.sooj

import Modifier
import androidx.compose.runtime.Composable

@Composable
expect fun Component.tag(tagName: String, modifier: Modifier, content: @Composable Component.() -> Unit)

@Composable
expect fun text(value: String)