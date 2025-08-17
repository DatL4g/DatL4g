package dev.datlag.homepage.components.style

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.silk.components.text.SpanTextStyle
import com.varabyte.kobweb.silk.style.addVariantBase
import com.varabyte.kobweb.silk.theme.colors.palette.color
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette

// For occasional text that we want to de-emphasize a bit, e.g. for subtitles.
// Note: We used to use the opacity style for this, but that caused an issue with the way blur was calculated, for the
// header glass effect, so we use alpha here instead.
val MutedSpanTextVariant = SpanTextStyle.addVariantBase {
    Modifier.color(colorMode.toPalette().color.toRgb().copyf(alpha = 0.7f))
}