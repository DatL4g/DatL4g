package dev.datlag.homepage.components.sections.stack

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.BasePath
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.graphics.ImageDecoding
import com.varabyte.kobweb.silk.components.graphics.ImageLoading
import com.varabyte.kobweb.silk.components.graphics.ImageStyle
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.extendedBy
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import dev.datlag.homepage.components.sections.stack.style.SkillItemImageVariant
import dev.datlag.homepage.components.sections.stack.style.SkillProficiencyTextStyle
import dev.datlag.homepage.components.sections.stack.style.SkillTextStyle
import dev.datlag.homepage.components.sections.stack.style.SkillsGridStyle
import dev.datlag.homepage.model.Res
import dev.datlag.homepage.model.Skill
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Text

@Composable
fun Stack() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        H1(
            attrs = Modifier.textAlign(TextAlign.Center).toAttrs(),
        ) {
            Text(value = Res.strings.stackTitle)
        }
        SpanText(
            modifier = Modifier.textAlign(TextAlign.Center),
            text = Res.strings.stackDescription
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            SimpleGrid(
                modifier = SkillsGridStyle.toModifier(),
                numColumns = numColumns(base = 2, md = 5)
            ) {
                SkillItem(Skill.Kotlin)
                SkillItem(Skill.AndroidStudio)
                SkillItem(Skill.Compose)
                SkillItem(Skill.GitHub)
                SkillItem(Skill.Gradle)
                SkillItem(Skill.Firebase)
                SkillItem(Skill.PHP)
                SkillItem(Skill.JS)
                SkillItem(Skill.Git)
                SkillItem(Skill.Markdown)
            }
        }
    }
}

@Composable
private fun SkillItem(
    skill: Skill,
    colorMode: ColorMode = ColorMode.current,
    modifier: Modifier = Modifier,
    horizontal: Arrangement.Horizontal = Arrangement.Start
) {
    Row(
        modifier = modifier,
        horizontalArrangement = horizontal,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            src = if (colorMode.isLight) skill.iconLight else skill.iconDark,
            variant = SkillItemImageVariant,
            loading = ImageLoading.Lazy,
            decoding = ImageDecoding.Async,
            alt = skill.name
        )
        Column(
            modifier = Modifier.margin(left = 0.75.cssRem),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            SpanText(
                text = skill.name,
                modifier = SkillTextStyle.toModifier()
            )
            SpanText(
                text = skill.level.title,
                modifier = SkillProficiencyTextStyle.toModifier()
                    .color(when (colorMode) {
                        ColorMode.LIGHT -> Colors.Gray
                        ColorMode.DARK -> Colors.LightGray
                    })
            )
        }
    }
}