package io.sooj.browser.elements

import org.w3c.dom.HTMLFormElement

actual class BrowserFormElement(override val jsElem: HTMLFormElement) : BrowserElement(jsElem) {

    actual var acceptCharset: String
        get() = jsElem.acceptCharset
        set(value) { jsElem.acceptCharset = value }
    actual var action: String
        get() = jsElem.action
        set(value) { jsElem.action = value }
    actual var autocomplete: String
        get() = jsElem.autocomplete
        set(value) { jsElem.autocomplete = value }
    actual var enctype: String
        get() = jsElem.enctype
        set(value) { jsElem.enctype = value }
    actual var encoding: String
        get() = jsElem.encoding
        set(value) { jsElem.encoding = value }
    actual var method: String
        get() = jsElem.method
        set(value) { jsElem.method = value }
    actual var name: String
        get() = jsElem.name
        set(value) { jsElem.name = value }
    actual var noValidate: Boolean
        get() = jsElem.noValidate
        set(value) { jsElem.noValidate = value }
    actual var target: String
        get() = jsElem.target
        set(value) { jsElem.target = value }
    actual val length: Int
        get() = jsElem.length

    actual fun submit() = jsElem.submit()

    actual fun reset() = jsElem.reset()

    actual fun checkValidity(): Boolean = jsElem.checkValidity()

    actual fun reportValidity(): Boolean = jsElem.reportValidity()
}