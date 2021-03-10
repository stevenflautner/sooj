import java.util.Date

plugins {
    kotlin("jvm") version "1.4.31"
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`
    id("com.jfrog.bintray") version "1.8.5"
}

buildscript {
    dependencies {
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:0.13.0")
        classpath("com.jfrog.bintray.gradle:gradle-bintray-plugin:1.8.4")
    }
}

repositories {
    jcenter()
}

//kotlin {
//    target {
//        compilations.configureEach {
//            kotlinOptions.jvmTarget = "1.8"
//            kotlinOptions.freeCompilerArgs += listOf(
//                "-Xopt-in=kotlin.RequiresOptIn",
//                "-Xnew-inference",
//                "-P", "plugin:androidx.compose.compiler.plugins.kotlin:generateDecoys=true"
//            )
//        }
//    }
//}

dependencies {
    implementation(kotlin("gradle-plugin"))
    implementation(gradleApi())
    implementation(gradleKotlinDsl())
    implementation("com.jfrog.bintray.gradle:gradle-bintray-plugin:1.8.5")
}

gradlePlugin {
    plugins.register("build-common") {
        id = "build-common"
        implementationClass = "BuildCommon"
    }
}

fun Project.setupPublishing() {
    plugins.withType(MavenPublishPlugin::class) {
        extensions.configure<PublishingExtension>("publishing") {
            publications {
                extensions.configure<com.jfrog.bintray.gradle.BintrayExtension>("bintray") {
                    bintrayPublishing(this@setupPublishing)
                }
            }
        }

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
}

fun com.jfrog.bintray.gradle.BintrayExtension.bintrayPublishing(project: Project): Unit = with(project) {
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

setupPublishing()
