package dev.datlag.homepage.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.browser.uri.encodeURIComponent
import com.varabyte.kobweb.compose.css.Appearance
import com.varabyte.kobweb.compose.css.CSSPosition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.GridEntry.Companion.repeat
import com.varabyte.kobweb.compose.css.StyleVariable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.appearance
import com.varabyte.kobweb.compose.css.color
import com.varabyte.kobweb.compose.css.fontSize
import com.varabyte.kobweb.compose.css.functions.RadialGradient
import com.varabyte.kobweb.compose.css.functions.radialGradient
import com.varabyte.kobweb.compose.css.height
import com.varabyte.kobweb.compose.css.outline
import com.varabyte.kobweb.compose.css.transition
import com.varabyte.kobweb.compose.css.width
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.BoxScope
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.backgroundImage
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.flexDirection
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.grid
import com.varabyte.kobweb.compose.ui.modifiers.gridItem
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.leftRight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.setVariable
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.compose.ui.toStyles
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.data.add
import com.varabyte.kobweb.core.init.InitRoute
import com.varabyte.kobweb.core.init.InitRouteContext
import com.varabyte.kobweb.core.layout.Layout
import com.varabyte.kobweb.silk.components.forms.InputDefaults
import com.varabyte.kobweb.silk.components.forms.InputGroup
import com.varabyte.kobweb.silk.components.forms.InputGroupStyle
import com.varabyte.kobweb.silk.components.forms.InputStyle
import com.varabyte.kobweb.silk.components.forms.InputVars
import com.varabyte.kobweb.silk.components.forms.TextInput
import com.varabyte.kobweb.silk.components.icons.fa.FaDiscord
import com.varabyte.kobweb.silk.components.icons.fa.FaEnvelopesBulk
import com.varabyte.kobweb.silk.components.icons.fa.FaGithub
import com.varabyte.kobweb.silk.components.icons.fa.FaInstagram
import com.varabyte.kobweb.silk.components.icons.fa.FaLinkedin
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.style.vars.color.ColorVar
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import dev.datlag.homepage.components.layouts.PageLayoutData
import dev.datlag.homepage.model.Res
import dev.datlag.homepage.model.Socials
import dev.datlag.homepage.toSitePalette
import kotlinx.browser.window
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.onSubmit
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.Transition
import org.jetbrains.compose.web.css.border
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.fr
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.maxWidth
import org.jetbrains.compose.web.css.minHeight
import org.jetbrains.compose.web.css.outline
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Form
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.SubmitInput
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.TextArea
import org.w3c.dom.HTMLDivElement

val ContactItemStyle = CssStyle.base {
    Modifier.margin(18.px)
}


@InitRoute
fun initContactPage(ctx: InitRouteContext) {
    ctx.data.add(PageLayoutData(Res.strings.contact))
}

@Page
@Layout(".components.layouts.PageLayout")
@Composable
fun ContactPage() {
    Column(
        modifier = Modifier.padding {
            leftRight(16.px)
        },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var name by remember { mutableStateOf("") }
        var subject by remember { mutableStateOf("") }
        var message by remember { mutableStateOf("") }

        H1(Modifier.gap(2.cssRem).toAttrs()) {
            Text(value = Res.strings.contact)
        }
        SpanText(
            text = Res.strings.contactText1,
            modifier = Modifier.textAlign(TextAlign.Center)
        )
        SpanText(
            text = Res.strings.contactText2,
            modifier = Modifier.textAlign(TextAlign.Center)
        )
        SimpleGrid(numColumns(1, md = 2)) {
            ContactItem {
                FaEnvelopesBulk()
                SpanText(Res.strings.contactEmail, Modifier.fontWeight(FontWeight.Bold).margin(bottom = 0.75.cssRem))
                A(href = Socials.mailTo) {
                    SpanText(Res.strings.contactEmailName)
                }
            }
            ContactItem {
                FaLinkedin()
                SpanText(Res.strings.contactLinkedIn, Modifier.fontWeight(FontWeight.Bold).margin(bottom = 0.75.cssRem))
                A(href = Socials.LinkedIn.link) {
                    SpanText(Res.strings.contactLinkedInName)
                }
            }
            ContactItem {
                FaGithub()
                SpanText(Res.strings.contactGitHub, Modifier.fontWeight(FontWeight.Bold).margin(bottom = 0.75.cssRem))
                A(href = Socials.GitHub.link) {
                    SpanText(Res.strings.contactGitHubName)
                }
            }
            ContactItem {
                FaInstagram()
                SpanText(Res.strings.contactInstagram, Modifier.fontWeight(FontWeight.Bold).margin(bottom = 0.75.cssRem))
                A(href = Socials.Instagram.link) {
                    SpanText(Res.strings.contactInstagramName)
                }
            }
        }
        H2(Modifier.gap(2.cssRem).toAttrs()) {
            Text(Res.strings.contactSendMessage)
        }
        Form(
            attrs = Modifier
                .display(DisplayStyle.Flex)
                .flexDirection(FlexDirection.Column)
                .gap(12.px)
                .maxWidth(400.px)
                .margin(bottom = 16.px)
                .toAttrs {
                    onSubmit { event ->
                        event.preventDefault()

                        window.open(
                            Socials.mailTo(
                                name = name,
                                subject = subject,
                                message = message
                            ),
                            "_blank"
                        )
                    }
                }
        ) {
            InputGroup {
                TextInput(
                    text = name,
                    onTextChange = { name = it },
                    placeholder = Res.strings.contactFieldName
                )
            }
            InputGroup {
                TextInput(
                    text = subject,
                    onTextChange = { subject = it },
                    placeholder = Res.strings.contactFieldSubject
                )
            }
            Row(
                InputGroupStyle.toModifier()
                    .then(InputDefaults.Size.toModifier())
                    .position(Position.Relative)
                    .alignItems(AlignItems.Stretch)
            ) {
                TextArea(message) {
                    placeholder(Res.strings.contactFieldMessage)
                    value(message)
                    onInput { message = it.value }
                    classes("silk-input", "silk-input-outlined")
                    style {
                        width(400.px)
                        minHeight(100.px)
                    }
                }
            }
            InputGroup {
                Input(type = InputType.Submit, value = Unit, onValueChange = {})
            }
        }
    }
}

private fun Modifier.background(colorMode: ColorMode) =
    this.then(when (colorMode) {
        ColorMode.DARK -> Modifier.backgroundImage(
            radialGradient(Color.rgb(41, 41, 46), Color.rgb(25, 25, 28), RadialGradient.Shape.Circle, CSSPosition.Top)
        )
        ColorMode.LIGHT -> Modifier.backgroundColor(Colors.White)
    })

@Composable
private fun ContactItem(content: @Composable ColumnScope.() -> Unit) {
    Box(
        ContactItemStyle.toModifier()
            .borderRadius(12.px)
            .background(ColorMode.current)
            .padding(2.em)
    ) {
        Column(content = content)
    }
}