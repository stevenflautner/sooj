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
        val jsMain by getting {
            dependencies {
                implementation(project(":framework"))
            }
        }
    }
}


//// THIS GIVES RUNTIME ERROR OF SHOULD
//// HAVE BEEN REPLACED BY COMPILER IF MISSING//configureComposeCompiler()
//dependencies {
//    "kotlinCompilerPluginClasspath"(files("$rootDir/libs/embedded.jar"))
//}
configureComposeCompiler()