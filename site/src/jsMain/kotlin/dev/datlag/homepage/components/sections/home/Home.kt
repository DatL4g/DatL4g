package dev.datlag.homepage.components.sections.home

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import dev.datlag.homepage.SitePalette
import dev.datlag.homepage.components.sections.home.style.HelloImStyle
import dev.datlag.homepage.components.sections.home.style.UserNameStyle
import dev.datlag.homepage.components.sections.home.style.UsersMessageStyle
import dev.datlag.homepage.model.Res
import dev.datlag.homepage.toSitePalette
import org.jetbrains.compose.web.css.vh

@Composable
fun Home(currentPalette: SitePalette = ColorMode.current.toSitePalette()) {
    Column(
        modifier = Modifier.fillMaxWidth().height(50.vh),
        verticalArrangement = Arrangement.Center
    ) {
        SpanText(
            text = Res.strings.homeGreeting,
            modifier = HelloImStyle.toModifier()
                .fontWeight(FontWeight.Lighter)
        )
        SpanText(
            text = Res.strings.name,
            modifier = UserNameStyle.toModifier()
        )
        SpanText(
            text = Res.strings.homeSubtitle,
            modifier = UsersMessageStyle.toModifier()
                .color(currentPalette.brand.primary)
        )
    }
}