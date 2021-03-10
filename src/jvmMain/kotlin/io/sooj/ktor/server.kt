package io.sooj.ktor

import androidx.compose.runtime.Composable
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.sooj.Component
import io.sooj.net.ApiError
import io.sooj.platform.DEV
import io.sooj.utils.buildApiJson
import java.util.concurrent.TimeUnit

fun Application.serveSooj(
    app: @Composable Component.() -> Unit,
    endpoints: Routing.() -> Unit,
) {
    install(ContentNegotiation) {
        json(buildApiJson())

        install(StatusPages) {
            exception<Exception> { cause ->
                cause.printStackTrace()

                if (cause is ApiError) {
                    val msg = cause.msg

                    if (msg == null)
                        call.respond(HttpStatusCode.BadRequest)
                    else
                        call.respond(HttpStatusCode.BadRequest, msg)
                }
            }
        }
    }
    install(CachingHeaders) {
        val cacheAgeMax = TimeUnit.DAYS.toSeconds(365).toInt()
        val cacheMax = CachingOptions(
            cacheControl = CacheControl.MaxAge(
                maxAgeSeconds = cacheAgeMax,
            )
        )

        options { _outgoingContent ->
            val outgoingContent = _outgoingContent.contentType?.withoutParameters() ?: return@options null

            if (outgoingContent.match(ContentType.Image.Any)) {
                return@options CachingOptions(
                    cacheControl = CacheControl.MaxAge(
                        mustRevalidate = false,
                        maxAgeSeconds = 7 * 24 * 60 * 60,
                        visibility = CacheControl.Visibility.Public
                    )
                )
            }

            when (outgoingContent) {
                ContentType.Application.JavaScript -> cacheMax
                ContentType.Text.JavaScript -> cacheMax
                ContentType.Text.CSS -> cacheMax
                else -> null
            }
        }
    }
    install(CORS) {
        method(HttpMethod.Get)
        method(HttpMethod.Post)
        method(HttpMethod.Delete)
        method(HttpMethod.Options)
//        host("localhost:8080")
        if (DEV) {
            host("localhost:8080")
        } else {
            anyHost()
        }
        allowCredentials = true
        header(HttpHeaders.AccessControlAllowOrigin)
        header(HttpHeaders.ContentType)
        exposeHeader(HttpHeaders.ContentType)
        exposeHeader(HttpHeaders.AccessControlAllowOrigin)
//        if (DEV) {
//        }
        header(HttpHeaders.AccessControlAllowCredentials)
        exposeHeader(HttpHeaders.AccessControlAllowCredentials)

    }
    install(Compression) {
        gzip()
    }

    routing {
        soojRouting(app, endpoints)
    }
}