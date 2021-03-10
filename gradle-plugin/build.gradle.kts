import java.util.Date

plugins {
//    kotlin("jvm")
    `java-gradle-plugin`
    `kotlin-dsl`
    id("build-common")
}

buildscript {
    repositories {
        mavenCentral()
        jcenter()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
        maven {
            url = uri("https://dl.bintray.com/sooj/sooj")
        }
    }
}

repositories {
    mavenCentral()
    jcenter()
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
    maven {
        url = uri("https://dl.bintray.com/sooj/sooj")
    }
}

//kotlin {
//    target.compilations.all {
//        kotlinOptions.jvmTarget = JVM_TARGET
//    }
//}

dependencies {
    testImplementation(kotlin("test-junit"))
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN_PLUGIN")
    implementation("org.jetbrains.kotlin:kotlin-serialization:$KOTLIN_PLUGIN")
//    implementation("io.sooj:build-common:$SOOJ_VERSION")
//    implementation(project(":build-common"))
}

gradlePlugin {
    plugins {
        create("sooj-gradle-plugin") {
            id = "sooj"
            implementationClass = "io.sooj.gradle.plugin.SoojPlugin"
        }
    }
}

setupPublishing()