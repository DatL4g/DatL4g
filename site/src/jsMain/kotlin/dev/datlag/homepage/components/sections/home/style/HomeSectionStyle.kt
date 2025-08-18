package dev.datlag.homepage.components.sections.home.style

import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.scale
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.extendedBy
import dev.datlag.homepage.components.style.SectionContainerStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh

val HeroSectionStyle = SectionContainerStyle.extendedBy {
    Breakpoint.ZERO {
        Modifier
            .height(85.vh)
    }
    Breakpoint.SM {
        Modifier
            .height(85.vh)
    }
    Breakpoint.MD {
        Modifier
            .height(100.vh)
    }
    Breakpoint.LG {
        Modifier
            .height(100.vh)
    }

    Breakpoint.XL {
        Modifier
            .height(100.vh)
    }
}

val HelloImStyle = CssStyle {
    Breakpoint.ZERO {
        Modifier.fontSize(FontSize.XXLarge)
    }

    Breakpoint.SM {
        Modifier.fontSize(FontSize.XXLarge)
    }
    Breakpoint.MD {
        Modifier.fontSize(FontSize.XLarge)
    }
    Breakpoint.LG {
        Modifier.fontSize(2.5.cssRem)
    }

    Breakpoint.XL {
        Modifier.fontSize(2.5.cssRem)
    }
}

val UserNameStyle = CssStyle {
    base {
        Modifier
            .fontSize(3.cssRem)
            .fontWeight(FontWeight.Bold)
            .textAlign(TextAlign.Start)
    }

    Breakpoint.LG {
        Modifier.fontSize(4.cssRem)
    }

    Breakpoint.XL {
        Modifier.fontSize(4.cssRem)
    }
}

val UsersMessageStyle = CssStyle {
    Breakpoint.ZERO {
        Modifier.fontSize(FontSize.Medium)
    }

    Breakpoint.SM {
        Modifier.fontSize(FontSize.Medium)
    }
    Breakpoint.MD {
        Modifier.fontSize(FontSize.Large)
    }
    Breakpoint.LG {
        Modifier.fontSize(FontSize.XXLarge)
    }

    Breakpoint.XL {
        Modifier.fontSize(FontSize.XXLarge)
    }
}

val HeroContainerKeyFrames = Keyframes {
    0.percent {
        Modifier
            .margin(left = (-30).percent)
            .opacity(0)
            .scale(1)
    }
    100.percent {
        Modifier
            .margin(left = 0.px)
            .opacity(1)
            .scale(1.0)
    }
}