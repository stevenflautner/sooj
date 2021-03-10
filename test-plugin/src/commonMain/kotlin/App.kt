import androidx.compose.runtime.*
import io.sooj.Component
import io.sooj.browser.fullValue
import io.sooj.modifiers.Classes
import io.sooj.modifiers.classes
import io.sooj.modifiers.onClick
import io.sooj.modifiers.style
import io.sooj.router.Router
import io.sooj.router.routePage
import io.sooj.text
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun Component.App() {
    body {
        Router { route ->
            when (route) {
                "shop" -> Shop()
                else -> Index()
            }
        }
    }
}

@Composable
fun Component.Shop() {
    span(mod.onClick {
        routePage("/")
    }) {
        text("Go to Index")
    }
}
@Composable
fun Component.Index() {
    span(mod.onClick {
        routePage("/shop")
    }) {
        text("Go to Shop")
    }
    div {
        var d by remember { mutableStateOf(0) }
        val sd = MutableStateFlow("")

        div(mod.style {
            backgroundColor = if (d % 2 == 0) "blue" else "red"
            color = "white"
            textAlign = "center"
        }.onClick {
            d++
        }) {
            span(mod.classes(Classes().apply {
                +"HEY"
                +"asdads"
                if (d % 2 == 0)
                    +"awdadw"
            })) {
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