/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.compose.runtime

import kotlinx.atomicfu.atomic
import kotlinx.browser.window
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime
import kotlin.time.toDuration

internal actual open class ThreadLocal<T> actual constructor(
    initialValue: () -> T
) {
    private var value: T = initialValue()

    actual fun get(): T = value

    actual fun set(value: T) {
        this.value = value
    }
}

actual class AtomicReference<V> actual constructor(value: V) {
    private val delegate = atomic(value)
    actual fun get(): V = delegate.value

    actual fun set(value: V) {
        delegate.value = value
    }

    actual fun getAndSet(value: V): V =
        delegate.getAndSet(value)

    actual fun compareAndSet(expect: V, newValue: V): Boolean =
        delegate.compareAndSet(expect, newValue)
}

internal actual fun identityHashCode(instance: Any?): Int {
    if (instance == null) {
        return 0
    }

    val hashCode = instance.asDynamic()[IDENTITY_HASHCODE_FIELD]
    if (hashCode != null) {
        return hashCode
    }

    return when (jsTypeOf(instance)) {
        "object", "function" -> memoizeIdentityHashCode(instance)
        else -> throw IllegalArgumentException(
            "identity hash code for ${jsTypeOf(instance)} is not supported"
        )
    }
}

private var nextHash = 1
private const val IDENTITY_HASHCODE_FIELD = "kotlinIdentityHashcodeValue$"

@NoLiveLiterals
private fun memoizeIdentityHashCode(instance: Any?): Int {
    val value = nextHash++

    val descriptor = js("new Object()")
    descriptor.value = value
    descriptor.writable = false
    descriptor.configurable = false
    descriptor.enumerable = false

    js("Object").defineProperty(instance, IDENTITY_HASHCODE_FIELD, descriptor)

    return value
}

actual annotation class TestOnly

actual inline fun <R> synchronized(lock: Any, block: () -> R): R =
    block()

actual val DefaultMonotonicFrameClock: MonotonicFrameClock by lazy { MonotonicClockImpl() }

@OptIn(ExperimentalTime::class)
private class MonotonicClockImpl : MonotonicFrameClock {
    override suspend fun <R> withFrameNanos(
        onFrame: (Long) -> R
    ): R = suspendCoroutine { continuation ->
        window.requestAnimationFrame {
            val duration = it.toDuration(DurationUnit.MILLISECONDS)
            val result = onFrame(duration.toLongNanoseconds())
            continuation.resume(result)
        }
    }
}