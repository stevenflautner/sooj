package io.sooj.platform

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement

actual val platform: Platform = Platform.SERVER
actual var DEV: Boolean = System.getProperty("DEV")?.toBoolean() ?: false

actual fun loadResourceString(src: String): String {
    return String::class.java.classLoader.getResource(src)?.readText()
        ?: throw Exception("Resource does not exists at: $src")
}

actual class BundledResources actual constructor() {

    var id: Int = 0
    val resources = mutableMapOf<String, JsonElement>()

    inline fun <reified T : Any> add(resource: T) {
        resources[id.toString()] = Json.encodeToJsonElement(resource)
        id++
    }

    fun createSnapshot(): String {
        return Json.encodeToString(JsonObject(resources))
    }
}