import org.w3c.dom.events.EventListener

actual fun Modifier.event(eventName: String, listener: () -> Unit) : Modifier =
    this.then(EventModifier(eventName, EventListener { listener() }))

/**
 * Adds an event listener for the target node which is applied on node recomposition
 */
internal actual class EventModifier(val eventName: String, val listener: EventListener) : Modifier.Element