import androidx.compose.runtime.staticCompositionLocalOf
import io.sooj.html.HTMLStreamBuilder

val Ambient = staticCompositionLocalOf<String> {
    "ASDASD"
}

fun main() {
    HTMLStreamBuilder(
        System.out, false
    ).also {
//        Ambient.current = "12"
//        CompositionLocalProvider(Ambient provides "user") {
//        }
        println("ASD")
        println(Ambient.current)
//        Component(it).apply {
////            asd()
//            App()
//        }
    }
}

