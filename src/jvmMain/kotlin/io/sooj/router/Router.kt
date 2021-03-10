package io.sooj.router

import io.sooj.BrowserOnly

actual class Router actual constructor(fullRoute: String) : RouterBase(fullRoute) {

    actual fun changeParameter(key: String, newValue: Any?) {
        throw BrowserOnly
    }

    actual fun changeRoute(fullRoute: String) {
        throw BrowserOnly
    }

    actual fun updateRoute(oldRouteValues: List<String>, newRouteValues: List<String>) {
        throw BrowserOnly
    }

    actual fun updateParameters(oldParameters: Parameters, newParameters: Parameters) {
        throw BrowserOnly
    }
}