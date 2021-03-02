import io.sooj.Component
import io.sooj.html.HTMLStreamBuilder

fun main() {
    HTMLStreamBuilder(
        System.out,
        prettyPrint = true,
//        xhtmlCompatible = false,
    ).also {
        Component(it).apply {
            App()
        }
    }
}