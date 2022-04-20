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
rootProject.buildFileName = "../build.gradle.kts" // 指定脚本为build.gradle.kts，下一步介绍
includeBuild("../configuration")
rootProject.name = "ProjectLibrary"
include("base_library")
