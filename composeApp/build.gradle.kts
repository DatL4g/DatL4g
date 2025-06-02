import org.jetbrains.compose.ExperimentalComposeLibrary

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose)
}

val artifact = "dev.datlag"
group = artifact

kotlin {
    wasmJs {
        outputModuleName.set("composeApp.js")
        browser()
        binaries.executable()
    }

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)

            implementation(libs.tooling.compose)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.uiTest)
        }

    }
}

compose {
    resources {
        generateResClass = auto
    }
}
