package dev.datlag.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import dev.datlag.composeapp.generated.resources.Manrope_VariableFont_wght
import dev.datlag.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

data object Font {

    @Composable
    fun family() = FontFamily(
        Font(Res.font.Manrope_VariableFont_wght, FontWeight.ExtraLight),
        Font(Res.font.Manrope_VariableFont_wght, FontWeight.ExtraLight, FontStyle.Italic),

        Font(Res.font.Manrope_VariableFont_wght, FontWeight.Light),
        Font(Res.font.Manrope_VariableFont_wght, FontWeight.Light, FontStyle.Italic),

        Font(Res.font.Manrope_VariableFont_wght, FontWeight.Normal),
        Font(Res.font.Manrope_VariableFont_wght, FontWeight.Normal, FontStyle.Italic),

        Font(Res.font.Manrope_VariableFont_wght, FontWeight.Medium),
        Font(Res.font.Manrope_VariableFont_wght, FontWeight.Medium, FontStyle.Italic),

        Font(Res.font.Manrope_VariableFont_wght, FontWeight.SemiBold),
        Font(Res.font.Manrope_VariableFont_wght, FontWeight.SemiBold, FontStyle.Italic),

        Font(Res.font.Manrope_VariableFont_wght, FontWeight.Bold),
        Font(Res.font.Manrope_VariableFont_wght, FontWeight.Bold, FontStyle.Italic),

        Font(Res.font.Manrope_VariableFont_wght, FontWeight.ExtraBold),
        Font(Res.font.Manrope_VariableFont_wght, FontWeight.ExtraBold, FontStyle.Italic),
    )

}