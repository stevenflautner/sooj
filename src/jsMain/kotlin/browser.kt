@file:OptIn(ExperimentalComposeApi::class, ExperimentalTime::class)

import androidx.compose.runtime.ExperimentalComposeApi
import compose.web.renderComposable
import io.sooj.Component
import kotlinx.browser.document
import kotlin.time.ExperimentalTime

fun main() {
    renderComposable(document.body!!) {
        Component().apply {
            App()
        }
    }
}


//fun Benchmark(content: @Composable (round: Int) -> Unit, rounds: Int = 100): Duration {
//    val composition = renderComposable(document.body!!) {}
//
//    var duration = Duration.ZERO
//    for (i in 0 until rounds) {
//        duration += measureTime {
//            composition.setContent { content(-1) }
//        }
//        composition.setContent { }
//    }
//    return duration / rounds
//}
//
