package io.sooj.state

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*

/**
 * Defines the type of the Logic
 * Source holds a reference to the MutableStateFlow
 * Child uses the mapped StateFlow, which value can not
 * be changed directly.
 */
sealed class LogicControl<T> {

    abstract fun update(update: T)

    abstract val state: StateFlow<T>

    class Source<T>(value: T) : LogicControl<T>() {
        val stateFlow = MutableStateFlow(value)

        override fun update(update: T) {
            stateFlow.value = update
        }

        override val state: StateFlow<T>
            get() = stateFlow.asStateFlow()
    }

    /**
     * @param connect
     * Connects this Logic with the parent
     */
    class Child<T, R>(
        val parent: LogicControl<T>,
        val childFlow: StateFlow<R>,
        val connect: T.(R) -> T?
    ) : LogicControl<R>() {

        override fun update(update: R) {
            val parentValue = connect(parent.state.value, update)
            if (parentValue != null)
                parent.update(parentValue)
        }

        override val state: StateFlow<R>
            get() = childFlow
    }
}

open class Logic<T>(
    private val control: LogicControl<T>
) {

    constructor(value: T) : this(LogicControl.Source(value))

    /**
     *  Collects the parent's value and transform it to the child's
     *  This will only notify child updates when the child object instance
     *  itself had changed
     */
    fun <R> map(
        scope: CoroutineScope,
        map: (T) -> R,
        connect: T.(R) -> T?
    ): LogicControl.Child<T, R> {
        val child = state.map {
            map(it)
        }.stateIn(
            scope,
            SharingStarted.Lazily,
            map(state.value)
        )
        return LogicControl.Child(control, child, connect)
    }

    fun setState(update: T.() -> T) {
        control.update(update(state.value))
    }

    val state get() = control.state
    val value get() = state.value
}