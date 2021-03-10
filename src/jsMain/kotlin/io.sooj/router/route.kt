package io.sooj.router

import io.sooj.Component
import io.sooj.platform.DEV
import kotlinx.browser.window

/**
 * Encodes URL parameter using js specific function
 */
actual fun String.encodeURLParameter(): String = encodeURIComponent(this)

external fun encodeURIComponent(component: String): String

actual fun Component.routePage(route: String) {
    if (!DEV) {
        window.history.pushState(null, route, route)
    }
    router.changeRoute(route)
}

internal actual fun updateUrlParameter(parameters: String) {
    val route = if (parameters.isEmpty()) window.location.pathname
    else window.location.pathname + "?${parameters.removePrefix("&")}"
    window.history.pushState(null, route, route)
}