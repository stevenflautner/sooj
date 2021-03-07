import androidx.compose.runtime.*
import io.sooj.Component
import io.sooj.browser.fullValue
import io.sooj.modifiers.classes
import io.sooj.modifiers.onClick
import io.sooj.modifiers.style
import io.sooj.text

@Composable
fun Component.App() {
    div {
        var d by remember { mutableStateOf(0) }

        div(mod.style {
            backgroundColor = if (d % 2 == 0) "blue" else "red"
            color = "white"
            textAlign = "center"
        }.onClick {
            d++
        }) {
            span(mod.classes {
                +"HEY"
                +"asdads"
                if (d % 2 == 0)
                    +"awdadw"
            }) {
                text("Hello")

                var input by remember { mutableStateOf("hey") }

                input(
                    value = input,
                    onInput = {
                        input = it.fullValue
                    }
                )

                div {
                    h1 {
                        text(input)
                    }
                    h2 {
                        text("h2")
                    }
                    p {
                        text("p")
                    }
                    Img(d)
                }
            }
        }

//        var list by remember { mutableStateOf(listOf("Hey", "May")) }
//        var counter by remember { mutableStateOf(0) }
//
//        var bgColor by remember { mutableStateOf("red") }
//
//        val m = Modifier.onClick {
//            println("COUNT IS: ${++counter}")
//            list = list + "Count: $counter"
//            bgColor = if (counter % 2 == 0) "black" else "red"
//            println("ASD")
//            println(bgColor)
//        }
//        .css {
//            backgroundColor = bgColor
//        }
//        println(
//            m.foldIn("") { acc, element ->
////            println("")
////            acc.add(element)
//                if (element is EventModifier) "$acc ${element.eventName}=" else acc
//            }
//        )
//
//
//        h1(m) {
//            text("CLICK TO COUNT")
//        }
//
//
//        h2 {
//            div(
//                Modifier.css {
//                    backgroundColor = if (counter % 2 == 0) "black" else "red"
//                    println("COO ${counter}")
//                }
//            ) {
//                text("CHECK IF THIS GETS REBUILT")
//            }
//        }
//        div {
//            span {
//                text("COUNTED: $counter")
//            }
//        }
//        div {
//            span {
//                div {
//                    list.forEach {
//                        div {
//                            span {
//                                text(it)
//                            }
//                        }
//                    }
//                }
//            }
//        }
    }
}

@Composable
fun Component.Img(counter: Int) {
    div(Modifier.style {
        backgroundColor = "red"
    }) {
        img(src = if (counter % 2 != 0) "fail.png" else "") {  }
    }
}