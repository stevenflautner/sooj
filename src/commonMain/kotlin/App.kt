import androidx.compose.runtime.*
import compose.web.div
import compose.web.h1
import compose.web.h2
import compose.web.span

@Composable
fun App() {
    div {
        var list by remember { mutableStateOf(listOf("Hey", "May")) }
        var counter by remember { mutableStateOf(0) }

        var bgColor by remember { mutableStateOf("red") }

        val m = Modifier.onClick {
            println("COUNT IS: ${++counter}")
            list = list + "Count: $counter"
            bgColor = if (counter % 2 == 0) "black" else "red"
            println("ASD")
            println(bgColor)
        }
        .css {
            backgroundColor = bgColor
        }
        println(
            m.foldIn("") { acc, element ->
//            println("")
//            acc.add(element)
                if (element is EventModifier) "$acc ${element.eventName}=" else acc
            }
        )


        h1(m) {
            text("CLICK TO COUNT")
        }


        h2 {
            div(
                Modifier.css {
                    backgroundColor = if (counter % 2 == 0) "black" else "red"
                    println("COO ${counter}")
                }
            ) {
                text("CHECK IF THIS GETS REBUILT")
            }
        }
        div {
            span {
                text("COUNTED: $counter")
            }
        }
        div {
            span {
                div {
                    list.forEach {
                        div {
                            span {
                                text(it)
                            }
                        }
                    }
                }
            }
        }
    }
}