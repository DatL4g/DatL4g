import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.ScriptCrossorigin
import kotlinx.html.link
import kotlinx.html.meta
import kotlinx.html.script
import java.nio.file.Files
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

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
            head.add {
                val name = "yandex-verification" // Fix for gradle cache

                meta(
                    name = name,
                    content = "e3ddb616d3fefa55"
                )
            }
            head.add {
                val name = "naver-site-verification" // Fix for gradle cache

                meta(
                    name = name,
                    content = ""
                )
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

            implementation(libs.tooling.wanakana)
        }
    }
}

tasks.register("generateSitemap") {
    group = "kobweb"
    description = "Generate sitemap.xml from the Kobweb export output"

    val exportDir = (findProperty("kobwebSiteDir") as? String?)?.ifBlank {
        null
    }?.let { file(it) } ?: layout.projectDirectory.dir(".kobweb/site").asFile

    val baseUrl = (findProperty("sitemapBaseUrl") as? String?)?.ifBlank {
        null
    } ?: "https://datlag.dev"

    val excludedPrefixes = (findProperty("sitemapExcludes") as? String?)?.ifBlank {
        null
    }?.split(',')?.map { it.trim().trim('/') }?.filter { it.isNotBlank() }
        ?: listOf(
            "yandex_e3ddb616d3fefa55",
            "navera11ac17817104547c5db4123359748bc"
        )

    val exportFile = File(exportDir, "sitemap.xml")

    inputs.dir(exportDir)
    outputs.file(exportFile)

    doLast {
        require(exportDir.exists()) {
            "Export dir not found: $exportDir. Run `export` first."
        }

        fun xmlEscape(s: String): String {
            return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
        }

        val base = baseUrl.removeSuffix("/")
        val formatter = DateTimeFormatter.ISO_DATE
        val urls = mutableListOf<String>()

        Files.walk(exportDir.toPath()).filter {
            Files.isRegularFile(it) && (it.endsWith(".html") || it.toString().endsWith(".html"))
        }.forEach { path ->
            val fileName = path.fileName.toString()
            if (fileName == "404.html") return@forEach // Do not index the 404 page

            val rel = exportDir.toPath().relativize(path).toString().replace(File.separatorChar, '/')

            val urlPath = when {
                rel == "index.html" -> "" // root
                rel.endsWith("/index.html") -> rel.removeSuffix("/index.html") // folder pages
                else -> rel.removeSuffix(".html")
            }.trim('/')

            if (excludedPrefixes.any { urlPath.startsWith(it) }) return@forEach

            val lastMod = Files.getLastModifiedTime(path).toInstant().atOffset(ZoneOffset.UTC).toLocalDate()
            val loc = if (urlPath.isEmpty()) "$base/" else "$base/$urlPath"

            urls += """
                <url>
                  <loc>${xmlEscape(loc)}</loc>
                  <lastmod>${formatter.format(lastMod)}</lastmod>
                </url>
            """.trimIndent()
        }

        urls.sort()

        val xml = buildString {
            appendLine("""<?xml version="1.0" encoding="UTF-8"?>""")
            appendLine("""<urlset xmlns="http://www.sitemaps.org/schemas/sitemap/0.9">""")
            urls.forEach {
                appendLine(it)
            }
            appendLine("</urlset>")
        }

        exportFile.writeText(xml)
        println("Generated sitemap.xml with ${urls.size} URLs at: $exportFile")
    }
}