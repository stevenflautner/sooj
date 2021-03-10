package io.sooj.net

import kotlinx.serialization.Serializable

expect suspend inline fun <reified REQ: Any, reified RESP: Any> Endpoint<REQ, RESP>.request(request: REQ): RESP

@Serializable
data class ApiError(val msg: String? = null) : Exception()