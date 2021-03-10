package io.sooj.platform

expect val platform: Platform
expect var DEV: Boolean

enum class Platform {
    BROWSER, SERVER
}

/**
 * A resource can be loaded as a string if the appropriate
 * file extension has been added to raw-loader in webpack
 */
expect fun loadResourceString(src: String): String

expect class BundledResources()