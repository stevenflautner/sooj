package io.sooj

import Modifier
import org.w3c.dom.events.EventListener

actual fun Modifier.event(eventName: String, listener: () -> Unit) : Modifier =
    this.then(EventModifier(eventName, EventListener { listener() }))

/**
 * Adds an event listener for the target node which is applied on node recomposition
 */
actual class EventModifier(
    eventName: String,
    val listener: EventListener
) : EventModifierBase(eventName)