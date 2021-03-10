import io.github.enjoydambience.kotlinbard.buildFile
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.Path

@ExperimentalPathApi
fun main() {
    val base = Path("../src/commonMain/kotlin/")
    buildFile(packageName = "io.sooj.modifiers", fileName = "attrs") {
        generateAttrs()
    }.writeTo(base)

    buildFile(packageName = "io.sooj.tags", fileName = "tags") {
        generateTags()
    }.writeTo(base)
}