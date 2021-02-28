package io.sooj

import Modifier

fun Modifier.onClick(action: () -> Unit): Modifier = event("click", action)

//fun Modifier.onInput(action: (InputEvent) -> Unit): Modifier =
//    event("input", EventListener { action(it as InputEvent) })
//
//fun Modifier.onKeyUp(action: (KeyboardEvent) -> Unit): Modifier =
//    event("keyup", EventListener { action(it as KeyboardEvent) })
