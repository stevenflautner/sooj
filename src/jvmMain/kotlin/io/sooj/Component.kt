package io.sooj

import io.sooj.router.Router
import io.sooj.html.HTMLStreamBuilder

actual class Component(
    val builder: HTMLStreamBuilder<*>,
    actual val router: Router,
    actual val currentRouteLevel: Int
) {
    actual val descendedRouteLevelCopy: Component
        get() = Component(
            builder,
            router,
            currentRouteLevel + 1
        )
}