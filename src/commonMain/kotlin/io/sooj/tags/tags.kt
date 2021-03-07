import androidx.compose.runtime.Composable
import io.sooj.Component
import io.sooj.browser.BrowserEvent
import io.sooj.browser.elements.BrowserInputElement
import io.sooj.modifiers.Event
import io.sooj.modifiers.onInput
import io.sooj.tag
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit

@Composable
public fun Component.a(
  href: String? = null,
  target: String? = null,
  rel: String? = null,
  ariaLabel: String? = null,
  modifier: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("a", modifier.href(href).target(target).rel(rel).ariaLabel(ariaLabel), content = content)
}

@Composable
public fun Component.article(modifier: Modifier = Modifier, content: @Composable Component.() ->
    Unit = {}): Unit {
  tag("article", modifier, content = content)
}

@Composable
public fun Component.aside(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit
    = {}): Unit {
  tag("aside", modifier, content = content)
}

@Composable
public fun Component.body(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit =
    {}): Unit {
  tag("body", modifier, content = content)
}

@Composable
public fun Component.b(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit =
    {}): Unit {
  tag("b", modifier, content = content)
}

@Composable
public fun Component.button(
  ariaLabel: String? = null,
  modifier: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("button", modifier.ariaLabel(ariaLabel), content = content)
}

@Composable
public fun Component.br(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit =
    {}): Unit {
  tag("br", modifier, content = content)
}

@Composable
public fun Component.caption(modifier: Modifier = Modifier, content: @Composable Component.() ->
    Unit = {}): Unit {
  tag("caption", modifier, content = content)
}

@Composable
public fun Component.colgroup(modifier: Modifier = Modifier, content: @Composable Component.() ->
    Unit = {}): Unit {
  tag("colgroup", modifier, content = content)
}

@Composable
public fun Component.col(
  span: Int? = null,
  modifier: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("col", modifier.span(span), content = content)
}

@Composable
public fun Component.details(modifier: Modifier = Modifier, content: @Composable Component.() ->
    Unit = {}): Unit {
  tag("details", modifier, content = content)
}

@Composable
public fun Component.div(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit =
    {}): Unit {
  tag("div", modifier, content = content)
}

@Composable
public fun Component.em(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit =
    {}): Unit {
  tag("em", modifier, content = content)
}

@Composable
public fun Component.figcaption(modifier: Modifier = Modifier, content: @Composable Component.() ->
    Unit = {}): Unit {
  tag("figcaption", modifier, content = content)
}

@Composable
public fun Component.figure(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit
    = {}): Unit {
  tag("figure", modifier, content = content)
}

@Composable
public fun Component.footer(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit
    = {}): Unit {
  tag("footer", modifier, content = content)
}

@Composable
public fun Component.h1(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit =
    {}): Unit {
  tag("h1", modifier, content = content)
}

@Composable
public fun Component.h2(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit =
    {}): Unit {
  tag("h2", modifier, content = content)
}

@Composable
public fun Component.h3(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit =
    {}): Unit {
  tag("h3", modifier, content = content)
}

@Composable
public fun Component.h4(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit =
    {}): Unit {
  tag("h4", modifier, content = content)
}

@Composable
public fun Component.h5(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit =
    {}): Unit {
  tag("h5", modifier, content = content)
}

@Composable
public fun Component.h6(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit =
    {}): Unit {
  tag("h6", modifier, content = content)
}

@Composable
public fun Component.head(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit =
    {}): Unit {
  tag("head", modifier, content = content)
}

@Composable
public fun Component.header(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit
    = {}): Unit {
  tag("header", modifier, content = content)
}

@Composable
public fun Component.hr(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit =
    {}): Unit {
  tag("hr", modifier, content = content)
}

@Composable
public fun Component.i(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit =
    {}): Unit {
  tag("i", modifier, content = content)
}

@Composable
public fun Component.img(
  src: String? = null,
  alt: String? = null,
  width: String? = null,
  height: String? = null,
  modifier: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("img", modifier.src(src).alt(alt).width(width).height(height), content = content)
}

@Composable
public fun Component.input(
  type: String? = null,
  maxLength: String? = null,
  value: String? = null,
  name: String? = null,
  placeholder: String? = null,
  ariaLabel: String? = null,
  ariaLabelledBy: String? = null,
  onInput: ((BrowserEvent<BrowserInputElement>) -> Unit)? = null,
  modifier: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("input",
      modifier.type(type).maxLength(maxLength).value(value).name(name).placeholder(placeholder).ariaLabel(ariaLabel).ariaLabelledBy(ariaLabelledBy).onInput(onInput
      as Event), content = content)
}

