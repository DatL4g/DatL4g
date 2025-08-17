package dev.datlag.homepage.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.flexDirection
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.leftRight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.data.add
import com.varabyte.kobweb.core.init.InitRoute
import com.varabyte.kobweb.core.init.InitRouteContext
import com.varabyte.kobweb.core.layout.Layout
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaGithub
import com.varabyte.kobweb.silk.components.icons.fa.FaInstagram
import com.varabyte.kobweb.silk.components.icons.fa.FaLinkedinIn
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.shapes.Circle
import com.varabyte.kobweb.silk.theme.shapes.Rect
import com.varabyte.kobweb.silk.theme.shapes.clip
import dev.datlag.homepage.components.layouts.PageLayoutData
import dev.datlag.homepage.other.Socials
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.Text

@InitRoute
fun initAboutUsPage(ctx: InitRouteContext) {
    ctx.data.add(PageLayoutData("About"))
}

@OptIn(DelicateApi::class)
@Page
@Layout(".components.layouts.PageLayout")
@Composable
fun AboutPage() {
    Column(
        modifier = Modifier.gap(2.cssRem).padding {
            leftRight(16.px)
        },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val breakpoint = rememberBreakpoint()

        H1 {
            Text(value = "About Me")
        }
        Row(
            modifier = Modifier
                .gap(1.cssRem)
                .flexDirection(if (breakpoint <= Breakpoint.SM) FlexDirection.Column else FlexDirection.Row),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                src = "/self.jpg",
                description = "Jeff Retz",
                modifier = Modifier.clip(Rect(0, 20.px)),
                height = 384,
                width = 288
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                H3 {
                    Text(value = "Jeff Retz")
                }
                SpanText(
                    text = "I am a qualified Software Developer from \uD83C\uDDE9\uD83C\uDDEA Germany.",
                    modifier = Modifier.textAlign(TextAlign.Center)
                )
                SpanText(
                    text = "After 3 years of dual apprenticeship and additional 3-4 years professional experience, I started my studies and am self-employed.",
                    modifier = Modifier.textAlign(TextAlign.Center)
                )
                SpanText(
                    text = "I specialized in the Kotlin ecosystem, especially in the multiplatform context and contribute to several open source projects.",
                    modifier = Modifier.textAlign(TextAlign.Center)
                )

                Row(
                    modifier = Modifier.margin(top = 16.px, bottom = 16.px),
                    horizontalArrangement = Arrangement.spacedBy(16.px),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SocialCircle(
                        provider = Socials.LinkedIn,
                    ) {
                        FaLinkedinIn(it)
                    }
                    SocialCircle(
                        provider = Socials.Instagram
                    ) {
                        FaInstagram(it)
                    }
                    SocialCircle(
                        provider = Socials.GitHub
                    ) {
                        FaGithub(it)
                    }
                }
            }
        }
    }
}

@Composable
private fun SocialCircle(
    provider: Socials,
    icon: @Composable (Modifier) -> Unit
) {
    A(
        href = provider.link,
        attrs = Modifier
            .size(48.px)
            .display(DisplayStyle.Flex)
            .justifyContent(JustifyContent.Center)
            .alignItems(AlignItems.Center)
            .background(provider.brandColor)
            .clip(Circle())
            .textDecorationLine(TextDecorationLine.None)
            .toAttrs()
    ) {
        icon(Modifier.color(provider.color))
    }
}