package io.sooj.browser.elements

expect class BrowserInputElement : BrowserElement {
    var accept: String
    var alt: String
    var autocomplete: String
    var autofocus: Boolean
    var defaultChecked: Boolean
    var checked: Boolean
    var dirName: String
    var disabled: Boolean
//    val form: HTMLFormElement?
//    val files: FileList?
    var formAction: String
    var formEnctype: String
    var formMethod: String
    var formNoValidate: Boolean
    var formTarget: String
    var height: Int
    var indeterminate: Boolean
    var inputMode: String
//    val list: HTMLElement?
    var max: String
    var maxLength: Int
    var min: String
    var minLength: Int
    var multiple: Boolean
    var name: String
    var pattern: String
    var placeholder: String
    var readOnly: Boolean
    var required: Boolean
    var size: Int
    var src: String
    var step: String
    var type: String
    var defaultValue: String
    var value: String
//    var valueAsDate: dynamic
    var valueAsNumber: Double
    var width: Int
    val willValidate: Boolean
//    val validity: ValidityState
    val validationMessage: String
//    val labels: NodeList
    var selectionStart: Int?
    var selectionEnd: Int?
    var selectionDirection: String?
    var align: String
    var useMap: String
//    fun stepUp(n: Int = definedExternally)
//    fun stepDown(n: Int = definedExternally)
    fun checkValidity(): Boolean
    fun reportValidity(): Boolean
    fun setCustomValidity(error: String)
    fun select()
    fun setRangeText(replacement: String)
//    fun setRangeText(replacement: String, start: Int, end: Int, selectionMode: SelectionMode = definedExternally)
    fun setSelectionRange(start: Int, end: Int, direction: String)
}