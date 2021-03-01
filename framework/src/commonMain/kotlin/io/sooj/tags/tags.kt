import androidx.compose.runtime.Composable
import io.sooj.browser.BrowserEvent
import io.sooj.browser.elements.BrowserInputElement
import io.sooj.modifiers.Event
import io.sooj.modifiers.onInput
import io.sooj.tag

@Composable
public fun a(
  href: String? = null,
  target: String? = null,
  rel: String? = null,
  ariaLabel: String? = null,
  modifier: Modifier = Modifier,
  content: @Composable () -> Unit = {}
): Unit {
  tag("a", modifier.href(href).target(target).rel(rel).ariaLabel(ariaLabel), content = content)
}

@Composable
public fun article(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("article", modifier, content = content)
}

@Composable
public fun aside(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("aside", modifier, content = content)
}

@Composable
public fun body(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("body", modifier, content = content)
}

@Composable
public fun b(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("b", modifier, content = content)
}

@Composable
public fun button(
  ariaLabel: String? = null,
  modifier: Modifier = Modifier,
  content: @Composable () -> Unit = {}
): Unit {
  tag("button", modifier.ariaLabel(ariaLabel), content = content)
}

@Composable
public fun br(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("br", modifier, content = content)
}

@Composable
public fun caption(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("caption", modifier, content = content)
}

@Composable
public fun colgroup(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("colgroup", modifier, content = content)
}

@Composable
public fun col(
  span: Int? = null,
  modifier: Modifier = Modifier,
  content: @Composable () -> Unit = {}
): Unit {
  tag("col", modifier.span(span), content = content)
}

@Composable
public fun details(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("details", modifier, content = content)
}

@Composable
public fun div(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("div", modifier, content = content)
}

@Composable
public fun em(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("em", modifier, content = content)
}

@Composable
public fun figcaption(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("figcaption", modifier, content = content)
}

@Composable
public fun figure(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("figure", modifier, content = content)
}

@Composable
public fun footer(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("footer", modifier, content = content)
}

@Composable
public fun h1(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("h1", modifier, content = content)
}

@Composable
public fun h2(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("h2", modifier, content = content)
}

@Composable
public fun h3(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("h3", modifier, content = content)
}

@Composable
public fun h4(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("h4", modifier, content = content)
}

@Composable
public fun h5(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("h5", modifier, content = content)
}

@Composable
public fun h6(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("h6", modifier, content = content)
}

@Composable
public fun head(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("head", modifier, content = content)
}

@Composable
public fun header(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("header", modifier, content = content)
}

@Composable
public fun hr(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("hr", modifier, content = content)
}

@Composable
public fun i(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("i", modifier, content = content)
}

@Composable
public fun img(
  src: String? = null,
  alt: String? = null,
  width: String? = null,
  height: String? = null,
  modifier: Modifier = Modifier,
  content: @Composable () -> Unit = {}
): Unit {
  tag("img", modifier.src(src).alt(alt).width(width).height(height), content = content)
}

@Composable
public fun input(
  type: String? = null,
  maxLength: String? = null,
  value: String? = null,
  name: String? = null,
  placeholder: String? = null,
  ariaLabel: String? = null,
  ariaLabelledBy: String? = null,
  modifier: Modifier = Modifier,
  onInput: ((BrowserEvent<BrowserInputElement>) -> Unit)? = null,
  content: @Composable () -> Unit = {}
): Unit {
  tag("input",
      modifier.onInput(onInput as Event).type(type).maxLength(maxLength).value(value).name(name).placeholder(placeholder).ariaLabel(ariaLabel).ariaLabelledBy(ariaLabelledBy),
      content = content)
}

@Composable
public fun label(
  forId: String? = null,
  modifier: Modifier = Modifier,
  content: @Composable () -> Unit = {}
): Unit {
  tag("label", modifier.forId(forId), content = content)
}

@Composable
public fun li(
  value: String? = null,
  modifier: Modifier = Modifier,
  content: @Composable () -> Unit = {}
): Unit {
  tag("li", modifier.value(value), content = content)
}

