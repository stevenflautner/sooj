package io.sooj.ktor

import androidx.compose.runtime.Composable
import io.ktor.application.*
import io.ktor.http.content.*
import io.ktor.routing.*
import io.ktor.util.pipeline.*
import io.sooj.Component
import kotlin.system.measureTimeMillis

fun Routing.soojRouting(app: @Composable Component.() -> Unit, endpoints: Routing.() -> Unit) {
    endpoints()

    static("public") {
        resources("public")
    }

    get("{...}") {
        val time = measureTimeMillis {
            runCatching {
                call.respondServerRenderedContent(app)
            }.onFailure {
                it.printStackTrace()
            }
        }
        println("Served within: ${time}ms")
    }
}