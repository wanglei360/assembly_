package com.kts.plugcodekotlin

import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.LibraryPlugin
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.PluginContainer

/** * 创建者：leiwu
 * * 时间：2022/4/21 17:10
 * * 类描述：
 * * 修改人：
 * * 修改时间：
 * * 修改备注：com.kts.plugcodekotlin.ConfigPlugin
 */
class ConfigPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        System.out.println("tttttttttt  apply")
        project.plugins.config(project)
    }

    private fun PluginContainer.config(project: Project) {
        whenPluginAdded {
            when (it) {
                //com.android.application
                is AppPlugin -> {
                    //公共插件
                    project.configAppPlugin()
                    //公共 android 配置项
                    project.extensions.getByType(AppExtension::class.java).configAppAndroid(project)
                    //公共依赖
//                    project.configAppDependencies()
                }
                //com.android.library
                is LibraryPlugin -> {
                    //公共插件
                    project.configLibraryPlugin()
                    //公共 android 配置项
                    project.extensions.getByType(AppExtension::class.java).configLibraryAndroid(project)
                }
//                is KotlinAndroidPluginWrapper -> {
//
//                }
            }
        }
    }

    /**
     * app Module 配置项，plugin 代码块
     */
    private fun Project.configAppPlugin() {
        plugins.apply("org.jetbrains.kotlin.android")
    }

    /**
     * app Module 配置项，android 代码块
     */
    private fun AppExtension.configAppAndroid(project: Project) {
        compileSdkVersion(32)
        defaultConfig {
            it.minSdk = 21
            it.targetSdk = 32
            it.versionCode = 55
            it.versionName = "77.0"
        }
        compileOptions {
            it.sourceCompatibility(JavaVersion.VERSION_1_8)
            it.targetCompatibility(JavaVersion.VERSION_1_8)
        }
    }

    /**
     * library Module 配置项，plugin 代码块
     */
    private fun Project.configLibraryPlugin() {
        plugins.apply("org.jetbrains.kotlin.android")
    }

    /**
     * library Module 配置项，android 代码块
     */
    private fun AppExtension.configLibraryAndroid(project: Project) {
        compileSdkVersion(32)
        defaultConfig {
            it.minSdk = 21
            it.targetSdk = 32
        }
        compileOptions {
            it.sourceCompatibility(JavaVersion.VERSION_1_8)
            it.targetCompatibility(JavaVersion.VERSION_1_8)
        }
    }

    /**
     * library Module 配置项
     */
    private fun LibraryExtension.applyLibraryCommons(project: Project) {
//        applyBaseCommons(project)

        /*onVariants.withBuildType("debug") {
            androidTest {
                enabled = false
            }
        }*/
    }
}