import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.api.tasks.JavaExec
import org.gradle.jvm.tasks.Jar
import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinJsProjectExtension
import org.jetbrains.kotlin.gradle.targets.js.dsl.KotlinJsTargetDsl
import org.jetbrains.kotlin.gradle.targets.jvm.KotlinJvmTarget
import java.io.File

fun RepositoryHandler.libsRepository(rootDir: File) {
    maven(url = File(rootDir, "libs").toURI())
}

//fun DependencyHandlerScope.composeRuntimeJs(): Dependency = create("androidx.compose.runtime:runtime-js:1.0.0-beta02")

fun Project.addComposeCompilerDependency() {
    dependencies {
        "kotlinCompilerPluginClasspath"(files("$rootDir/libs/embedded.jar"))
    }
}

fun KotlinJvmTarget.compilation() {
    withJava()
    compilations.all {
        kotlinOptions.jvmTarget = "11"
        kotlinOptions.useIR = true
    }
}

fun Project.configureComposeCompiler() {
    gradle.taskGraph.whenReady {
        if (gradle.taskGraph.hasTask(":serverRun")) return@whenReady
        if (gradle.taskGraph.hasTask(":generateModifiers")) return@whenReady

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