//package io.sooj.compose
//
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.DisallowComposableCalls
//
///**
// * Only returns the calculation on the server
// */
//@Composable
//actual inline fun <T> remember(calculation: @DisallowComposableCalls () -> T): T =
//    calculation()
//
///**
// * Only returns the calculation on the server
// */
//@Composable
//actual inline fun <T> remember(key1: Any?, calculation: @DisallowComposableCalls () -> T): T =
//    calculation()
//
///**
// * Only returns the calculation on the server
// */
//@Composable
//actual inline fun <T> remember(key1: Any?, key2: Any?, calculation: @DisallowComposableCalls () -> T): T =
//    calculation()
//
///**
// * Only returns the calculation on the server
// */
//@Composable
//actual inline fun <T> remember(
//    key1: Any?,
//    key2: Any?,
//    key3: Any?,
//    calculation: @DisallowComposableCalls () -> T
//): T = calculation()
//
///**
// * Only returns the calculation on the server
// */
//@Composable
//actual inline fun <T> remember(vararg keys: Any?, calculation: @DisallowComposableCalls () -> T): T =
//    calculation()