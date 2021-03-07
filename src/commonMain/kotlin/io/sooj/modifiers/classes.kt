package io.sooj.modifiers

import Modifier
import androidx.compose.runtime.Composable

fun Modifier.classes(classes: String): Modifier = then(ClassesModifier(classes))

@Composable
fun Modifier.classes(classes: @Composable Classes.() -> Unit): Modifier
    = then(ClassesModifier(Classes().apply { classes() }.build()))