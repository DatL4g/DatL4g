package dev.datlag.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import dev.datlag.composeapp.generated.resources.Manrope_VariableFont_wght
import dev.datlag.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.preloadFont

data object Font {

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    fun family(): FontFamily {
        val extraLight by preloadFont(Res.font.Manrope_VariableFont_wght, FontWeight.ExtraLight)
        val extraLightItalic by preloadFont(Res.font.Manrope_VariableFont_wght, FontWeight.ExtraLight, FontStyle.Italic)
        val light by preloadFont(Res.font.Manrope_VariableFont_wght, FontWeight.Light)
        val lightItalic by preloadFont(Res.font.Manrope_VariableFont_wght, FontWeight.Light, FontStyle.Italic)
        val regular by preloadFont(Res.font.Manrope_VariableFont_wght, FontWeight.Normal)
        val regularItalic by preloadFont(Res.font.Manrope_VariableFont_wght, FontWeight.Normal, FontStyle.Italic)
        val medium by preloadFont(Res.font.Manrope_VariableFont_wght, FontWeight.Medium)
        val mediumItalic by preloadFont(Res.font.Manrope_VariableFont_wght, FontWeight.Medium, FontStyle.Italic)
        val semiBold by preloadFont(Res.font.Manrope_VariableFont_wght, FontWeight.SemiBold)
        val semiBoldItalic by preloadFont(Res.font.Manrope_VariableFont_wght, FontWeight.SemiBold, FontStyle.Italic)
        val bold by preloadFont(Res.font.Manrope_VariableFont_wght, FontWeight.Bold)
        val boldItalic by preloadFont(Res.font.Manrope_VariableFont_wght, FontWeight.Bold, FontStyle.Italic)
        val extraBold by preloadFont(Res.font.Manrope_VariableFont_wght, FontWeight.ExtraBold)
        val extraBoldItalic by preloadFont(Res.font.Manrope_VariableFont_wght, FontWeight.ExtraBold, FontStyle.Italic)

        val loadedFonts = remember(
            extraLight, extraLightItalic,
            light, lightItalic,
            regular, regularItalic,
            medium, mediumItalic,
            semiBold, semiBoldItalic,
            bold, boldItalic,
            extraBold, extraBoldItalic
        ) {
            listOfNotNull(
                extraLight, extraLightItalic,
                light, lightItalic,
                regular, regularItalic,
                medium, mediumItalic,
                semiBold, semiBoldItalic,
                bold, boldItalic,
                extraBold, extraBoldItalic
            )
        }
        return if (loadedFonts.isNotEmpty()) {
            FontFamily(loadedFonts)
        } else {
            FontFamily.Default
        }
    }

}