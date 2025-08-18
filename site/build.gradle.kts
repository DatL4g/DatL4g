import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.ScriptCrossorigin
import kotlinx.html.link
import kotlinx.html.meta
import kotlinx.html.script

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kobweb.application)
    alias(libs.plugins.kobwebx.markdown)
}

group = "dev.datlag.homepage"
version = "1.0.0-SNAPSHOT"

kobweb {
    app {
        index {
            head.add {
                val name = "google-adsense-account" // Fix for gradle cache

                meta(
                    name = name,
                    content = "ca-pub-1012952679774175"
                )
            }
            head.add {
                val source = "https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js?client=ca-pub-1012952679774175" // Fix for gradle cache

                script(
                    type = null,
                    src = source,
                    crossorigin = ScriptCrossorigin.anonymous
                ) {
                    async = true
                }
            }
            head.add {
                link(href = "./favicon-180x180.png", rel = "apple-touch-icon") {
                    sizes = "180x180"
                }
            }
            head.add {
                link(href = "./favicon-32x32.png", rel = "icon", type = "image/png") {
                    sizes = "32x32"
                }
            }
            head.add {
                link(href = "./favicon-16x16.png", rel = "icon", type = "image/png") {
                    sizes = "16x16"
                }
            }
            head.add {
                link(href = "./manifest.json", rel = "manifest")
            }
            description.set("Jeff Retz - Professional Kotlin Multiplatform Developer")
        }
    }
}

kotlin {
    configAsKobwebApplication("homepage")

    sourceSets {
        jsMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.silk)
            // This default template uses built-in SVG icons, but what's available is limited.
            // Uncomment the following if you want access to a large set of font-awesome icons:
            implementation(libs.silk.icons.fa)
            implementation(libs.kobwebx.markdown)
        }
    }
}
