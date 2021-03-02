//package io.sooj.compose
//
//import androidx.compose.runtime.*
//
///**
// * Remember the value produced by [calculation]. [calculation] will only be evaluated during the composition.
// * Recomposition will always return the value produced by composition.
// */
//@Composable
//actual inline fun <T> remember(calculation: @DisallowComposableCalls () -> T): T =
//    currentComposer.cache(false, calculation)
//
///**
// * Remember the value returned by [calculation] if [key1] is equal to the previous composition,
// * otherwise produce and remember a new value by calling [calculation].
// */
//@OptIn(ComposeCompilerApi::class)
//@Composable
//actual inline fun <T> remember(
//    key1: Any?,
//    calculation: @DisallowComposableCalls () -> T
//): T {
//    return currentComposer.cache(currentComposer.changed(key1), calculation)
//}
//
///**
// * Remember the value returned by [calculation] if [key1] and [key2] are equal to the previous
// * composition, otherwise produce and remember a new value by calling [calculation].
// */
//@OptIn(ComposeCompilerApi::class)
//@Composable
//actual inline fun <T> remember(
//    key1: Any?,
//    key2: Any?,
//    calculation: @DisallowComposableCalls () -> T
//): T {
//    return currentComposer.cache(
//        currentComposer.changed(key1) or currentComposer.changed(key2),
//        calculation
//    )
//}
//
///**
// * Remember the value returned by [calculation] if [key1], [key2] and [key3] are equal to the
// * previous composition, otherwise produce and remember a new value by calling [calculation].
// */
//@OptIn(ComposeCompilerApi::class)
//@Composable
//actual inline fun <T> remember(
//    key1: Any?,
//    key2: Any?,
//    key3: Any?,
//    calculation: @DisallowComposableCalls () -> T
//): T {
//    return currentComposer.cache(
//        currentComposer.changed(key1) or
//                currentComposer.changed(key2) or
//                currentComposer.changed(key3),
//        calculation
//    )
//}
//
///**
// * Remember the value returned by [calculation] if all values of [keys] are equal to the previous
// * composition, otherwise produce and remember a new value by calling [calculation].
// */
//@OptIn(ComposeCompilerApi::class)
//@Composable
//actual inline fun <T> remember(
//    vararg keys: Any?,
//    calculation: @DisallowComposableCalls () -> T
//): T {
//    var invalid = false
//    for (key in keys) invalid = invalid or currentComposer.changed(key)
//    return currentComposer.cache(invalid, calculation)
//}