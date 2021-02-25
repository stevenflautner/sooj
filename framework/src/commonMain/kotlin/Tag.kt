import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode

@Composable
expect fun tag(modifier: Modifier, tagName: String, content: @Composable () -> Unit)

@Composable
expect fun text(value: String)