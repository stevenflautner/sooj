package io.sooj.net

actual abstract class EndpointBase<REQ: Any, RESP: Any> actual constructor(
    actual val cookies: List<String>?
) {
    val route = parseApiRoute(this)
}