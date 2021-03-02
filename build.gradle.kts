plugins {
    kotlin("multiplatform")
}

repositories {
    jcenter()
    libsRepository(rootDir)
}

subprojects {
    repositories {
        jcenter()
        libsRepository(rootDir)
    }
}

//buildscript {
//    repositories {
//        jcenter()
//        libsRepository(rootDir)
//    }
//    dependencies {
//        "kotlinCompilerPluginClasspath"(files("$rootDir/libs/embedded.jar"))
//    }
//}

kotlin {
    jvm {
        compilation()
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
                implementation(project(":compose"))
                implementation(project(":framework"))
            }
        }
    }
}

tasks.create<JavaExec>("serverRun").apply {
    dependsOn(tasks.getByName("jsBrowserDevelopmentWebpack"))
    dependsOn(tasks.getByName("jvmJar"))
    classpath(tasks.getByName("jvmJar"))
}

//tasks.getByName("compileKotlin").apply {
//    doFirst {
//        project.ext["server"] = true
//    }
//}

gradle.taskGraph.beforeTask {
    project.ext["server"] = true
}

configureComposeCompiler()