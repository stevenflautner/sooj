@file:JvmMultifileClass
@file:JvmName("Endpoint_")

package io.sooj.net

import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

expect abstract class EndpointBase<REQ: Any, RESP: Any>(cookies: List<String>?) {
    val cookies: List<String>?
}
abstract class Endpoint<REQ: Any, RESP: Any>(cookies: List<String>? = null) : EndpointBase<REQ, RESP>(cookies)

//abstract class FormEndpoint<REQ: Any, RESP: Any>(
//    val validator: (FormValidator.() -> Unit)? = null,
//    cookies: List<String>? = null
//) : EndpointBase<REQ, RESP>(cookies)

internal fun parseApiRoute(className: Any) = "/api/${className::class.simpleName}"