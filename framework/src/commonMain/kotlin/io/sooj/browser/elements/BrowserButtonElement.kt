package io.sooj.browser.elements

expect class BrowserButtonElement : BrowserElement {
    var autofocus: Boolean
    var disabled: Boolean
    val form: BrowserFormElement?
    var formAction: String
    var formEnctype: String
    var formMethod: String
    var formNoValidate: Boolean
    var formTarget: String
    var name: String
    var type: String
    var value: String
//    var menu: BrowserMenuElement?
    val willValidate: Boolean
//    val validity: ValidityState
    val validationMessage: String
//    val labels: NodeList
    fun checkValidity(): Boolean
    fun reportValidity(): Boolean
    fun setCustomValidity(error: String)
}