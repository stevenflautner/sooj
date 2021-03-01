package io.sooj.browser.elements

import io.sooj.BrowserOnly

actual class BrowserFormElement : BrowserElement() {
    actual var acceptCharset: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var action: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var autocomplete: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var enctype: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var encoding: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var method: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var name: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var noValidate: Boolean
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var target: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual val length: Int
        get() = throw BrowserOnly

    actual fun submit() {
        throw BrowserOnly
    }

    actual fun reset() {
        throw BrowserOnly
    }

    actual fun checkValidity(): Boolean {
        throw BrowserOnly
    }

    actual fun reportValidity(): Boolean {
        throw BrowserOnly
    }
}