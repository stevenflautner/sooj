package io.sooj.browser

import io.sooj.browser.elements.BrowserElement
import io.sooj.browser.elements.BrowserInputElement

/**
 * Common declaration of event that only lives in the Browser
 * Represents common equivalent of Event from the browser api
 */
expect class BrowserEvent<T: BrowserElement> : BrowserAny {

    val type: String
    val target: BrowserElement
    val currentTarget: T
    val eventPhase: Short
    val bubbles: Boolean
    val cancelable: Boolean
    val defaultPrevented: Boolean
    val composed: Boolean
    val isTrusted: Boolean
    val timeStamp: Number
    fun stopPropagation()
    fun stopImmediatePropagation()
    fun preventDefault()

    /**
     * The element that the event listener was added to
     * same as currentTarget
     */
    val sourceElement: T

}

val BrowserEvent<BrowserInputElement>.fullValue get() = sourceElement.value
val BrowserEvent<BrowserInputElement>.value get(): String = getProp("value")