import androidx.compose.runtime.Composable
import compose.web.renderComposable
import io.sooj.Component
import io.sooj.sooj
import io.sooj.text
import kotlinx.browser.document

fun main() {
    sooj {
        App()
    }
//    renderComposable(document.body!!) {
//        Component().apply {
//            App()
//        }
//    }
}

//@Composable
//fun Component.App() {
//    println("ASD12")
//    div {
//        text("ASDADS")
//    }
//}