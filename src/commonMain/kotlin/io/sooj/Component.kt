package io.sooj

import io.sooj.router.Router

/**
 * Context for tags to be laid out within.
 * Gives access to router
 * [currentRouteId] is the index of the current route
 * the layout is at.
 *
 * EXAMPLE:
 * Consider the route is the following: "/shop/item/desc"
 * The index represents wherre we currently are in the route.
 *
 * If the [currentRouteId] is 2, it means we are at the "desc".
 * Accessing [currentRoute] where the [currentRouteId] == 2
 * will return "desc"
 * if the route changes to: "/shop/item/img"
 * Accessing [currentRoute] where the [currentRouteId] == 2
 * will return "img".
 */
expect class Component {
    val router: Router
    val currentRouteLevel: Int

    /**
     * Returns this component with [currentRouteLevel]
     * being [currentRouteLevel] + 1
     */
    val descendedRouteLevelCopy: Component
}

//abstract class ComponentBase(router: Router) {
//    val router = Router(route)
//
//}