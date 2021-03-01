package io.sooj.browser

import io.sooj.BrowserOnly
import io.sooj.browser.elements.BrowserElement

actual class BrowserEvent<T: BrowserElement>: BrowserAny() {

    actual val type: String
        get() = throw BrowserOnly
    actual val target: BrowserElement
        get() = throw BrowserOnly
    actual val currentTarget: T
        get() = throw BrowserOnly
    actual val eventPhase: Short
        get() = throw BrowserOnly
    actual val bubbles: Boolean
        get() = throw BrowserOnly
    actual val cancelable: Boolean
        get() = throw BrowserOnly
    actual val defaultPrevented: Boolean
        get() = throw BrowserOnly
    actual val composed: Boolean
        get() = throw BrowserOnly
    actual val isTrusted: Boolean
        get() = throw BrowserOnly
    actual val timeStamp: Number
        get() = throw BrowserOnly

    actual fun stopPropagation() { throw BrowserOnly }
    actual fun stopImmediatePropagation() { throw BrowserOnly }
    actual fun preventDefault() { throw BrowserOnly }

    /**
     * The element that the event listener was added to
     * same as currentTarget
     */
    actual val sourceElement get() = currentTarget

}

