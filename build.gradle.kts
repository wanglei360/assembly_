plugins {
    id("com.android.application") version ("7.1.2") apply (false)
    id("org.jetbrains.kotlin.android") version ("1.6.20") apply (false)
    id("org.jetbrains.kotlin.jvm") version ("1.6.20") apply (false)
    id("com.kts.lib") apply(false)
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
