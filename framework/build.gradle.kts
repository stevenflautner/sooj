plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm {
        compilation()
    }
    js(IR) {
        browser()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":compose"))
            }
        }
        val jsMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1")
                implementation("org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.3")
            }
        }
    }
}

configureComposeCompiler()