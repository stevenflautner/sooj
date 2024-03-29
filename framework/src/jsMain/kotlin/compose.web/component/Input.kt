//package compose.web.component
//
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.MutableState
//import androidx.compose.runtime.mutableStateOf
//import Modifier
//import compose.web.event
//import compose.web.onInput
//import compose.web.property
//import io.sooj.tag
//import org.w3c.dom.HTMLInputElement
//import org.w3c.dom.events.EventListener
//
//class CheckboxState(initialValue: Boolean) : MutableState<Boolean> by mutableStateOf(initialValue)
//
//@Composable
//fun Checkbox(modifier: Modifier = Modifier, state: CheckboxState) {
//    // TODO: tbh, setting properties through the modifier feels super inefficient
//    io.sooj.tag(
//        modifier = modifier
//            .property<HTMLInputElement> { type = "checkbox" }
//            .property<HTMLInputElement> { checked = state.value }
//            .event("change", EventListener {
//                state.value = (it.target as HTMLInputElement).checked
//            }),
//        tagName = "input",
//        content = {}
//    )
//}
//
//class InputState(initialValue: String) : MutableState<String> by mutableStateOf(initialValue)
//
//@Composable
//fun TextInput(modifier: Modifier = Modifier, state: InputState) {
//    // TODO: tbh, setting properties through the modifier feels super inefficient
//    io.sooj.tag(
//        modifier = modifier
//            .property<HTMLInputElement> { type = "io.sooj.text" }
//            .property<HTMLInputElement> { value = state.value }
//            .onInput {
//                state.value = (it.target as HTMLInputElement).value
//            },
//        tagName = "input",
//        content = {}
//    )
//}
