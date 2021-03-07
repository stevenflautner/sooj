plugins {
    kotlin("jvm") version "1.4.30"
    `kotlin-dsl`
    `java-gradle-plugin`
}

group = "io.sooj.build.common"
version = "SNAPSHOT"

repositories {
    jcenter()
}

kotlin {
    target {
        compilations.configureEach {
            kotlinOptions.jvmTarget = "1.8"
            kotlinOptions.freeCompilerArgs += listOf(
                "-Xopt-in=kotlin.RequiresOptIn",
                "-Xnew-inference",
                "-P", "plugin:androidx.compose.compiler.plugins.kotlin:generateDecoys=true"
            )
        }
    }
}

dependencies {
    implementation(kotlin("gradle-plugin"))
    implementation(gradleApi())
    implementation(gradleKotlinDsl())
}

gradlePlugin {
    plugins.register("build-common") {
        id = "build-common"
        implementationClass = "BuildCommon"
    }
}