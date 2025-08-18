package dev.datlag.homepage.components.sections.home

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexDirection
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import dev.datlag.homepage.SitePalette
import dev.datlag.homepage.components.sections.home.style.HelloImStyle
import dev.datlag.homepage.components.sections.home.style.HeroContainerKeyFrames
import dev.datlag.homepage.components.sections.home.style.HeroSectionStyle
import dev.datlag.homepage.components.sections.home.style.UserNameStyle
import dev.datlag.homepage.components.sections.home.style.UsersMessageStyle
import dev.datlag.homepage.toSitePalette
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.s
import org.jetbrains.compose.web.css.vh

@Composable
fun Home(currentPalette: SitePalette = ColorMode.current.toSitePalette()) {
    Column(
        modifier = Modifier.fillMaxWidth().height(50.vh),
        verticalArrangement = Arrangement.Center
    ) {
        SpanText(
            text = "Hello I'm",
            modifier = HelloImStyle.toModifier()
                .fontWeight(FontWeight.Lighter)
        )
        SpanText(
            text = "Jeff Retz",
            modifier = UserNameStyle.toModifier()
        )
        SpanText(
            text = "A professional Kotlin Multiplatform Developer",
            modifier = UsersMessageStyle.toModifier()
                .color(currentPalette.brand.primary)
        )
    }
}