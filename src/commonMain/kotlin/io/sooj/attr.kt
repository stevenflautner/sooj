package io.sooj

import Modifier
import io.sooj.modifiers.AttrModifier

fun Modifier.attr(key: String, value: Any?) : Modifier =
    then(AttrModifier(key, value))
fun Modifier.id(value: Any?) : Modifier =
    then(AttrModifier("id", value))
//fun Modifier.classes(value: Any?) : Modifier =
//    then(AttrModifier("class", value))
fun Modifier.value(value: Any?) : Modifier =
    then(AttrModifier("value", value))