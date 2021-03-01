package io.sooj

import Modifier
import androidx.compose.runtime.Composable

@Composable
expect fun tag(tagName: String, modifier: Modifier, content: @Composable () -> Unit)

@Composable
expect fun text(value: String)