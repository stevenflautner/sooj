import io.sooj.gradle.plugin.sooj

plugins {
    application
}

buildscript {
    repositories {
        mavenLocal()
//        maven {
//            url = uri("https://plugins.gradle.org/m2/")
//        }
//        maven { url = uri("https://repo1.maven.org/maven2") }
//        maven {
//            url = uri("https://dl.bintray.com/skipn/skipn")
//        }
    }
    dependencies {
        classpath("io.sooj:gradle-plugin:$SOOJ_VERSION")
    }
}

println("ASj")

apply<io.sooj.gradle.plugin.SoojPlugin>()

sooj {

}

configureComposeCompiler()

//kotlin {
//    jvm {
////        compilation()
//        compilations.all {
//            kotlinOptions.jvmTarget = "11"
//        }
//        withJava()
//        val jvmJar by tasks.getting(org.gradle.jvm.tasks.Jar::class) {
//            doFirst {
//                manifest {
//                    attributes["Main-Class"] = "ServerKt"
//                }
//                from(configurations.getByName("runtimeClasspath").map { if (it.isDirectory) it else zipTree(it) })
//            }
//        }
//    }
//    js(IR) {
//        browser {
//            binaries.executable()
//            webpackTask {
//                cssSupport.enabled = true
//            }
//
//            runTask {
//                cssSupport.enabled = true
//            }
//
//            testTask {
//                useKarma {
//                    useChromeHeadless()
//                    webpackConfig.cssSupport.enabled = true
//                }
//            }
//        }
//    }
//
//    sourceSets {
//        val commonMain by getting {
//            dependencies {
//                implementation(kotlin("stdlib-common"))
//                implementation("io.sooj:compose:${SOOJ_VERSION}")
//                implementation("io.sooj:sooj:${SOOJ_VERSION}")
////                implementation(project(":"))
////                implementation("io.sooj:sooj:0.0.1b-SNAPSHOT")
////                implementation("io.sooj:framework:0.0.1b-SNAPSHOT")
////                implementation("io.sooj:sooj:0.0.1b-SNAPSHOT")
//            }
//        }
//        val commonTest by getting {
//            dependencies {
//                implementation(kotlin("test-common"))
//                implementation(kotlin("test-annotations-common"))
//            }
//        }
//    }
//}
//
//tasks.create<JavaExec>("serverRun").apply {
//    dependsOn(tasks.getByName("jsBrowserDevelopmentWebpack"))
//    dependsOn(tasks.getByName("jvmJar"))
//    classpath(tasks.getByName("jvmJar"))
//}
//
//configureComposeCompiler()