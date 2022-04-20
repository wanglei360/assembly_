pluginManagement {
    //TODO 在app的module中引入插件需添加这个代码块
//    resolutionStrategy {
//        eachPlugin {
    //todo 如果是groupId
//            if (requested.id.namespace == 'lugins') {
//                // groupId:artifactId:version
//                useModule("${requested.id.namespace}:${requested.id.name}:${requested.version}")
//            }
//        }
//    }
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
//        maven("https://dl.bintray.com/kotlin/kotlin-eap")
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
rootProject.name = "ProjectMain" // 项目名称，自己取

include("app")
include("lib")

mInclude("ProjectLibrary")
mInclude("ProjectDemo")
fun mInclude(libraryPrjectName: String) {
    //拿到最外层BaseLibrary文件夹
    file("../$libraryPrjectName").apply {
        System.out.println("it11 = ${name}")
        //便利BaseLibrary文件夹,得到例如base_library的子集目录
        listFiles()?.forEach { sonFile ->
            if (sonFile.isDirectory) {//如果是文件夹
                sonFile.listFiles()?.forEach {
                    if (it.name == "src") {
                        System.out.println("<<<<<<------->>>$name  ${sonFile.name}   ${it.name}")
                        include(":${sonFile.name}")
                        project(":${sonFile.name}").projectDir =
                            File(settingsDir, "../$libraryPrjectName/${sonFile.name}")
                    }
                }
            }
        }
    }
}