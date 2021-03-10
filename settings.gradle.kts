rootProject.name = "sooj"

includeBuild("build-common") {
//    dependencySubstitution {
//        substitute(module("io.sooj:build-common")).with(project(":"))
//    }
}

include(":framework")
include(":compose")
//include(":gen")
include(":browser")
//include(":test-plugin")

include(":gradle-plugin")