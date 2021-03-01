package io.sooj.modifiers

import Modifier

actual fun Modifier.onEvent(name: String, event: Event) : Modifier =
    this.then(EventModifier(name, event))

/**
 * Adds an event listener for the target node which is applied on node recomposition
 */
actual class EventModifier(
    name: String,
    val event: Event
) : EventModifierBase(name)