import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import io.sooj.Component
import io.sooj.text

@Composable
fun Component.App() {
    println("ASD12")
    div {
        val d = remember { mutableStateOf("asdasd1")}
        text(d.value)
    }
}