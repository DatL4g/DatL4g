package dev.datlag.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import dev.datlag.composeapp.generated.resources.Manrope_Bold
import dev.datlag.composeapp.generated.resources.Manrope_ExtraBold
import dev.datlag.composeapp.generated.resources.Manrope_ExtraLight
import dev.datlag.composeapp.generated.resources.Manrope_Light
import dev.datlag.composeapp.generated.resources.Manrope_Medium
import dev.datlag.composeapp.generated.resources.Manrope_Regular
import dev.datlag.composeapp.generated.resources.Manrope_SemiBold
import dev.datlag.composeapp.generated.resources.Manrope_VariableFont_wght
import dev.datlag.composeapp.generated.resources.NotoSansJP_Bold
import dev.datlag.composeapp.generated.resources.NotoSansJP_ExtraBold
import dev.datlag.composeapp.generated.resources.NotoSansJP_ExtraLight
import dev.datlag.composeapp.generated.resources.NotoSansJP_Light
import dev.datlag.composeapp.generated.resources.NotoSansJP_Medium
import dev.datlag.composeapp.generated.resources.NotoSansJP_Regular
import dev.datlag.composeapp.generated.resources.NotoSansJP_SemiBold
import dev.datlag.composeapp.generated.resources.NotoSansJP_VariableFont_wght
import dev.datlag.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

data object Font {

    @Composable
    fun family() = FontFamily(
        Font(Res.font.Manrope_ExtraLight, FontWeight.ExtraLight),
        Font(Res.font.Manrope_ExtraLight, FontWeight.ExtraLight, FontStyle.Italic),

        Font(Res.font.Manrope_Light, FontWeight.Light),
        Font(Res.font.Manrope_Light, FontWeight.Light, FontStyle.Italic),

        Font(Res.font.Manrope_Regular, FontWeight.Normal),
        Font(Res.font.Manrope_Regular, FontWeight.Normal, FontStyle.Italic),

        Font(Res.font.Manrope_Medium, FontWeight.Medium),
        Font(Res.font.Manrope_Medium, FontWeight.Medium, FontStyle.Italic),

        Font(Res.font.Manrope_SemiBold, FontWeight.SemiBold),
        Font(Res.font.Manrope_SemiBold, FontWeight.SemiBold, FontStyle.Italic),

        Font(Res.font.Manrope_Bold, FontWeight.Bold),
        Font(Res.font.Manrope_Bold, FontWeight.Bold, FontStyle.Italic),

        Font(Res.font.Manrope_ExtraBold, FontWeight.ExtraBold),
        Font(Res.font.Manrope_ExtraBold, FontWeight.ExtraBold, FontStyle.Italic),

        // Fallback
        Font(Res.font.Manrope_VariableFont_wght),
        Font(Res.font.NotoSansJP_ExtraLight, FontWeight.ExtraLight),
        Font(Res.font.NotoSansJP_Light, FontWeight.Light),
        Font(Res.font.NotoSansJP_Regular, FontWeight.Normal),
        Font(Res.font.NotoSansJP_Medium, FontWeight.Medium),
        Font(Res.font.NotoSansJP_SemiBold, FontWeight.SemiBold),
        Font(Res.font.NotoSansJP_Bold, FontWeight.Bold),
        Font(Res.font.NotoSansJP_ExtraBold, FontWeight.ExtraBold),
        Font(Res.font.NotoSansJP_VariableFont_wght),
    )

}