package io.sooj.browser

/**
 * Common declaration of any object that can only
 * live in the browser
 */
expect open class BrowserAny {
    /**
     * Returns a property of the js object if exists, otherwise null
     */
    fun <T> getPropOrNull(name: String): T?
    /**
     * Returns a property of the js object throws an exception if
     * there's no corresponding property
     */
    fun <T> getProp(name: String): T
}