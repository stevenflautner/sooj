package io.sooj.browser.elements

expect class BrowserFormElement : BrowserElement {
    var acceptCharset: String
    var action: String
    var autocomplete: String
    var enctype: String
    var encoding: String
    var method: String
    var name: String
    var noValidate: Boolean
    var target: String
//    val elements: HTMLFormControlsCollection
    val length: Int
    fun submit()
    fun reset()
    fun checkValidity(): Boolean
    fun reportValidity(): Boolean
}