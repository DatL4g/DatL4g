package dev.datlag.homepage.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.dom.svg.Text
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.Anchor
import com.varabyte.kobweb.silk.components.icons.fa.FaGithub
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.style.vars.color.ColorVar
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import dev.datlag.homepage.components.style.MutedSpanTextVariant
import dev.datlag.homepage.components.style.SiteTextSize
import dev.datlag.homepage.components.style.dividerBoxShadow
import dev.datlag.homepage.components.style.siteText
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.Span
import dev.datlag.homepage.toSitePalette
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Text

@Composable
private fun OssLabel() {
    Span(Modifier.margin(bottom = 2.cssRem).whiteSpace(WhiteSpace.PreWrap).textAlign(TextAlign.Center).toAttrs()) {
        FaGithub(Modifier.margin(right = 8.px))
        Text("This site is ")
        Link("https://github.com/DatL4g/DatL4g", "open source")
        Text(".")
    }
}

@Composable
fun Footer(modifier: Modifier = Modifier) {
    Box(
        Modifier.fillMaxWidth().minHeight(200.px).dividerBoxShadow().then(modifier),
        contentAlignment = Alignment.Center
    ) {
        Column(
            Modifier.fillMaxWidth(70.percent).margin(1.em),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OssLabel()
            SpanText(
                "Copyright © 2025 Jeff Retz. All rights reserved.",
                Modifier.siteText(SiteTextSize.TINY).textAlign(TextAlign.Center),
                MutedSpanTextVariant
            )
        }
    }
}