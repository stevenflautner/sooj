package io.sooj.utils

@JsName("require")
external fun require(module: String): dynamic

fun requireResource(module: String): dynamic {
    return require("../../../../processedResources/browser/main/$module")
}