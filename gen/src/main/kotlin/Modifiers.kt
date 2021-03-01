import kotlin.reflect.KClass

/**
 * Represents an attribute modifier
 * While the HTML parameter for an attribute is always String,
 * giving a parameter a corresponding value and then convert it
 * to string is better
 */
class Attr(val name: String, val paramType: KClass<*>)

val attrs = listOf(
    Attr("value", Any::class),
    Attr("src", String::class),
    Attr("id", String::class),
    Attr("width", String::class),
    Attr("height", String::class),
    Attr("href", String::class),
    Attr("target", String::class),
    Attr("rel", String::class),
    Attr("ariaLabel", String::class),
    Attr("span", Int::class),
    Attr("alt", String::class),
    Attr("maxLength", String::class),
    Attr("name", String::class),
    Attr("placeholder", String::class),
    Attr("ariaLabelledBy", String::class),
    Attr("forId", String::class),
    Attr("hrefLang", String::class),
    Attr("media", String::class),
    Attr("type", String::class),
    Attr("sizes", String::class),
    Attr("charset", String::class),
    Attr("httpEquiv", String::class),
    Attr("async", Boolean::class),
    Attr("defer", Boolean::class),
    Attr("colspan", Int::class),
    Attr("rowspan", Int::class),
    Attr("abbr", String::class),
    Attr("headers", String::class),
    Attr("scope", String::class),
    Attr("sorted", String::class),
    Attr("datetime", String::class),
    Attr("muted", Boolean::class),
    Attr("playsinline", Boolean::class),
    Attr("loop", Boolean::class),
    Attr("preload", String::class),
    Attr("poster", String::class),
    Attr("htmlContent", String::class),
    Attr("autoplay", Boolean::class),
)