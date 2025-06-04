package dev.datlag

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import dev.datlag.tooling.compose.toTypography
import dev.datlag.ui.navigation.MimasuScreen
import dev.datlag.ui.theme.Colors
import dev.datlag.ui.theme.Font
import org.jetbrains.compose.ui.tooling.preview.Preview

val LocalDarkMode = compositionLocalOf<Boolean> { error("No dark mode state provided") }

@Preview
@Composable
fun App(
    systemDarkTheme: Boolean = isSystemInDarkTheme()
) {
    CompositionLocalProvider(
        LocalDarkMode provides systemDarkTheme
    ) {
        MaterialTheme(
            colorScheme = if (systemDarkTheme) Colors.getDarkScheme() else Colors.getLightScheme(),
            typography = Font.family().toTypography(),
        ) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background,
                contentColor = MaterialTheme.colorScheme.onBackground
            ) {
                MimasuScreen(
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}
