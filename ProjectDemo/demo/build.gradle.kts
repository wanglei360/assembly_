plugins {
    id(Plugin.ANDROID_LIBRARY)
    id(Plugin.KOTLIN_ANDROID)
}

android {
    compileSdk = AppInfo.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = AppInfo.MIN_SDK_VERSION
        targetSdk = AppInfo.TARGET_SDK_VERSION

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    //插件kotlin-android-extensions过时后使用ActivityMainBinding导入使用的
//    buildFeatures {
//        dataBinding = true
//        viewBinding = true
//    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(mapOf("path" to ":base_library")))
}