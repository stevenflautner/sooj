package model

import kotlin.reflect.KClass

/**
 * Represents an AttrModibute modifier
 * While the HTML parameter for an AttrModibute is always String,
 * giving a parameter a corresponding value and then convert it
 * to string is better
 */
class AttrMod(val name: String, val paramType: KClass<*>)

val attrs = listOf(
    AttrMod("value", Any::class),
    AttrMod("src", String::class),
    AttrMod("id", String::class),
    AttrMod("width", String::class),
    AttrMod("height", String::class),
    AttrMod("href", String::class),
    AttrMod("target", String::class),
    AttrMod("rel", String::class),
    AttrMod("ariaLabel", String::class),
    AttrMod("span", Int::class),
    AttrMod("alt", String::class),
    AttrMod("maxLength", String::class),
    AttrMod("name", String::class),
    AttrMod("placeholder", String::class),
    AttrMod("ariaLabelledBy", String::class),
    AttrMod("forId", String::class),
    AttrMod("hrefLang", String::class),
    AttrMod("media", String::class),
    AttrMod("type", String::class),
    AttrMod("sizes", String::class),
    AttrMod("charset", String::class),
    AttrMod("httpEquiv", String::class),
    AttrMod("async", Boolean::class),
    AttrMod("defer", Boolean::class),
    AttrMod("colspan", Int::class),
    AttrMod("rowspan", Int::class),
    AttrMod("abbr", String::class),
    AttrMod("headers", String::class),
    AttrMod("scope", String::class),
    AttrMod("sorted", String::class),
    AttrMod("datetime", String::class),
    AttrMod("muted", Boolean::class),
    AttrMod("playsinline", Boolean::class),
    AttrMod("loop", Boolean::class),
    AttrMod("preload", String::class),
    AttrMod("poster", String::class),
    AttrMod("htmlContent", String::class),
    AttrMod("autoplay", Boolean::class),
)