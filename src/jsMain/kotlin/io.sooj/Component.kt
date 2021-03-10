package io.sooj

import io.sooj.router.Router

actual class Component(
    actual val router: Router,
    actual val currentRouteLevel: Int
) {
    actual val descendedRouteLevelCopy: Component
        get() = Component(
            router,
            currentRouteLevel + 1
        )
}