package dev.datlag.homepage.model

import com.varabyte.kobweb.browser.uri.encodeURIComponent
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors

sealed interface Socials {

    val link: String

    val brandColor: Color
    val color: Color

    data object LinkedIn : Socials {
        override val link: String = "https://linkedin.com/in/jeff-retz"
        override val color: Color = Colors.White
        override val brandColor: Color = Color.Companion.rgb(0x0a66c2)
    }

    data object Instagram : Socials {
        override val link: String = "https://instagram.com/the_dev_jeff"
        override val color: Color = Colors.White
        override val brandColor: Color = Color.Companion.rgb(0xe1306c)
    }

    data object GitHub : Socials {
        override val link: String = "https://github.com/DatL4g"
        override val color: Color = Colors.White
        override val brandColor: Color = Color.Companion.rgb(0x333333)
    }

    companion object {
        const val mailTo: String = "mailto:contact@datlag.dev"

        fun mailTo(
            name: String? = null,
            subject: String? = null,
            message: String? = null
        ): String {
            val body = """
                Hello from $name!
                
                $message
                """.trimIndent()
            return mailTo +
                    "?subject=${encodeURIComponent(subject ?: "")}" +
                    "&body=${encodeURIComponent(body)}"
        }
    }
}