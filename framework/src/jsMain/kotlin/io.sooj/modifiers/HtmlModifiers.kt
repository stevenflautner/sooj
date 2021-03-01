package io.sooj.modifiers

import Modifier
import io.sooj.browser.toBrowserEvent
import org.w3c.dom.events.EventListener

actual fun Modifier.onEvent(name: String, event: Event) : Modifier =
    this.then(EventModifier(name, EventListener { event(it.toBrowserEvent()) }))

/**
 * Adds an event listener for the target node which is applied on node recomposition
 */
actual class EventModifier(
    eventName: String,
    val listener: EventListener
) : EventModifierBase(eventName)