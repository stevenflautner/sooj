import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import io.sooj.Component
import io.sooj.html.HTMLStreamBuilder
import io.sooj.text

fun main() {
    HTMLStreamBuilder(
        System.out, false
    ).also {
        Component(it).apply {
//            asd()
            App()
        }
    }
}

