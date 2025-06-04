package dev.datlag.ui.custom

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.datlag.LocalDarkMode

@Composable
fun GitHubButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    iconSize: Dp = ButtonDefaults.IconSize,
    darkContainer: Boolean = !LocalDarkMode.current
) {
    val containerColor = remember(darkContainer) {
        if (darkContainer) {
            Color(0xFF24292e)
        } else {
            Color(0xFF2b3137)
        }
    }
    val contentColor = remember(darkContainer) {
        if (darkContainer) {
            Color(0xFFfafbfc)
        } else {
            Color(0xFFFFFFFF)
        }
    }
    val border = remember(enabled, darkContainer) {
        if (!enabled || darkContainer) {
            null
        } else {
            BorderStroke(
                width = 1.dp,
                color = contentColor.copy(alpha = 0.5F)
            )
        }
    }

    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        border = border
    ) {
        Icon(
            modifier = Modifier.size(iconSize),
            imageVector = MaterialSymbols.Github,
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(
            text = text,
            maxLines = 1,
            fontWeight = FontWeight.SemiBold
        )
    }
}