plugins {
    kotlin("multiplatform")
    id("build-common")
}

kotlin {
    js(IR) {
        browser()
    }
    jvm {
        compilation()
//        testRuns["test"].executionTask.configure {
//            useJUnit()
//        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation("org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.3")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1")
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(kotlin("stdlib-js"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(kotlin("stdlib"))
                api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1")
            }
        }
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

setupPublishing()