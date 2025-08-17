package dev.datlag.homepage.other

import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors

sealed interface Socials {

    val link: String

    val brandColor: Color
    val color: Color

    data object LinkedIn : Socials {
        override val link: String = "https://linkedin.com/in/jeff-retz"
        override val color: Color = Colors.White
        override val brandColor: Color = Color.rgb(0x0a66c2)
    }

    data object Instagram : Socials {
        override val link: String = "https://instagram.com/the_dev_jeff"
        override val color: Color = Colors.White
        override val brandColor: Color = Color.rgb(0xe1306c)
    }

    data object GitHub : Socials {
        override val link: String = ""
        override val color: Color = Colors.White
        override val brandColor: Color = Color.rgb(0x333333)
    }
}