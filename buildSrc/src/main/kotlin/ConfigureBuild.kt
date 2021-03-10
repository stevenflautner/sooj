import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.plugins.MavenPublishPlugin

//import org.gradle.api.Project
//import org.gradle.api.artifacts.Dependency
//import org.gradle.api.artifacts.dsl.RepositoryHandler
//import org.gradle.api.tasks.JavaExec
//import org.gradle.jvm.tasks.Jar
//import org.gradle.kotlin.dsl.*
//import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
//import org.jetbrains.kotlin.gradle.dsl.KotlinJsProjectExtension
//import org.jetbrains.kotlin.gradle.targets.js.dsl.KotlinJsTargetDsl
//import org.jetbrains.kotlin.gradle.targets.jvm.KotlinJvmTarget
//import java.io.File
//
//fun RepositoryHandler.libsRepository(rootDir: File) {
//    maven(url = File(rootDir, "libs").toURI())
//}
//
////fun DependencyHandlerScope.composeRuntimeJs(): Dependency = create("androidx.compose.runtime:runtime-js:1.0.0-beta02")
//
//fun Project.addComposeCompilerDependency() {
//    dependencies {
//        "kotlinCompilerPluginClasspath"(files("$rootDir/libs/embedded.jar"))
////        gradle.taskGraph.whenReady {
////            if (gradle.taskGraph.hasTask(":serverRun")) return@whenReady
////            if (gradle.taskGraph.hasTask(":generateModifiers")) return@whenReady
////            "kotlinCompilerPluginClasspath"(files("$rootDir/libs/embedded.jar"))
////        }
//    }
//}
//
//fun KotlinJvmTarget.compilation() {
//    withJava()
//    compilations.all {
//        kotlinOptions.jvmTarget = "11"
////        kotlinOptions.useIR = true
//    }
//}
//
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
//





//fun Project.setupPublishing() {
//    plugins.withType(MavenPublishPlugin::class) {
//        extensions.configure<PublishingExtension>("publishing") {
//            publications {
//                extensions.configure<BintrayExtension>("bintray") {
//                    bintrayPublishing(this@setupPublishing)
//                }
//            }
//        }
//
//        val publishing = extensions.getByName("publishing") as PublishingExtension
//
//        tasks.withType<com.jfrog.bintray.gradle.tasks.BintrayUploadTask> {
//            dependsOn(tasks.getByName("publishToMavenLocal"))
//            doFirst {
//                setPublications(
//                    *publishing.publications
//                        .filterIsInstance<MavenPublication>()
//                        .map { publication ->
//                            val moduleFile = buildDir.resolve("publications/${publication.name}/module.json")
//                            if (moduleFile.exists()) {
//                                publication.artifact(object : org.gradle.api.publish.maven.internal.artifact.FileBasedMavenArtifact(moduleFile) {
//                                    override fun getDefaultExtension() = "module"
//                                })
//                            }
//                            publication.name
//                        }.toTypedArray()
//                )
//            }
//        }
//    }
////    extensions.configure<PublishingExtension>("publishing") {
////        publications {
////            extensions.configure<BintrayExtension>("bintray") {
////                bintrayPublishing(this@setupPublishing)
////            }
////        }
////    }
//}
//
//fun BintrayExtension.bintrayPublishing(project: Project): Unit = with(project) {
//    val artifactName = project.name
//    val artifactGroup = project.group.toString()
//    val artifactVersion = project.version.toString()
//
//    val bintrayRepo = "sooj"
//    val repoName = artifactName
//    val versionDescription = "Pre-release 0.0.1"
//    val projVcsUrl = "https://github.com/stevenflautner/sooj.git"
//
//    user = "stevenflautner"
//    key = project.findProperty("bintrayKey").toString()
//    publish = true
//
//    pkg.apply {
//        repo = bintrayRepo
//        name = repoName
//        userOrg = "skipn"
//        setLicenses("MIT")
//        vcsUrl = projVcsUrl
//        version.apply {
//            name = artifactVersion
//            desc = versionDescription
//            released = Date().toString()
//            vcsTag = artifactVersion
//        }
//    }
//}