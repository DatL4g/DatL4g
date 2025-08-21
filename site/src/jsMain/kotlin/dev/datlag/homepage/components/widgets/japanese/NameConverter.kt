package dev.datlag.homepage.components.widgets.japanese

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.css.CSSPosition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.functions.RadialGradient
import com.varabyte.kobweb.compose.css.functions.radialGradient
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.backgroundImage
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.forms.InputGroup
import com.varabyte.kobweb.silk.components.forms.TextInput
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import dev.datlag.homepage.model.KanaConverter
import dev.datlag.tooling.wanakana.WanaKana
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Span

private fun Modifier.background(colorMode: ColorMode) =
    this.then(when (colorMode) {
        ColorMode.DARK -> Modifier.backgroundImage(
            radialGradient(Color.rgb(41, 41, 46), Color.rgb(25, 25, 28), RadialGradient.Shape.Circle, CSSPosition.Top)
        )
        ColorMode.LIGHT -> Modifier.backgroundColor(Colors.White)
    })

@Composable
fun NameConverter() {
    var input by remember { mutableStateOf("") }
    val convertedToKana = remember(input) {
        WanaKana.stripOkurigana(KanaConverter.convertToKana(input))
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .borderRadius(12.px)
            .background(ColorMode.current)
            .padding(2.em),
        verticalArrangement = Arrangement.spacedBy(8.px)
    ) {
        Span {
            SpanText(
                text = "Katakana: ",
                modifier = Modifier.fontWeight(FontWeight.Bold)
            )
            SpanText(text = convertedToKana)
        }
        Span {
            SpanText(
                text = "Romaji: ",
                modifier = Modifier.fontWeight(FontWeight.Bold)
            )
            SpanText(text = WanaKana.toRomaji(convertedToKana).replace("/", " / ").trim())
        }
        InputGroup(
            modifier = Modifier.fillMaxWidth()
        ) {
            TextInput(
                text = input,
                onTextChange = {
                    input = it
                },
                placeholder = "Enter your name"
            )
        }
    }
}