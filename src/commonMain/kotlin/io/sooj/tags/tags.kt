package io.sooj.tags

import Modifier
import androidx.compose.runtime.Composable
import io.sooj.Component
import io.sooj.browser.BrowserEvent
import io.sooj.browser.elements.BrowserInputElement
import io.sooj.modifiers.Event
import io.sooj.modifiers.*
import io.sooj.tag
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit

@Composable
public fun Component.a(
  classes: String? = null,
  href: String? = null,
  target: String? = null,
  rel: String? = null,
  ariaLabel: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("a", mod.classes(classes).href(href).target(target).rel(rel).ariaLabel(ariaLabel), content =
      content)
}

@Composable
public fun Component.article(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("article", mod.classes(classes), content = content)
}

@Composable
public fun Component.aside(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("aside", mod.classes(classes), content = content)
}

@Composable
public fun Component.body(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("body", mod.classes(classes), content = content)
}

@Composable
public fun Component.b(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("b", mod.classes(classes), content = content)
}

@Composable
public fun Component.button(
  classes: String? = null,
  ariaLabel: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("button", mod.classes(classes).ariaLabel(ariaLabel), content = content)
}

@Composable
public fun Component.br(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("br", mod.classes(classes), content = content)
}

@Composable
public fun Component.caption(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("caption", mod.classes(classes), content = content)
}

@Composable
public fun Component.colgroup(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("colgroup", mod.classes(classes), content = content)
}

@Composable
public fun Component.col(
  classes: String? = null,
  span: Int? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("col", mod.classes(classes).span(span), content = content)
}

@Composable
public fun Component.details(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("details", mod.classes(classes), content = content)
}

@Composable
public fun Component.div(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("div", mod.classes(classes), content = content)
}

@Composable
public fun Component.em(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("em", mod.classes(classes), content = content)
}

@Composable
public fun Component.figcaption(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("figcaption", mod.classes(classes), content = content)
}

@Composable
public fun Component.figure(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("figure", mod.classes(classes), content = content)
}

@Composable
public fun Component.footer(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("footer", mod.classes(classes), content = content)
}

@Composable
public fun Component.h1(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("h1", mod.classes(classes), content = content)
}

@Composable
public fun Component.h2(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("h2", mod.classes(classes), content = content)
}

@Composable
public fun Component.h3(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("h3", mod.classes(classes), content = content)
}

@Composable
public fun Component.h4(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("h4", mod.classes(classes), content = content)
}

@Composable
public fun Component.h5(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("h5", mod.classes(classes), content = content)
}

@Composable
public fun Component.h6(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("h6", mod.classes(classes), content = content)
}

@Composable
public fun Component.head(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("head", mod.classes(classes), content = content)
}

@Composable
public fun Component.header(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("header", mod.classes(classes), content = content)
}

@Composable
public fun Component.hr(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("hr", mod.classes(classes), content = content)
}

@Composable
public fun Component.i(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("i", mod.classes(classes), content = content)
}

@Composable
public fun Component.img(
  classes: String? = null,
  src: String? = null,
  alt: String? = null,
  width: String? = null,
  height: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("img", mod.classes(classes).src(src).alt(alt).width(width).height(height), content = content)
}

@Composable
public fun Component.input(
  classes: String? = null,
  type: String? = null,
  maxLength: String? = null,
  value: String? = null,
  name: String? = null,
  placeholder: String? = null,
  ariaLabel: String? = null,
  ariaLabelledBy: String? = null,
  onInput: ((BrowserEvent<BrowserInputElement>) -> Unit)? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("input",
      mod.classes(classes).type(type).maxLength(maxLength).value(value).name(name).placeholder(placeholder).ariaLabel(ariaLabel).ariaLabelledBy(ariaLabelledBy).onInput(onInput
      as Event), content = content)
}

@Composable
public fun Component.label(
  classes: String? = null,
  forId: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("label", mod.classes(classes).forId(forId), content = content)
}

