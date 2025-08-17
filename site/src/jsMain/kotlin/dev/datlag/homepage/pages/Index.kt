package dev.datlag.homepage.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.StyleVariable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.data.add
import com.varabyte.kobweb.core.init.InitRoute
import com.varabyte.kobweb.core.init.InitRouteContext
import com.varabyte.kobweb.core.layout.Layout
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.ColorPalettes
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.fr
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import dev.datlag.homepage.HeadlineTextStyle
import dev.datlag.homepage.SubheadlineTextStyle
import dev.datlag.homepage.components.layouts.PageLayoutData
import dev.datlag.homepage.toSitePalette

// Container that has a tagline and grid on desktop, and just the tagline on mobile
val HeroContainerStyle = CssStyle {
    base { Modifier.fillMaxWidth().gap(2.cssRem) }
    Breakpoint.MD { Modifier.margin { top(20.vh) } }
}

@InitRoute
fun initHomePage(ctx: InitRouteContext) {
    ctx.data.add(PageLayoutData("Home"))
}

@Page
@Layout(".components.layouts.PageLayout")
@Composable
fun HomePage() {
    Row(HeroContainerStyle.toModifier()) {
        Box {
            val sitePalette = ColorMode.current.toSitePalette()

            Column(Modifier.gap(2.cssRem)) {
                Div(HeadlineTextStyle.toAttrs()) {
                    SpanText(
                        "Use this template as your starting point for ", Modifier.color(
                            when (ColorMode.current) {
                                ColorMode.LIGHT -> Colors.Black
                                ColorMode.DARK -> Colors.White
                            }
                        )
                    )
                    SpanText(
                        "Kobweb",
                        Modifier
                            .color(sitePalette.brand.accent)
                            // Use a shadow so this light-colored word is more visible in light mode
                            .textShadow(0.px, 0.px, blurRadius = 0.5.cssRem, color = Colors.Gray)
                    )
                }

                Div(SubheadlineTextStyle.toAttrs()) {
                    SpanText("You can read the ")
                    Link("/about", "About")
                    SpanText(" page for more information.")
                }

                val ctx = rememberPageContext()
                Button(onClick = {
                    // Change this click handler with your call-to-action behavior
                    // here. Link to an order page? Open a calendar UI? Play a movie?
                    // Up to you!
                    ctx.router.tryRoutingTo("/contact")
                }, colorPalette = ColorPalettes.Blue) {
                    Text("This could be your CTA")
                }
            }
        }
    }
}
