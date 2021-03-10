import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.findByType
import org.jetbrains.kotlin.gradle.dsl.KotlinJsProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.targets.js.dsl.KotlinJsTargetDsl

const val SOOJ_VERSION = "0.0.5"

const val KTOR_VERSION = "1.5.1"
const val SERIALIZATION_VERSION = "1.0.1"
const val DATE_TIME_VERSION = "0.1.0"
const val COROUTINES_VERSION = "1.4.2"
const val KOTLIN_PLUGIN = "1.4.31"
const val JVM_TARGET = "1.8"

fun Project.configureComposeCompiler() {
    if (!project.hasProperty("composeCompilerOff")) {
        addComposeCompilerDependency()
    }

    fun KotlinJsTargetDsl.configure() {
        compilations.configureEach {
            kotlinOptions.freeCompilerArgs += listOf(
                "-Xopt-in=kotlin.RequiresOptIn",
                "-Xnew-inference",
                "-P", "plugin:androidx.compose.compiler.plugins.kotlin:generateDecoys=true"
            )
        }
    }

    extensions.findByType<KotlinMultiplatformExtension>()?.apply {
        js(IR) {
            configure()
        }
    } ?:
    extensions.findByType<KotlinJsProjectExtension>()?.apply {
        js(IR) {
            configure()
        }
    }
}

fun Project.addComposeCompilerDependency() {
    dependencies {
        "kotlinCompilerPluginClasspath"(files("$rootDir/libs/embedded.jar"))
    }
}