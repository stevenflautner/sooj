package io.sooj

import Modifier

actual fun Modifier.event(eventName: String, listener: () -> Unit) : Modifier =
    this.then(EventModifier(eventName, listener))

/**
 * Adds an io.sooj.event listener for the target node which is applied on node recomposition
 */
actual class EventModifier(
    eventName: String,
    val listener: () -> Unit
) : EventModifierBase(eventName)