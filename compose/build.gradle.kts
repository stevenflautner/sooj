import java.util.Date

plugins {
    kotlin("multiplatform")
    id("maven-publish")
    id("com.jfrog.bintray")
    id("build-common")
}

kotlin {
    js(IR) {
        browser()
    }
    jvm {
        compilations.configureEach {
            kotlinOptions.jvmTarget = "1.8"
//            kotlinOptions.freeCompilerArgs += listOf(
//                "-Xopt-in=kotlin.RequiresOptIn",
//                "-Xnew-inference",
//                "-P", "plugin:androidx.compose.compiler.plugins.kotlin:generateDecoys=true"
//            )
        }
        withJava()
//        compilations.all {
//            kotlinOptions.jvmTarget = "1.8"
////        kotlinOptions.useIR = true
//        }
//        compilation()
//        testRuns["test"].executionTask.configure {
//            useJUnit()
//        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.3")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3")
            }
        }
//        val jsMain by getting {
//            dependencies {
//            }
//        }
    }
}

repositories {
    maven {
        url = uri("https://dl.bintray.com/kotlin/ktor")
    }
    maven {
        url = uri("https://dl.bintray.com/kotlin/kotlinx")
    }
    mavenCentral()
    jcenter()
}

configureComposeCompiler()

val artifactName = project.name
val artifactGroup = project.group.toString()
val artifactVersion = project.version.toString()

val bintrayRepo = "sooj"
val owner = "stevenflautner"
val repoName = "sooj"
val versionDescription = "Pre-release 0.0.1"
val license = "MIT"
val projVcsUrl = "https://github.com/stevenflautner/sooj.git"

publishing {
    publications {
        bintray {
            user = "stevenflautner"
            key = project.findProperty("bintrayKey").toString()
            publish = true

            pkg.apply {
                repo = bintrayRepo
                name = repoName
                userOrg = "sooj"
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
    }
}


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