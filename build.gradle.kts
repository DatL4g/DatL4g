plugins {
    alias(libs.plugins.atomicfu) apply false
    alias(libs.plugins.multiplatform).apply(false)
    alias(libs.plugins.compose.compiler).apply(false)
    alias(libs.plugins.compose).apply(false)
}

// Force new atomicfu version, compose uses 0.23.2
allprojects {
    configurations.all {
        resolutionStrategy.eachDependency {
            if (requested.group == "org.jetbrains.kotlinx" && requested.name.startsWith("atomicfu")) {
                useVersion(libs.versions.atomicfu.get())
            }
        }
    }
}