@Composable
public fun link(
  href: String? = null,
  rel: String? = null,
  hrefLang: String? = null,
  media: String? = null,
  type: String? = null,
  sizes: String? = null,
  modifier: Modifier = Modifier,
  content: @Composable () -> Unit = {}
): Unit {
  tag("link", modifier.href(href).rel(rel).hrefLang(hrefLang).media(media).type(type).sizes(sizes),
      content = content)
}

@Composable
public fun mark(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("mark", modifier, content = content)
}

@Composable
public fun main(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("main", modifier, content = content)
}

@Composable
public fun meta(
  name: String? = null,
  htmlContent: String? = null,
  charset: String? = null,
  httpEquiv: String? = null,
  modifier: Modifier = Modifier,
  content: @Composable () -> Unit = {}
): Unit {
  tag("meta", modifier.name(name).htmlContent(htmlContent).charset(charset).httpEquiv(httpEquiv),
      content = content)
}

@Composable
public fun nav(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("nav", modifier, content = content)
}

@Composable
public fun option(
  value: String? = null,
  modifier: Modifier = Modifier,
  content: @Composable () -> Unit = {}
): Unit {
  tag("option", modifier.value(value), content = content)
}

@Composable
public fun p(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("p", modifier, content = content)
}

@Composable
public fun script(
  async: Boolean = false,
  defer: Boolean = false,
  type: String? = null,
  modifier: Modifier = Modifier,
  content: @Composable () -> Unit = {}
): Unit {
  tag("script", modifier.async(async).defer(defer).type(type), content = content)
}

@Composable
public fun section(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("section", modifier, content = content)
}

@Composable
public fun select(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("select", modifier, content = content)
}

@Composable
public fun source(
  src: String? = null,
  type: String? = null,
  modifier: Modifier = Modifier,
  content: @Composable () -> Unit = {}
): Unit {
  tag("source", modifier.src(src).type(type), content = content)
}

@Composable
public fun span(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("span", modifier, content = content)
}

@Composable
public fun strong(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("strong", modifier, content = content)
}

@Composable
public fun summary(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("summary", modifier, content = content)
}

@Composable
public fun table(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("table", modifier, content = content)
}

@Composable
public fun tbody(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("tbody", modifier, content = content)
}

@Composable
public fun tfoot(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("tfoot", modifier, content = content)
}

@Composable
public fun th(
  colspan: Int? = null,
  rowspan: Int? = null,
  abbr: String? = null,
  headers: String? = null,
  scope: String? = null,
  sorted: String? = null,
  modifier: Modifier = Modifier,
  content: @Composable () -> Unit = {}
): Unit {
  tag("th",
      modifier.colspan(colspan).rowspan(rowspan).abbr(abbr).headers(headers).scope(scope).sorted(sorted),
      content = content)
}

@Composable
public fun thead(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("thead", modifier, content = content)
}

@Composable
public fun time(
  datetime: String? = null,
  modifier: Modifier = Modifier,
  content: @Composable () -> Unit = {}
): Unit {
  tag("time", modifier.datetime(datetime), content = content)
}

@Composable
public fun tr(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("tr", modifier, content = content)
}

@Composable
public fun td(
  colspan: Int? = null,
  rowspan: Int? = null,
  headers: String? = null,
  modifier: Modifier = Modifier,
  content: @Composable () -> Unit = {}
): Unit {
  tag("td", modifier.colspan(colspan).rowspan(rowspan).headers(headers), content = content)
}

@Composable
public fun video(
  muted: Boolean = false,
  playsinline: Boolean = false,
  autoplay: Boolean = false,
  loop: Boolean = false,
  preload: String? = null,
  poster: String? = null,
  modifier: Modifier = Modifier,
  content: @Composable () -> Unit = {}
): Unit {
  tag("video",
      modifier.muted(muted).playsinline(playsinline).autoplay(autoplay).loop(loop).preload(preload).poster(poster),
      content = content)
}

@Composable
public fun ul(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}): Unit {
  tag("ul", modifier, content = content)
}
