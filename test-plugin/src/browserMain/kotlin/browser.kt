import androidx.compose.runtime.Composable
import compose.web.renderComposable
import io.sooj.Component
import io.sooj.text
import kotlinx.browser.document

fun main() {
    renderComposable(document.body!!) {
        Component().apply {
            App()
        }
    }
}

//@Composable
//fun Component.App() {
//    println("ASD12")
//    div {
//        text("ASDADS")
//    }
//}