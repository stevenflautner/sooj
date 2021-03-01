package io.sooj.browser

/**
 * Common representation of any object that can only
 * live in the browser
 */
actual open class BrowserAny(private val any: Any) {

    /**
     * Returns a property of the js object if exists, otherwise null
     */
    actual fun <T> getPropOrNull(name: String): T? {
        return try {
            any.asDynamic()[name] as? T
        } catch (e: Exception) {
            null
        }
    }
    /**
     * Returns a property of the js object throws an exception if
     * there's no corresponding property
     */
    actual fun <T> getProp(name: String): T = getPropOrNull(name) ?: error("Prop was null")

}

/**
 * Converts any browser object to it's common representation
 *
 * Use this if you want access to a JS Object's properties
 * from the common source
 */
fun Any.toBrowserAny() = BrowserAny(this)