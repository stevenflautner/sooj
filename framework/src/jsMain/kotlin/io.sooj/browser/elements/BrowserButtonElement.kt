package io.sooj.browser.elements

import org.w3c.dom.HTMLButtonElement

actual class BrowserButtonElement(override val jsElem: HTMLButtonElement) : BrowserElement(jsElem) {
    actual var autofocus: Boolean
        get() = jsElem.autofocus
        set(value) { jsElem.autofocus = value }
    actual var disabled: Boolean
        get() = jsElem.disabled
        set(value) { jsElem.disabled = value }
    actual val form: BrowserFormElement?
        get() = jsElem.form?.toBrowserElement() as? BrowserFormElement
    actual var formAction: String
        get() = jsElem.formAction
        set(value) { jsElem.formAction = value }
    actual var formEnctype: String
        get() = jsElem.formEnctype
        set(value) { jsElem.formEnctype = value }
    actual var formMethod: String
        get() = jsElem.formMethod
        set(value) { jsElem.formMethod = value }
    actual var formNoValidate: Boolean
        get() = jsElem.formNoValidate
        set(value) { jsElem.formNoValidate = value }
    actual var formTarget: String
        get() = jsElem.formTarget
        set(value) { jsElem.formTarget = value }
    actual var name: String
        get() = jsElem.name
        set(value) { jsElem.name = value }
    actual var type: String
        get() = jsElem.type
        set(value) { jsElem.type = value }
    actual var value: String
        get() = jsElem.value
        set(value) { jsElem.value = value }
    actual val willValidate: Boolean
        get() = jsElem.willValidate
    actual val validationMessage: String
        get() = jsElem.validationMessage

    actual fun checkValidity(): Boolean = jsElem.checkValidity()
    actual fun reportValidity(): Boolean = jsElem.reportValidity()
    actual fun setCustomValidity(error: String) = jsElem.setCustomValidity(error)
}