plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

dependencies {
    compileOnly(gradleApi())
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.20")
    compileOnly("com.android.tools.build:gradle:7.1.2")
}

gradlePlugin {
    plugins {
        create("version") {
            //自定义plugin的id，其他module引用要用到
            id = "com.kts.lib"
            //指向自定义plugin类，因为我直接放在目录下，所以没有多余路径,但我没写插件，没用😄
            implementationClass = "KspDemo"
        }
    }
}