rootProject.name = "sooj"

includeBuild("build-common")

include(":framework")
include(":compose")
//include(":gen")
include(":browser")
include(":test-plugin")

include(":gradle-plugin")
