@file:JvmName("Route_")

package io.sooj.router

import io.sooj.Component
import kotlin.jvm.JvmName

expect fun Component.routePage(route: String)

internal expect fun updateUrlParameter(parameters: String)

expect fun String.encodeURLParameter(): String

typealias Parameters = HashMap<String, String>

fun Parameters.formUrlEncode(): String {
    return StringBuilder().apply {
        entries.forEach {
            val key = it.key.encodeURLParameter()
            val value = it.value.encodeURLParameter()

            append("&$key=$value")
        }
    }.toString()
}

class ParsedRoute(raw: String) {

    val routeValues: List<String>
    val parameters: Parameters

    init {
        val split = raw.split("?")
        routeValues = parseRoute(split)
        parameters = parseParameters(split)
    }

    private fun parseParameters(split: List<String>): Parameters = Parameters().apply {
        split.getOrNull(1)?.let { query ->
            val pairs: List<String> = query.split("&")

            for (pair in pairs) {
                val idx = pair.indexOf("=")
                put(pair.substring(0, idx), pair.substring(idx + 1))
            }
        }
    }

    private fun parseRoute(split: List<String>): List<String> {
        val fullRoute = split[0].removePrefix("/")
        val count = fullRoute.count { it == '/' }

        return if (count == 0) {
            listOf(fullRoute)
        } else {
            fullRoute.split("/")
        }
    }
}