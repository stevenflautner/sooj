@file:JvmName("_HtmlModifiers")

package io.sooj

import Modifier
import io.sooj.external.Css
import kotlin.jvm.JvmName

//typealias EventListener = () -> Unit

/**
 * Adds an event listener for the target node which is applied on node recomposition
 */
expect class EventModifier : EventModifierBase

abstract class EventModifierBase(val eventName: String) : Modifier.Element

/**
 * Adds a css style configuration which would be applied when node is updated
 */
internal class CssModifier(val configure: Css.() -> Unit) : Modifier.Element

/**
 * Updates target node properties on recomposition
 * Properties are not cleared automatically (yet) when modifier is removed
 */
internal class AttrModifier(val key: String, value: Any?): Modifier.Element

///**
// * Provides access to underlying HTML element
// */
//internal class RefModifier(val configure: HTMLElement.() -> Unit): Modifier.Element

fun Modifier.css(css: Css.() -> Unit): Modifier =
    this.then(CssModifier(css))
fun Modifier.backgroundColor(backgroundColor: String): Modifier =
    this.then(CssModifier { this.backgroundColor = backgroundColor })

expect fun Modifier.event(eventName: String, listener: () -> Unit) : Modifier

//@Suppress("UNCHECKED_CAST")
//fun <R : HTMLElement> Modifier.property(configure: R.() -> Unit) : Modifier =
//    this.then(PropertyModifier(configure as HTMLElement.() -> Unit))
//
//fun Modifier.ref(block: (HTMLElement) -> Unit): Modifier =
//    this.then(RefModifier(block))
