import io.sooj.Component
import io.sooj.html.HTMLStreamBuilder

fun main() {
    HTMLStreamBuilder(
        System.out, false
    ).also {
        Component(it).apply {
            App()
        }
    }
}