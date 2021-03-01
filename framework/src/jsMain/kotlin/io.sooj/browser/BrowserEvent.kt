package io.sooj.browser

import io.sooj.browser.elements.BrowserElement
import io.sooj.browser.elements.BrowserInputElement
import io.sooj.browser.elements.toBrowserElement
import org.w3c.dom.Element
import org.w3c.dom.events.Event

fun Event.toBrowserEvent() = BrowserEvent<BrowserElement>(this)

actual class BrowserEvent<T: BrowserElement>(
    val jsEvent: Event,
): BrowserAny(jsEvent) {
    actual val type: String
        get() = jsEvent.type
    actual val target: BrowserElement
        get() = (jsEvent.target as Element).toBrowserElement()
    actual val currentTarget
        get() = (jsEvent.currentTarget as Element).toBrowserElement() as T
    actual val eventPhase: Short
        get() = jsEvent.eventPhase
    actual val bubbles: Boolean
        get() = jsEvent.bubbles
    actual val cancelable: Boolean
        get() = jsEvent.cancelable
    actual val defaultPrevented: Boolean
        get() = jsEvent.defaultPrevented
    actual val composed: Boolean
        get() = jsEvent.composed
    actual val isTrusted: Boolean
        get() = jsEvent.isTrusted
    actual val timeStamp: Number
        get() = jsEvent.timeStamp

    actual fun stopPropagation() = jsEvent.stopPropagation()
    actual fun stopImmediatePropagation() = jsEvent.stopImmediatePropagation()
    actual fun preventDefault() = jsEvent.preventDefault()

    /**
     * The element that the event listener was added to
     * same as currentTarget
     */
    actual val sourceElement get() = currentTarget

}
