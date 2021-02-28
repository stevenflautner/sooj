//package compose.web
//
//import Modifier
//import androidx.compose.runtime.Composable
//import io.sooj.tag
//
//@Composable
//fun h1(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
//    io.sooj.tag(modifier, "h1", content = content)
//}
//
//@Composable
//fun h2(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
//    io.sooj.tag(modifier, "h2", content = content)
//}
//
//@Composable
//fun button(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
//    io.sooj.tag(modifier, "button", content = content)
//}
//
//@Composable
//fun input(modifier: Modifier = Modifier, content: @Composable() () -> Unit = {}) {
//    io.sooj.tag(modifier, "input", content = content)
//}
//@Composable
//fun span(modifier: Modifier = Modifier, content: @Composable() () -> Unit = {}) {
//    io.sooj.tag(modifier, "span", content = content)
//}
//
//@Composable
//fun div(modifier: Modifier = Modifier, content: @Composable() () -> Unit = {}) {
//    io.sooj.tag(modifier, "div", content = content)
//}
//
//@Composable
//fun canvas(modifier: Modifier = Modifier, width: Int, height: Int) {
//    io.sooj.tag(modifier = modifier.width(width).height(height), tagName = "canvas", content = {})
//}
//
//@Composable
//fun br() {
//    io.sooj.tag(modifier = Modifier, tagName = "br", content = {})
//}