import java.util.Date

plugins {
    kotlin("multiplatform")
    id("build-common")
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
    maven {
        url = uri("https://dl.bintray.com/skipn/sooj" )
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
        maven {
            url = uri("https://dl.bintray.com/skipn/sooj" )
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
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$COROUTINES_VERSION")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:$SERIALIZATION_VERSION")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$SERIALIZATION_VERSION")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:$DATE_TIME_VERSION")
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("io.ktor:ktor-server-netty:$KTOR_VERSION")
                implementation("io.ktor:ktor-serialization:$KTOR_VERSION")

                implementation("io.ktor:ktor-client-core:$KTOR_VERSION")
                implementation("io.ktor:ktor-client-json:$KTOR_VERSION")
                implementation("io.ktor:ktor-client-serialization:$KTOR_VERSION")
            }
        }
    }
}

configureComposeCompiler()

allprojects {
    version = SOOJ_VERSION
    group = "io.sooj"
}

setupPublishing()