@Composable
public fun Component.label(
  forId: String? = null,
  modifier: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("label", modifier.forId(forId), content = content)
}

@Composable
public fun Component.li(
  value: String? = null,
  modifier: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("li", modifier.value(value), content = content)
}

@Composable
public fun Component.link(
  href: String? = null,
  rel: String? = null,
  hrefLang: String? = null,
  media: String? = null,
  type: String? = null,
  sizes: String? = null,
  modifier: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("link", modifier.href(href).rel(rel).hrefLang(hrefLang).media(media).type(type).sizes(sizes),
      content = content)
}

@Composable
public fun Component.mark(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit =
    {}): Unit {
  tag("mark", modifier, content = content)
}

@Composable
public fun Component.main(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit =
    {}): Unit {
  tag("main", modifier, content = content)
}

@Composable
public fun Component.meta(
  name: String? = null,
  htmlContent: String? = null,
  charset: String? = null,
  httpEquiv: String? = null,
  modifier: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("meta", modifier.name(name).htmlContent(htmlContent).charset(charset).httpEquiv(httpEquiv),
      content = content)
}

@Composable
public fun Component.nav(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit =
    {}): Unit {
  tag("nav", modifier, content = content)
}

@Composable
public fun Component.option(
  value: String? = null,
  modifier: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("option", modifier.value(value), content = content)
}

@Composable
public fun Component.p(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit =
    {}): Unit {
  tag("p", modifier, content = content)
}

@Composable
public fun Component.script(
  async: Boolean = false,
  defer: Boolean = false,
  type: String? = null,
  modifier: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("script", modifier.async(async).defer(defer).type(type), content = content)
}

@Composable
public fun Component.section(modifier: Modifier = Modifier, content: @Composable Component.() ->
    Unit = {}): Unit {
  tag("section", modifier, content = content)
}

@Composable
public fun Component.select(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit
    = {}): Unit {
  tag("select", modifier, content = content)
}

@Composable
public fun Component.source(
  src: String? = null,
  type: String? = null,
  modifier: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("source", modifier.src(src).type(type), content = content)
}

@Composable
public fun Component.span(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit =
    {}): Unit {
  tag("span", modifier, content = content)
}

@Composable
public fun Component.strong(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit
    = {}): Unit {
  tag("strong", modifier, content = content)
}

@Composable
public fun Component.summary(modifier: Modifier = Modifier, content: @Composable Component.() ->
    Unit = {}): Unit {
  tag("summary", modifier, content = content)
}

@Composable
public fun Component.table(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit
    = {}): Unit {
  tag("table", modifier, content = content)
}

@Composable
public fun Component.tbody(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit
    = {}): Unit {
  tag("tbody", modifier, content = content)
}

@Composable
public fun Component.tfoot(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit
    = {}): Unit {
  tag("tfoot", modifier, content = content)
}

@Composable
public fun Component.th(
  colspan: Int? = null,
  rowspan: Int? = null,
  abbr: String? = null,
  headers: String? = null,
  scope: String? = null,
  sorted: String? = null,
  modifier: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("th",
      modifier.colspan(colspan).rowspan(rowspan).abbr(abbr).headers(headers).scope(scope).sorted(sorted),
      content = content)
}

@Composable
public fun Component.thead(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit
    = {}): Unit {
  tag("thead", modifier, content = content)
}

@Composable
public fun Component.time(
  datetime: String? = null,
  modifier: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("time", modifier.datetime(datetime), content = content)
}

@Composable
public fun Component.tr(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit =
    {}): Unit {
  tag("tr", modifier, content = content)
}

@Composable
public fun Component.td(
  colspan: Int? = null,
  rowspan: Int? = null,
  headers: String? = null,
  modifier: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("td", modifier.colspan(colspan).rowspan(rowspan).headers(headers), content = content)
}

@Composable
public fun Component.video(
  muted: Boolean = false,
  playsinline: Boolean = false,
  autoplay: Boolean = false,
  loop: Boolean = false,
  preload: String? = null,
  poster: String? = null,
  modifier: Modifier = Modifier,
  content: @Composable Component.() -> Unit = {}
): Unit {
  tag("video",
      modifier.muted(muted).playsinline(playsinline).autoplay(autoplay).loop(loop).preload(preload).poster(poster),
      content = content)
}

@Composable
public fun Component.ul(modifier: Modifier = Modifier, content: @Composable Component.() -> Unit =
    {}): Unit {
  tag("ul", modifier, content = content)
}
