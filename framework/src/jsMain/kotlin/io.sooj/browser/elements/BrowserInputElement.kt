package io.sooj.browser.elements

import org.w3c.dom.HTMLInputElement

actual class BrowserInputElement(override val jsElem: HTMLInputElement)
    : BrowserElement(jsElem) {

    actual var accept: String
        get() = jsElem.accept
        set(value) { jsElem.accept = value }
    actual var alt: String
        get() = jsElem.alt
        set(value) { jsElem.alt = value }
    actual var autocomplete: String
        get() = jsElem.alt
        set(value) { jsElem.alt = value }
    actual var autofocus: Boolean
        get() = jsElem.autofocus
        set(value) { jsElem.autofocus = value }
    actual var defaultChecked: Boolean
        get() = jsElem.defaultChecked
        set(value) { jsElem.defaultChecked = value }
    actual var checked: Boolean
        get() = jsElem.checked
        set(value) { jsElem.checked = value }
    actual var dirName: String
        get() = jsElem.dirName
        set(value) { jsElem.dirName = value }
    actual var disabled: Boolean
        get() = jsElem.disabled
        set(value) { jsElem.disabled = value }
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
    actual var height: Int
        get() = jsElem.height
        set(value) { jsElem.height = value }
    actual var indeterminate: Boolean
        get() = jsElem.indeterminate
        set(value) { jsElem.indeterminate = value }
    actual var inputMode: String
        get() = jsElem.inputMode
        set(value) { jsElem.inputMode = value }
    actual var max: String
        get() = jsElem.max
        set(value) { jsElem.max = value }
    actual var maxLength: Int
        get() = jsElem.maxLength
        set(value) { jsElem.maxLength = value }
    actual var min: String
        get() = jsElem.min
        set(value) { jsElem.min = value }
    actual var minLength: Int
        get() = jsElem.minLength
        set(value) { jsElem.minLength = value }
    actual var multiple: Boolean
        get() = jsElem.multiple
        set(value) { jsElem.multiple = value }
    actual var name: String
        get() = jsElem.name
        set(value) { jsElem.name = value }
    actual var pattern: String
        get() = jsElem.pattern
        set(value) { jsElem.pattern = value }
    actual var placeholder: String
        get() = jsElem.placeholder
        set(value) { jsElem.placeholder = value }
    actual var readOnly: Boolean
        get() = jsElem.readOnly
        set(value) { jsElem.readOnly = value }
    actual var required: Boolean
        get() = jsElem.required
        set(value) { jsElem.required = value }
    actual var size: Int
        get() = jsElem.size
        set(value) { jsElem.size = value }
    actual var src: String
        get() = jsElem.src
        set(value) { jsElem.src = value }
    actual var step: String
        get() = jsElem.step
        set(value) { jsElem.step = value }
    actual var type: String
        get() = jsElem.type
        set(value) { jsElem.type = value }
    actual var defaultValue: String
        get() = jsElem.defaultValue
        set(value) { jsElem.defaultValue = value }
    actual var value: String
        get() = jsElem.value
        set(value) { jsElem.value = value }
    actual var valueAsNumber: Double
        get() = jsElem.valueAsNumber
        set(value) { jsElem.valueAsNumber = value }
    actual var width: Int
        get() = jsElem.width
        set(value) { jsElem.width = value }
    actual val willValidate: Boolean
        get() = jsElem.willValidate
    actual val validationMessage: String
        get() = jsElem.validationMessage
    actual var selectionStart: Int?
        get() = jsElem.selectionStart
        set(value) { jsElem.selectionStart = value }
    actual var selectionEnd: Int?
        get() = jsElem.selectionEnd
        set(value) { jsElem.selectionEnd = value }
    actual var selectionDirection: String?
        get() = jsElem.selectionDirection
        set(value) { jsElem.selectionDirection = value }
    actual var align: String
        get() = jsElem.align
        set(value) { jsElem.align = value }
    actual var useMap: String
        get() = jsElem.useMap
        set(value) { jsElem.useMap = value }

    actual fun checkValidity(): Boolean = jsElem.checkValidity()

    actual fun reportValidity(): Boolean = jsElem.reportValidity()

    actual fun setCustomValidity(error: String) = jsElem.setCustomValidity(error)

    actual fun select() = jsElem.select()

    actual fun setRangeText(replacement: String) = jsElem.setRangeText(replacement)

    actual fun setSelectionRange(start: Int, end: Int, direction: String) = jsElem.setSelectionRange(start, end, direction)
}