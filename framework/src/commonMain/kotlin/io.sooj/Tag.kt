package io.sooj

import Modifier
import androidx.compose.runtime.Composable

@Composable
expect fun tag(modifier: Modifier, tagName: String, content: @Composable () -> Unit)

@Composable
expect fun text(value: String)