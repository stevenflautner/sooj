import java.util.Date

plugins {
//    kotlin("jvm")
    `java-gradle-plugin`
    `kotlin-dsl`
    id("maven")
    id("maven-publish")
//    id("com.jfrog.bintray")
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
    implementation("io.sooj.build.common:build-common:SNAPSHOT")
}

gradlePlugin {
    plugins {
        create("sooj-gradle-plugin") {
            id = "sooj"
            implementationClass = "io.sooj.gradle.plugin.SoojPlugin"
        }
    }
}

// Publications

val artifactName = project.name
val artifactGroup = project.group.toString()
val artifactVersion = project.version.toString()

val bintrayRepo = "sooj"
val owner = "stevenflautner"
val packageName = "sooj-gradle-plugin"
val versionDescription = "Pre-release 0.0.1"
val license = "MIT"
val projVcsUrl = "https://github.com/stevenflautner/sooj.git"

val sourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.getByName("main").allSource)
}

//publishing {
//    publications {
//        create<MavenPublication>("sooj-gradle-plugin") {
//            groupId = artifactGroup
//            artifactId = artifactName
//            version = artifactVersion
//            from(components["java"])
//
//            artifact(sourcesJar)
//        }
//
//        bintray {
//            user = "stevenflautner"
//            key = project.findProperty("bintrayKey").toString()
//            publish = true
//
//            setPublications("sooj-gradle-plugin")
//
//            pkg.apply {
//                repo = bintrayRepo
//                name = packageName
//                userOrg = "sooj"
//                setLicenses("MIT")
//                vcsUrl = projVcsUrl
//                version.apply {
//                    name = artifactVersion
//                    desc = versionDescription
//                    released = Date().toString()
//                    vcsTag = artifactVersion
//                }
//            }
//        }
//    }
//}