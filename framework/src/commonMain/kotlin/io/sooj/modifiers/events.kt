package io.sooj.modifiers

import Modifier
import io.sooj.browser.BrowserEvent
import io.sooj.browser.elements.BrowserElement

typealias Event = (BrowserEvent<BrowserElement>) -> Unit

fun Modifier.onClick(event: Event): Modifier = onEvent("click", event)
fun Modifier.onInput(event: Event): Modifier = onEvent("input", event)