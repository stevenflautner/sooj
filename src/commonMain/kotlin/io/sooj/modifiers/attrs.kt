import io.sooj.modifiers.AttrModifier

public fun Modifier.value(value: Any?): Modifier = then(AttrModifier("value", value))

public fun Modifier.src(src: String?): Modifier = then(AttrModifier("src", src))

public fun Modifier.id(id: String?): Modifier = then(AttrModifier("id", id))

public fun Modifier.width(width: String?): Modifier = then(AttrModifier("width", width))

public fun Modifier.height(height: String?): Modifier = then(AttrModifier("height", height))

public fun Modifier.href(href: String?): Modifier = then(AttrModifier("href", href))

public fun Modifier.target(target: String?): Modifier = then(AttrModifier("target", target))

public fun Modifier.rel(rel: String?): Modifier = then(AttrModifier("rel", rel))

public fun Modifier.ariaLabel(ariaLabel: String?): Modifier = then(AttrModifier("ariaLabel",
    ariaLabel))

public fun Modifier.span(span: Int?): Modifier = then(AttrModifier("span", span))

public fun Modifier.alt(alt: String?): Modifier = then(AttrModifier("alt", alt))

public fun Modifier.maxLength(maxLength: String?): Modifier = then(AttrModifier("maxLength",
    maxLength))

public fun Modifier.name(name: String?): Modifier = then(AttrModifier("name", name))

public fun Modifier.placeholder(placeholder: String?): Modifier = then(AttrModifier("placeholder",
    placeholder))

public fun Modifier.ariaLabelledBy(ariaLabelledBy: String?): Modifier =
    then(AttrModifier("ariaLabelledBy", ariaLabelledBy))

public fun Modifier.forId(forId: String?): Modifier = then(AttrModifier("forId", forId))

public fun Modifier.hrefLang(hrefLang: String?): Modifier = then(AttrModifier("hrefLang", hrefLang))

public fun Modifier.media(media: String?): Modifier = then(AttrModifier("media", media))

public fun Modifier.type(type: String?): Modifier = then(AttrModifier("type", type))

public fun Modifier.sizes(sizes: String?): Modifier = then(AttrModifier("sizes", sizes))

public fun Modifier.charset(charset: String?): Modifier = then(AttrModifier("charset", charset))

public fun Modifier.httpEquiv(httpEquiv: String?): Modifier = then(AttrModifier("httpEquiv",
    httpEquiv))

public fun Modifier.async(async: Boolean?): Modifier = then(AttrModifier("async", async))

public fun Modifier.defer(defer: Boolean?): Modifier = then(AttrModifier("defer", defer))

public fun Modifier.colspan(colspan: Int?): Modifier = then(AttrModifier("colspan", colspan))

public fun Modifier.rowspan(rowspan: Int?): Modifier = then(AttrModifier("rowspan", rowspan))

public fun Modifier.abbr(abbr: String?): Modifier = then(AttrModifier("abbr", abbr))

public fun Modifier.headers(headers: String?): Modifier = then(AttrModifier("headers", headers))

public fun Modifier.scope(scope: String?): Modifier = then(AttrModifier("scope", scope))

public fun Modifier.sorted(sorted: String?): Modifier = then(AttrModifier("sorted", sorted))

public fun Modifier.datetime(datetime: String?): Modifier = then(AttrModifier("datetime", datetime))

public fun Modifier.muted(muted: Boolean?): Modifier = then(AttrModifier("muted", muted))

public fun Modifier.playsinline(playsinline: Boolean?): Modifier = then(AttrModifier("playsinline",
    playsinline))

public fun Modifier.loop(loop: Boolean?): Modifier = then(AttrModifier("loop", loop))

public fun Modifier.preload(preload: String?): Modifier = then(AttrModifier("preload", preload))

public fun Modifier.poster(poster: String?): Modifier = then(AttrModifier("poster", poster))

public fun Modifier.htmlContent(htmlContent: String?): Modifier = then(AttrModifier("htmlContent",
    htmlContent))

public fun Modifier.autoplay(autoplay: Boolean?): Modifier = then(AttrModifier("autoplay",
    autoplay))
