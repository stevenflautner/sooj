package io.sooj.browser

import io.sooj.BrowserOnly

/**
 * Common declaration of any object that can only
 * live in the browser.
 *
 * This class should never be instantiated on the server.
 * Invoking any of its function on the server will throw a
 * BrowserOnlyFunction exception at runtime.
 */
actual open class BrowserAny {
    /**
     * Returns a property of the js object if exists, otherwise null
     */
    actual fun <T> getPropOrNull(name: String): T? {
        throw BrowserOnly
    }
    /**
     * Returns a property of the js object throws an exception if
     * there's no corresponding property
     */
    actual fun <T> getProp(name: String): T {
        throw BrowserOnly
    }
}