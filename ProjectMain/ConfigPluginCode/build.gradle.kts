plugins {
    id("org.jetbrains.kotlin.jvm")
    id("java-gradle-plugin")
    id("maven-publish")
}

dependencies {
    compileOnly("com.android.tools.build:gradle:4.1.1")
}

// todo 在app的module中引入插件时使用的格式是：  id 'groupId.artifactId' version 'version'
//定义Maven仓库信息
val MAVEN_GROUP_ID = "config"
val MAVEN_ARTIFACT_ID = "plugin"
val MAVEN_VERSION = "1.0.0"

//以下代码块就不需要单独创建resources/META-INF/gradle-plugins下的文件了
gradlePlugin {
    plugins {
        create("version") {
            //自定义plugin的id，其他module引用要用到
            id = "$MAVEN_GROUP_ID.$MAVEN_ARTIFACT_ID"
            //指向自定义plugin类，因为我直接放在目录下，所以没有多余路径
            implementationClass = "com.kts.plugcodekotlin.ConfigPlugin"
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("maven"){
            groupId = MAVEN_GROUP_ID
            artifactId = MAVEN_ARTIFACT_ID
            version = MAVEN_VERSION
            from(components["java"])
        }
    }
    repositories {
        maven {
            // 在跟目录中创建plugDemo为名字的插件
            setUrl("../../ConfigPlugin")
        }
    }
}


