package io.sooj.net

import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

actual abstract class EndpointBase<REQ : Any, RESP : Any>
    actual constructor(
        actual val cookies: List<String>?
    ) {

    val route = parseApiRoute(this)
    lateinit var implementedFunc: suspend ApplicationCall.(REQ) -> RESP
}

inline fun <reified REQ: Any, reified RESP: Any> Routing.endpoint(
    endpoint: Endpoint<REQ, RESP>,
    noinline func: suspend ApplicationCall.(REQ) -> RESP
) {
    endpoint.implementedFunc = func

    post(endpoint.route) {
//        val contentType = call.request.contentType()
//        val request = when {
//            contentType.match(ContentType.MultiPart.FormData) -> {
//                // Parse as multipart/form data instead of JSON
//                call.parseMultipart<REQ>()
//            }
//            contentType.match(ContentType.Application.Json) -> {
//                val json = call.receive<String>().removeSurrounding("\"")
//                Json.decodeFromString(json)
//            }
//            else -> throw Exception("Content type could not be handled by endpoint at ${endpoint.route}")
//        }
//        val json = call.receive<String>().removeSurrounding("\"")
//        println("RECEIUVED JDS : ")
//        println(json)
//        val request = Json.decodeFromStringStatic<REQ>(json)
        val request = call.receive<REQ>()

        val response = call.func(request)
        call.respond(response)
    }
    println("Endpoint serving at ${endpoint.route}")
}

//inline fun <reified REQ: Any, reified RESP: Any> Routing.formEndpoint(
//    endpoint: FormEndpoint<REQ, RESP>,
//    noinline func: suspend ApplicationCall.(REQ) -> RESP
//) {
//    endpoint.implementedFunc = func
//
//    post(endpoint.route) {
//        // Parse as multipart/form data instead of JSON
//        val requestMap = call.parseMultipart<REQ>()
//
//        val validator = endpoint.validator
//        if (validator != null) {
//            // Perform custom logic against form snapshot
//            val customValidator = FormValidator(requestMap).apply {
//                validator()
//            }
//            println("THIS IS THE VALUES")
//            println(requestMap)
//            if (customValidator.validationError != null) {
//                throw Exception("""
//Form validation failed on the server, this should not happen if you used Skipn's form
//mechanic to post the form. If you did, it's a bug. This went wrong: ${customValidator.validationError}
//                """.trimIndent())
//            }
//        }
//
//        val request = convertMapToInstance<REQ>(requestMap)
//        val response = call.func(request)
//        call.respond(response)
//    }
//    println("Endpoint serving at ${endpoint.route}")
//}