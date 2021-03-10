import com.jfrog.bintray.gradle.BintrayExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.findByType
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
import java.util.*
import com.jfrog.bintray.gradle.BintrayPlugin
import org.gradle.api.publish.PublicationContainer
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.publish.maven.plugins.MavenPublishPlugin

class BuildCommon : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            plugins.apply(MavenPublishPlugin::class)
            plugins.apply(BintrayPlugin::class)
        }
    }
}

fun KotlinJvmTarget.compilation() {
    withJava()
    compilations.all {
        kotlinOptions.jvmTarget = "1.8"
//        kotlinOptions.useIR = true
    }
}

//fun Project.configureComposeCompiler() {
//    if (!project.hasProperty("composeCompilerOff")) {
//        addComposeCompilerDependency()
//    }
//
//    fun KotlinJsTargetDsl.configure() {
//        compilations.configureEach {
//            kotlinOptions.freeCompilerArgs += listOf(
//                "-Xopt-in=kotlin.RequiresOptIn",
//                "-Xnew-inference",
//                "-P", "plugin:androidx.compose.compiler.plugins.kotlin:generateDecoys=true"
//            )
//        }
//    }
//
//    extensions.findByType<KotlinMultiplatformExtension>()?.apply {
//        js(IR) {
//            configure()
//        }
//    } ?:
//    extensions.findByType<KotlinJsProjectExtension>()?.apply {
//        js(IR) {
//            configure()
//        }
//    }
//}


fun Project.setupPublishing() {
    configureBintrayPublishing()
    val publishing = extensions.getByName("publishing") as PublishingExtension
    tasks.withType<com.jfrog.bintray.gradle.tasks.BintrayUploadTask> {
        dependsOn(tasks.getByName("publishToMavenLocal"))
        doFirst {
            setPublications(
                *publishing.publications
                    .filterIsInstance<MavenPublication>()
                    .map { publication ->
                        val moduleFile = buildDir.resolve("publications/${publication.name}/module.json")
                        if (moduleFile.exists()) {
                            publication.artifact(object : org.gradle.api.publish.maven.internal.artifact.FileBasedMavenArtifact(moduleFile) {
                                override fun getDefaultExtension() = "module"
                            })
                        }
                        publication.name
                    }.toTypedArray()
            )
        }
    }
}

fun Project.setupRootPublishing() {
    configureBintrayPublishing()
    val publishing = extensions.getByName("publishing") as PublishingExtension
    tasks.withType<com.jfrog.bintray.gradle.tasks.BintrayUploadTask> {
        dependsOn(gradle.includedBuild("build-common").task("publish"))
        dependsOn(tasks.getByName("publishToMavenLocal"))
        doFirst {
            setPublications(
                *publishing.publications
                    .filterIsInstance<MavenPublication>()
                    .map { publication ->
                        val moduleFile = buildDir.resolve("publications/${publication.name}/module.json")
                        if (moduleFile.exists()) {
                            publication.artifact(object : org.gradle.api.publish.maven.internal.artifact.FileBasedMavenArtifact(moduleFile) {
                                override fun getDefaultExtension() = "module"
                            })
                        }
                        publication.name
                    }.toTypedArray()
            )
        }
    }
}

private fun Project.configureBintrayPublishing() {
    plugins.withType(MavenPublishPlugin::class) {
        extensions.configure<PublishingExtension>("publishing") {
            publications {
                extensions.configure<BintrayExtension>("bintray") {
                    bintrayPublishing(this@configureBintrayPublishing)
                }
            }
        }
    }
}

fun BintrayExtension.bintrayPublishing(project: Project): Unit = with(project) {
    val artifactName = project.name
    val artifactGroup = project.group.toString()
    val artifactVersion = project.version.toString()

    val bintrayRepo = "sooj"
    val repoName = artifactName
    val versionDescription = "Pre-release 0.0.1"
    val projVcsUrl = "https://github.com/stevenflautner/sooj.git"

    user = "stevenflautner"
    key = project.findProperty("bintrayKey").toString()
    publish = true

    pkg.apply {
        repo = bintrayRepo
        name = repoName
        userOrg = "skipn"
        setLicenses("MIT")
        vcsUrl = projVcsUrl
        version.apply {
            name = artifactVersion
            desc = versionDescription
            released = Date().toString()
            vcsTag = artifactVersion
        }
    }
}