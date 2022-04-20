pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.buildFileName = "../build.gradle.kts" // 指定脚本为build.gradle.kts
includeBuild("../configuration")
rootProject.name = "ProjectDemo"
include(":demo")

include(":base_library")
project(":base_library").projectDir =
    File(settingsDir, "../ProjectLibrary/base_library")