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
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.graphics.ImageDecoding
import com.varabyte.kobweb.silk.components.graphics.ImageLoading
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
        Image(
            src = "/mimasu_1.webp",
            alt = "Home",
            modifier = Modifier.clip(RectF(10.px)),
            loading = ImageLoading.Lazy,
            decoding = ImageDecoding.Async,
            width = 350,
            height = 720
        )
        Image(
            src = "/mimasu_2.webp",
            alt = "Series",
            modifier = Modifier.clip(RectF(10.px)),
            loading = ImageLoading.Lazy,
            decoding = ImageDecoding.Async,
            width = 350,
            height = 720
        )
        Image(
            src = "/mimasu_3.webp",
            alt = "Movie",
            modifier = Modifier.clip(RectF(10.px)),
            loading = ImageLoading.Lazy,
            decoding = ImageDecoding.Async,
            width = 350,
            height = 720
        )
    }
}