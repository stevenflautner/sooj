import generator.generateAttrs
import generator.generateTags
import io.github.enjoydambience.kotlinbard.buildFile
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.Path

@ExperimentalPathApi
fun main() {
    val base = Path("../framework/src/commonMain/kotlin/io/sooj/")
    buildFile(packageName = "", fileName = "attrs") {
        generateAttrs()
    }.writeTo(base.resolve("modifiers"))

    buildFile(packageName = "", fileName = "tags") {
        generateTags()
    }.writeTo(base.resolve("tags"))
}