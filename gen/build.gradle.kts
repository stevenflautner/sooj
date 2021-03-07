plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

kotlin {
    target.compilations.all {
        kotlinOptions.jvmTarget = "1.8"
    }
    val jar by tasks.getting(org.gradle.jvm.tasks.Jar::class) {
        doFirst {
            manifest {
                attributes["Main-Class"] = "GeneratorKt"
            }
            from(configurations.getByName("runtimeClasspath").map { if (it.isDirectory) it else zipTree(it) })
        }
    }
}

dependencies {
    implementation(project(":compose"))
    implementation(kotlin("stdlib"))
    implementation("com.squareup:kotlinpoet:1.7.2")
    implementation("io.github.enjoydambience:kotlinbard:0.4.0")
}

tasks.create<JavaExec>("generateModifiers").apply {
    dependsOn(tasks.getByName("jar"))
    classpath(tasks.getByName("jar"))
}