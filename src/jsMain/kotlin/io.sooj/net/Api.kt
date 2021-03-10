package io.sooj.net

import io.sooj.platform.DEV
import io.sooj.utils.decodeFromStringStatic
import io.sooj.utils.encodeToStringStatic
import kotlinx.browser.window
import kotlinx.coroutines.await
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.json.Json
import org.w3c.fetch.INCLUDE
import org.w3c.fetch.RequestCredentials
import org.w3c.fetch.RequestInit
import org.w3c.fetch.SAME_ORIGIN
import kotlin.js.json

object Api {
    suspend inline fun <reified RESP: Any> post(
        endpoint: EndpointBase<*, RESP>,
        body: Any,
        noinline headers: (kotlin.js.Json.() -> Unit)? = null
    ): RESP {
        val url = if (!DEV) {
            "${window.location.origin}${endpoint.route}"
        } else "http://${window.location.hostname}:${window.location.port}${endpoint.route}"

        val credentials = if (!DEV) RequestCredentials.SAME_ORIGIN
        else RequestCredentials.INCLUDE

        val response = window.fetch(
            url,
            RequestInit(
                method = "post",
                credentials = credentials,
                headers = json().also { headersJson ->

                    // Required so that if we get a 'Set-Cookie' header in the
                    // response it is applied to the browser
//                    headersJson["Credentials"] = "same-origin"
//                    headersJson["Origin"] = "http://localhost:8080"

                    // Send the required cookies to the server
                    endpoint.getCookieString()?.let {
                        headersJson["Cookie"] = it
                    }

                    headers?.let {
                        headersJson.apply(it)
                    }
                },
                body = body
            )
        ).await()

        //todo store cookies after cookies was done
//        if (DEV) {
//            response.headers.get("Set-Cookie")?.let {
//                Cookies.store(it)
//            }
//        }

        if (!response.ok) {
            throw ApiError(response.text().await())
        }

        val json = JSON.stringify(response.json().await())
        return Json.decodeFromStringStatic(json)
    }
}

actual suspend inline fun <reified REQ: Any, reified RESP: Any> Endpoint<REQ, RESP>.request(request: REQ): RESP {
    return Api.post(
        this,
        body = Json.encodeToStringStatic(request),
        headers = {
            set("Content-Type", "application/json")
        },
    )
}

fun EndpointBase<*, *>.getCookieString(): String? {
    cookies?.let { cookieNames ->
//        val browserCookies = Cookies.getAll()
        val cookieString = StringBuilder()

//        cookieNames.forEach { cookieName ->
//            browserCookies[cookieName]?.let {
//                cookieString.append(" $it;")
//            }
//        }
        return cookieString.toString()
    }
    return null
}