@Composable
public fun Component.li(
  classes: String? = null,
  value: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("li", mod.classes(classes).value(value), content = content)
}

@Composable
public fun Component.link(
  classes: String? = null,
  href: String? = null,
  rel: String? = null,
  hrefLang: String? = null,
  media: String? = null,
  type: String? = null,
  sizes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("link",
      mod.classes(classes).href(href).rel(rel).hrefLang(hrefLang).media(media).type(type).sizes(sizes),
      content = content)
}

@Composable
public fun Component.mark(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("mark", mod.classes(classes), content = content)
}

@Composable
public fun Component.main(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("main", mod.classes(classes), content = content)
}

@Composable
public fun Component.meta(
  classes: String? = null,
  name: String? = null,
  htmlContent: String? = null,
  charset: String? = null,
  httpEquiv: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("meta",
      mod.classes(classes).name(name).htmlContent(htmlContent).charset(charset).httpEquiv(httpEquiv),
      content = content)
}

@Composable
public fun Component.nav(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("nav", mod.classes(classes), content = content)
}

@Composable
public fun Component.option(
  classes: String? = null,
  value: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("option", mod.classes(classes).value(value), content = content)
}

@Composable
public fun Component.p(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("p", mod.classes(classes), content = content)
}

@Composable
public fun Component.script(
  classes: String? = null,
  async: Boolean = false,
  defer: Boolean = false,
  type: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("script", mod.classes(classes).async(async).defer(defer).type(type), content = content)
}

@Composable
public fun Component.section(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("section", mod.classes(classes), content = content)
}

@Composable
public fun Component.select(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("select", mod.classes(classes), content = content)
}

@Composable
public fun Component.source(
  classes: String? = null,
  src: String? = null,
  type: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("source", mod.classes(classes).src(src).type(type), content = content)
}

@Composable
public fun Component.span(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("span", mod.classes(classes), content = content)
}

@Composable
public fun Component.strong(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("strong", mod.classes(classes), content = content)
}

@Composable
public fun Component.summary(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("summary", mod.classes(classes), content = content)
}

@Composable
public fun Component.table(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("table", mod.classes(classes), content = content)
}

@Composable
public fun Component.tbody(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("tbody", mod.classes(classes), content = content)
}

@Composable
public fun Component.tfoot(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("tfoot", mod.classes(classes), content = content)
}

@Composable
public fun Component.th(
  classes: String? = null,
  colspan: Int? = null,
  rowspan: Int? = null,
  abbr: String? = null,
  headers: String? = null,
  scope: String? = null,
  sorted: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("th",
      mod.classes(classes).colspan(colspan).rowspan(rowspan).abbr(abbr).headers(headers).scope(scope).sorted(sorted),
      content = content)
}

@Composable
public fun Component.thead(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("thead", mod.classes(classes), content = content)
}

@Composable
public fun Component.time(
  classes: String? = null,
  datetime: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("time", mod.classes(classes).datetime(datetime), content = content)
}

@Composable
public fun Component.tr(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("tr", mod.classes(classes), content = content)
}

@Composable
public fun Component.td(
  classes: String? = null,
  colspan: Int? = null,
  rowspan: Int? = null,
  headers: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("td", mod.classes(classes).colspan(colspan).rowspan(rowspan).headers(headers), content =
      content)
}

@Composable
public fun Component.video(
  classes: String? = null,
  muted: Boolean = false,
  playsinline: Boolean = false,
  autoplay: Boolean = false,
  loop: Boolean = false,
  preload: String? = null,
  poster: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("video",
      mod.classes(classes).muted(muted).playsinline(playsinline).autoplay(autoplay).loop(loop).preload(preload).poster(poster),
      content = content)
}

@Composable
public fun Component.ul(
  classes: String? = null,
  mod: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("ul", mod.classes(classes), content = content)
}
