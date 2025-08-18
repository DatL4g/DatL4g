package dev.datlag.homepage

import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.color

class SitePalette(
    val nearBackground: Color,
    val background: Color,
    val brand: Brand,
) {
    class Brand(
        val primary: Color = Color.rgb(0x3C83EF),
        val accent: Color = Color.rgb(0xF3DB5B),
    )
}

object SitePalettes {
    val light = SitePalette(
        nearBackground = Color.rgb(0xF4F6FA),
        background = Color.rgb(0xFAFAFA),
        brand = SitePalette.Brand(
            primary = Color.rgb(0x3C83EF),
            accent = Color.rgb(0xFCBA03),
        )
    )
    val dark = SitePalette(
        nearBackground = Color.rgb(0x13171F),
        background = Color.rgb(0x06080B),
        brand = SitePalette.Brand(
            primary = Color.rgb(0x3C83EF),
            accent = Color.rgb(0xF3DB5B),
        )
    )
}

fun ColorMode.toSitePalette(): SitePalette {
    return when (this) {
        ColorMode.LIGHT -> SitePalettes.light
        ColorMode.DARK -> SitePalettes.dark
    }
}

@InitSilk
fun initTheme(ctx: InitSilkContext) {
    ctx.theme.palettes.light.background = SitePalettes.light.background
    ctx.theme.palettes.light.color = Colors.Black
    ctx.theme.palettes.dark.background = SitePalettes.dark.background
    ctx.theme.palettes.dark.color = Colors.White
}
