package dev.datlag.homepage.components.widgets.projects

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.BasePath
import com.varabyte.kobweb.silk.components.graphics.ImageStyle
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.shapes.RectF
import com.varabyte.kobweb.silk.theme.shapes.clip
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Img

@Composable
fun MimasuScreenshotSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .overflow(overflowX = Overflow.Auto, Overflow.Hidden)
            .flexWrap(FlexWrap.Nowrap)
            .gap(16.px)
            .padding(bottom = 8.px)
    ) {
        Img(
            src = BasePath.prependTo("/mimasu_1.webp"),
            alt = "Home",
            attrs = ImageStyle.toModifier().clip(RectF(10.px)).toAttrs {
                attr("loading", "lazy")
                attr("decoding", "async")
                attr("width", "350")
                attr("height", "720")
            }
        )
        Img(
            src = BasePath.prependTo("/mimasu_2.webp"),
            alt = "Series",
            attrs = ImageStyle.toModifier().clip(RectF(10.px)).toAttrs {
                attr("loading", "lazy")
                attr("decoding", "async")
                attr("width", "350")
                attr("height", "720")
            }
        )
        Img(
            src = BasePath.prependTo("/mimasu_3.webp"),
            alt = "Movie",
            attrs = ImageStyle.toModifier().clip(RectF(10.px)).toAttrs {
                attr("loading", "lazy")
                attr("decoding", "async")
                attr("width", "350")
                attr("height", "720")
            }
        )
    }
}