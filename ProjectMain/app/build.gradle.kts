plugins {
    id(Plugin.ANDROID_APPLICATION)
    id(Plugin.KOTLIN_ANDROID)
//    id("kotlin-parcelize")
}

android {

    compileSdk = AppInfo.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = AppInfo.APPLICATION_ID
        minSdk = AppInfo.MIN_SDK_VERSION
        targetSdk = AppInfo.TARGET_SDK_VERSION
        versionCode = AppInfo.APP_VERSION_NAME.replace(".", "").toInt()
        versionName = AppInfo.APP_VERSION_NAME
//        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    //插件kotlin-android-extensions过时后使用ActivityMainBinding导入使用的
//    buildFeatures {
//        dataBinding = true
//        viewBinding = true
//    }

    // 修改签名文件
    signingConfigs {
        create(AppInfo.RUN_ENVIRONMENT_RELEASE) {
//        create("release") {
            storeFile = file("../com.qifa.sellerNew.jks")
            storePassword = "1x2x3x"
            keyAlias = "qifa"
            keyPassword = "1x2x3x"
        }
        getByName(AppInfo.RUN_ENVIRONMENT_DEBUG) {
//        getByName("debug") {
            storeFile = file("../com.qifa.sellerNew.jks")
            storePassword = "1x2x3x"
            keyAlias = "qifa"
            keyPassword = "1x2x3x"
        }
    }

    buildTypes {

        val release = getByName(AppInfo.RUN_ENVIRONMENT_RELEASE)
//        val release = getByName("release")
        release.apply {
            isMinifyEnabled = true//混淆暂时先关闭，pda在初始化的时候经常会崩溃，还没找到解决办法
            isZipAlignEnabled = true// Zipalign优化 TODO 已过时，已无效，替代未找到
            isShrinkResources = true// 移除无用的resource文件,该选项必须打开混淆，否则编译不通过
            isDebuggable = false//是否允许调试
            isJniDebuggable = false//是否允许调试
            isRenderscriptDebuggable = false// 构建类型是否配置为生成具有可调试RenderScript代码的apk。
            signingConfig = signingConfigs.getByName(AppInfo.RUN_ENVIRONMENT_RELEASE)
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }

        val debug = getByName(AppInfo.RUN_ENVIRONMENT_DEBUG)
        debug.apply {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    // 修改apk名字和输出路径
    android.applicationVariants.all {
        val buildType = this.buildType.name // release或者debug
        outputs.all {
            // 判断是否是输出 apk 类型
            if (this is com.android.build.gradle.internal.api.ApkVariantOutputImpl) {
                // 修改apk名字
                outputFileName = "$name-${defaultConfig.versionName}.apk"
                // 正式环境修改apk输出路径
                if (buildType == "Release" || buildType == AppInfo.RUN_ENVIRONMENT_RELEASE)
                    packageApplicationProvider.get().outputDirectory.set(File("../apk${versionName}"))
            }
        }
    }

    val dimensionStr = "exchange"
    flavorDimensions.add(dimensionStr)
    productFlavors {
        create("shang_jia_duan") {
            dimension = dimensionStr
            buildConfigField("String", "host_cn", "\"https://api-cn.tianxuan.link/\"")
            buildConfigField("String", "host_or", "\"https://api-ru.tianxuan.link/\"")
            buildConfigField(
                "String",
                "inn",
                "\"https://suggestions.dadata.ru/suggestions/api/4_1/rs/findById/party?token=\""
            )
            manifestPlaceholders["app_name"] = "@string/mapp_name"
            manifestPlaceholders["app_icon"] = "@mipmap/ic_launcher"
            applicationId = AppInfo.APPLICATION_ID
            signingConfig = signingConfigs.getByName(AppInfo.RUN_ENVIRONMENT_RELEASE)
        }
        create("m_test") {
            dimension = dimensionStr
            buildConfigField("String", "host_cn", "\"https://api-cn.tianxuan.link/\"")
            buildConfigField("String", "host_or", "\"https://api-ru.tianxuan.link/\"")
            buildConfigField(
                "String",
                "inn",
                "\"https://suggestions.dadata.ru/suggestions/api/4_1/rs/findById/party?token=\""
            )
            manifestPlaceholders["app_name"] = "@string/mapp_name"
            manifestPlaceholders["app_icon"] = "@mipmap/ic_launcher"
            applicationId = AppInfo.APPLICATION_ID_TEST
            signingConfig = signingConfigs.getByName(AppInfo.RUN_ENVIRONMENT_DEBUG)
        }
    }
}

dependencies {
    implementation(project(mapOf("path" to ":lib")))
//    implementation(project(mapOf("path" to ":mylibrary")))
    implementation(project(mapOf("path" to ":base_library")))
    implementation(project(mapOf("path" to ":demo")))

    //recyclerview
//    implementation("androidx.recyclerview:recyclerview:1.2.1")
//    implementation 'androidx.recyclerview:recyclerview:1.2.1'
}