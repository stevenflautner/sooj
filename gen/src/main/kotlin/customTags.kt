import androidx.compose.runtime.Composable
import io.sooj.Component
import io.sooj.browser.BrowserEvent
import io.sooj.browser.elements.BrowserInputElement
import io.sooj.modifiers.Event
import io.sooj.modifiers.onInput
import io.sooj.tag

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
        modifier.onInput(onInput as Event).type(type).maxLength(maxLength).value(value).name(name).placeholder(placeholder).ariaLabel(ariaLabel).ariaLabelledBy(ariaLabelledBy),
        content = content)
}