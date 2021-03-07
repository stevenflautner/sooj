package io.sooj.browser.elements

import io.sooj.BrowserOnly

actual class BrowserInputElement : BrowserElement() {
    actual var accept: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var alt: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var autocomplete: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var autofocus: Boolean
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var defaultChecked: Boolean
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var checked: Boolean
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var dirName: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var disabled: Boolean
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
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
    actual var height: Int
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var indeterminate: Boolean
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var inputMode: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var max: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var maxLength: Int
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var min: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var minLength: Int
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var multiple: Boolean
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var name: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var pattern: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var placeholder: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var readOnly: Boolean
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var required: Boolean
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var size: Int
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var src: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var step: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var type: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var defaultValue: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var value: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var valueAsNumber: Double
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var width: Int
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual val willValidate: Boolean
        get() = TODO("Not yet implemented")
    actual val validationMessage: String
        get() = TODO("Not yet implemented")
    actual var selectionStart: Int?
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var selectionEnd: Int?
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var selectionDirection: String?
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var align: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }
    actual var useMap: String
        get() = throw BrowserOnly
        set(value) { throw BrowserOnly }

    actual fun checkValidity(): Boolean {
        TODO("Not yet implemented")
    }

    actual fun reportValidity(): Boolean {
        TODO("Not yet implemented")
    }

    actual fun setCustomValidity(error: String) {
    }

    actual fun select() {
    }

    actual fun setRangeText(replacement: String) {
    }

    actual fun setSelectionRange(start: Int, end: Int, direction: String) {
    }
}