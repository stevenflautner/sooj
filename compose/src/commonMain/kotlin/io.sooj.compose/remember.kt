//package io.sooj.compose
//
//import androidx.compose.runtime.*
//
///**
// * Remember the value produced by [calculation]. [calculation] will only be evaluated during the composition.
// * Recomposition will always return the value produced by composition.
// */
//@OptIn(ComposeCompilerApi::class)
//@Composable
//expect inline fun <T> remember(calculation: @DisallowComposableCalls () -> T): T
//
///**
// * Remember the value returned by [calculation] if [key1] is equal to the previous composition,
// * otherwise produce and remember a new value by calling [calculation].
// */
//@OptIn(ComposeCompilerApi::class)
//@Composable
//expect inline fun <T> remember(
//    key1: Any?,
//    calculation: @DisallowComposableCalls () -> T
//): T
//
///**
// * Remember the value returned by [calculation] if [key1] and [key2] are equal to the previous
// * composition, otherwise produce and remember a new value by calling [calculation].
// */
//@OptIn(ComposeCompilerApi::class)
//@Composable
//expect inline fun <T> remember(
//    key1: Any?,
//    key2: Any?,
//    calculation: @DisallowComposableCalls () -> T
//): T
//
///**
// * Remember the value returned by [calculation] if [key1], [key2] and [key3] are equal to the
// * previous composition, otherwise produce and remember a new value by calling [calculation].
// */
//@OptIn(ComposeCompilerApi::class)
//@Composable
//expect inline fun <T> remember(
//    key1: Any?,
//    key2: Any?,
//    key3: Any?,
//    calculation: @DisallowComposableCalls () -> T
//): T
//
///**
// * Remember the value returned by [calculation] if all values of [keys] are equal to the previous
// * composition, otherwise produce and remember a new value by calling [calculation].
// */
//@OptIn(ComposeCompilerApi::class)
//@Composable
//expect inline fun <T> remember(
//    vararg keys: Any?,
//    calculation: @DisallowComposableCalls () -> T
//): T