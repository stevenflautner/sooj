//package io.sooj
//
//import Modifier
//import androidx.compose.runtime.Composable
//import io.sooj.tag
//import src
//
//@Composable
//fun h1(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
//    tag(modifier, "h1", content = content)
//}
//
//@Composable
//fun h2(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
//    tag(modifier, "h2", content = content)
//}
//
//@Composable
//fun button(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
//    tag(modifier, "button", content = content)
//}
//
//@Composable
//fun input(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}) {
//    tag(modifier, "input", content = content)
//}
//@Composable
//fun span(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}) {
//    tag(modifier, "span", content = content)
//}
//
//@Composable
//fun div(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}) {
//    tag(modifier, "div", content = content)
//}
//
//@Composable
//fun img(src: String? = null, modifier: Modifier = Modifier, content: @Composable () -> Unit = {}) {
//    tag("div", modifier.src(src) content = content)
//}
//
//@Composable
//fun br() {
//    tag(Modifier, "br", content = {})
//}