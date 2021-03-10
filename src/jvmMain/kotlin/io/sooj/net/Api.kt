package io.sooj.net

import io.sooj.BrowserOnly

actual suspend inline fun <reified REQ: Any, reified RESP: Any> Endpoint<REQ, RESP>.request(request: REQ): RESP {
    throw BrowserOnly
}