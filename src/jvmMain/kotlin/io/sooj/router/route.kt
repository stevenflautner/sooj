package io.sooj.router

import io.sooj.BrowserOnly
import io.sooj.Component
import io.ktor.http.*

actual fun String.encodeURLParameter(): String =
    encodeURLParameter(true)

actual fun Component.routePage(route: String): Unit =
    throw BrowserOnly

internal actual fun updateUrlParameter(parameters: String): Unit =
    throw BrowserOnly