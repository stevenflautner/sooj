import java.util.Date

plugins {
    kotlin("multiplatform")
    id("build-common")
    id("maven-publish")
    id("com.jfrog.bintray") version "1.8.4"
}

group = "io.sooj"
version = SOOJ_VERSION

repositories {
    jcenter()
    mavenCentral()
    mavenLocal()
    maven {
        url = uri("https://dl.bintray.com/kotlin/ktor")
    }
    maven {
        url = uri("https://dl.bintray.com/kotlin/kotlinx")
    }
//    libsRepository(rootDir)
}

subprojects {
    repositories {
        jcenter()
        mavenLocal()
        mavenCentral()
        maven {
            url = uri("https://dl.bintray.com/kotlin/ktor")
        }
        maven {
            url = uri("https://dl.bintray.com/kotlin/kotlinx")
        }
//        libsRepository(rootDir)
    }
}

kotlin {
    jvm {
        compilations.configureEach {
            kotlinOptions.jvmTarget = "1.8"
            kotlinOptions.freeCompilerArgs += listOf(
                "-Xopt-in=kotlin.RequiresOptIn",
                "-Xnew-inference",
                "-P", "plugin:androidx.compose.compiler.plugins.kotlin:generateDecoys=true"
            )
        }
        withJava()
//        compilation()
    }
    js(IR) {
        browser()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
//                implementation(project(":compose"))
                implementation("io.sooj:compose:$SOOJ_VERSION")
//                implementation("org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.3")
//                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1")
            }
        }
        val jsMain by getting {
            dependencies {
//                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1")
//                implementation("org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.3")
            }
        }
    }
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

allprojects {
    version = SOOJ_VERSION
    group = "io.sooj"
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