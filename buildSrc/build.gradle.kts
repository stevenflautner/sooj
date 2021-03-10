plugins {
    kotlin("jvm") version "1.4.31"
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`
    id("com.jfrog.bintray") version "1.8.5"
}

buildscript {
    dependencies {
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:0.13.0")
        classpath("com.jfrog.bintray.gradle:gradle-bintray-plugin:1.8.5")
    }
}

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("gradle-plugin"))
    implementation(gradleApi())
    implementation(gradleKotlinDsl())
    implementation("com.jfrog.bintray.gradle:gradle-bintray-plugin:1.8.5")
}
