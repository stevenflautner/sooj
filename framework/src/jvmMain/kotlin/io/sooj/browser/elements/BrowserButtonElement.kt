package io.sooj.browser.elements

import io.sooj.BrowserOnly

actual class BrowserButtonElement : BrowserElement() {
    actual var autofocus: Boolean
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var disabled: Boolean
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual val form: BrowserFormElement?
        get() = throw BrowserOnly
    actual var formAction: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var formEnctype: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var formMethod: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var formNoValidate: Boolean
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var formTarget: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var name: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var type: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var value: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual val willValidate: Boolean
        get() = throw BrowserOnly
    actual val validationMessage: String
        get() = throw BrowserOnly

    actual fun checkValidity(): Boolean {
        throw BrowserOnly
    }
    actual fun reportValidity(): Boolean {
        throw BrowserOnly
    }
    actual fun setCustomValidity(error: String) {
        throw BrowserOnly
    }
}