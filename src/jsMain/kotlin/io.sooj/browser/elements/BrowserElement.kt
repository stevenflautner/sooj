package io.sooj.browser.elements

import io.sooj.browser.BrowserAny
import org.w3c.dom.Element
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLFormElement
import org.w3c.dom.HTMLInputElement

// TODO THERE'S A LOT OF BS IN HERE
//  API ELEMS SHOULD NOT BE ELEMENT RELATED
actual open class BrowserElement(_jsElem: Element) : BrowserAny(_jsElem) {

    open val jsElem = _jsElem

//    actual fun setClasses(classes: String) {
//        domElem.className = classes
//    }
//
//    actual fun getWidth() = domElem.getBoundingClientRect().width
//    actual fun getHeight() = domElem.getBoundingClientRect().height
//
//    actual fun setWidth(width: Double) {
//        if (domElem is HTMLElement) {
//            domElem.style.width = "${width}px"
//        }
//    }
//
//    actual fun setHeight(height: Double) {
//        if (domElem is HTMLElement) {
//            domElem.style.height = "${height}px"
//        }
//    }
//
//    actual fun getAttribute(name: String): String? {
//        if (name == "value" && domElem is HTMLInputElement) {
//            return domElem.value
//        }
//        return domElem.getAttribute(name)
//    }
//
//    actual fun getTop() = domElem.getBoundingClientRect().top
//    actual fun getLeft() = domElem.getBoundingClientRect().left
//
//    actual fun setLeft(left: Double) {
//        if (domElem is HTMLElement) {
//            domElem.style.left = "${left}px"
//        }
//    }
//    actual fun setTop(top: Double) {
//        if (domElem is HTMLElement) {
//            domElem.style.top = "${top.toInt()}px"
//        }
//    }
////    actual fun getY() = domElem.getBoundingClientRect().height
//    actual fun getScrollTop(): Double {
//        return domElem.scrollTop
//    }
//
//    actual fun setScrollTop(scrollTop: Double) {
//        domElem.scroll(0.0, scrollTop)
//    }
//
//    actual fun getScrollLeft(): Double {
//        return domElem.scrollLeft
//    }
//
//    actual fun setScrollLeft(scrollLeft: Double) {
//        domElem.scroll(scrollLeft, 0.0)
//    }
//
//    actual fun focus() {
//        (domElem as HTMLElement).focus()
//    }
}

/**
 * Converts any browser element to it's common representation
 */
fun Element.toBrowserElement(): BrowserElement = when (this) {
    is HTMLInputElement -> BrowserInputElement(this)
    is HTMLFormElement -> BrowserFormElement(this)
    is HTMLButtonElement -> BrowserButtonElement(this)
    else -> BrowserElement(this)
}