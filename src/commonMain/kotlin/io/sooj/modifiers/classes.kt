package io.sooj.modifiers

import Modifier
import androidx.compose.runtime.Composable

fun Modifier.classes(classes: String?): Modifier = then(ClassesModifier(classes))

//@Composable
//fun Modifier.classes(classes: @Composable Classes.() -> Unit): Modifier {
//    return this.then(ClassesModifier(Classes().apply { classes.invoke(this) }.toString()))
//}
@Composable
fun Modifier.classes(classes: Classes): Modifier {
    return this.then(ClassesModifier(classes.toString()))
}