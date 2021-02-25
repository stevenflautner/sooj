import androidx.compose.runtime.*
import compose.web.div
import compose.web.h1
import compose.web.h2
import compose.web.span

@Composable
fun App() {
    div {
        var counter by remember { mutableStateOf(0) }

        h1(
            Modifier.onClick {
                println("COUNT IS: ${++counter}")
            }
        ) {
            text("CLICK TO COUNT")
        }


        h2 {
            div {
                text("CHECK IF THIS GETS REBUILT")
            }
        }
        div {
            span {
                text("COUNTED: $counter")
            }
        }
    }
}