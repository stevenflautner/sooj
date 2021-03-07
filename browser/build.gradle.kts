plugins {
    kotlin("multiplatform")
}

group = "org.example"
version = "1.0-SNAPSHOT"
println("ASDJ12")

repositories {
    mavenCentral()
    mavenLocal()
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
    maven {
        url = uri("https://dl.bintray.com/sooj/sooj")
    }
    jcenter()
    maven {
        url = uri("https://dl.bintray.com/kotlin/ktor")
    }
    maven {
        url = uri("https://dl.bintray.com/kotlin/kotlinx")
    }
}

kotlin {
    jvm {
//        compilation()
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
//            kotlinOptions.useIR = true
        }
        withJava()
        val jvmJar by tasks.getting(org.gradle.jvm.tasks.Jar::class) {
            doFirst {
                manifest {
                    attributes["Main-Class"] = "ServerKt"
                }
                from(configurations.getByName("runtimeClasspath").map { if (it.isDirectory) it else zipTree(it) })
            }
        }
    }
    js(IR) {
//        compilations.configureEach {
//            kotlinOptions.freeCompilerArgs += listOf(
//                "-Xopt-in=kotlin.RequiresOptIn",
//                "-Xnew-inference",
//                "-P", "plugin:androidx.compose.compiler.plugins.kotlin:generateDecoys=true"
//            )
//        }
        browser {
            binaries.executable()
            webpackTask {
                cssSupport.enabled = true
            }

            runTask {
                cssSupport.enabled = true
            }

            testTask {
                useKarma {
                    useChromeHeadless()
                    webpackConfig.cssSupport.enabled = true
                }
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
//                implementation(kotlin("stdlib-common"))
                implementation("io.sooj:compose:${SOOJ_VERSION}")
                implementation("io.sooj:sooj:${SOOJ_VERSION}")
//                implementation(project(":"))
//                implementation(project(":compose"))
//                implementation(project(":"))
//                implementation("io.sooj:sooj:${SOOJ_VERSION}")
//                implementation("io.sooj:sooj:0.0.1b-SNAPSHOT")
//                implementation("io.sooj:framework:0.0.1b-SNAPSHOT")
//                implementation("io.sooj:sooj:0.0.1b-SNAPSHOT")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
    }
}

tasks.create<JavaExec>("serverRun").apply {
    dependsOn(tasks.getByName("jsBrowserDevelopmentWebpack"))
    dependsOn(tasks.getByName("jvmJar"))
    classpath(tasks.getByName("jvmJar"))
}

configureComposeCompiler()