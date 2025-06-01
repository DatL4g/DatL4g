package dev.datlag

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.datlag.composeapp.generated.resources.Res
import dev.datlag.composeapp.generated.resources.github_repository
import dev.datlag.composeapp.generated.resources.google_play
import dev.datlag.composeapp.generated.resources.mimasu
import dev.datlag.composeapp.generated.resources.mimasu_description
import dev.datlag.other.Constants
import dev.datlag.ui.custom.GitHubButton
import dev.datlag.ui.custom.GoogleButton
import dev.datlag.ui.theme.Colors
import org.jetbrains.compose.resources.stringResource
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
            colorScheme = if (systemDarkTheme) Colors.getDarkScheme() else Colors.getLightScheme()
        ) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background,
                contentColor = MaterialTheme.colorScheme.onBackground
            ) {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { padding ->
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = padding,
                        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        item {
                            Text(
                                modifier = Modifier
                                    .fillParentMaxWidth()
                                    .padding(horizontal = 16.dp),
                                text = stringResource(Res.string.mimasu),
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.headlineLarge,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                        item {
                            Text(
                                modifier = Modifier
                                    .fillParentMaxWidth()
                                    .padding(horizontal = 16.dp),
                                text = stringResource(Res.string.mimasu_description),
                                textAlign = TextAlign.Center,
                            )
                        }
                        item {
                            FlowRow(
                                modifier = Modifier
                                    .fillParentMaxWidth()
                                    .padding(horizontal = 16.dp),
                                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
                                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
                                maxItemsInEachRow = 2
                            ) {
                                val uriHandler = LocalUriHandler.current

                                GitHubButton(
                                    onClick = {
                                        uriHandler.openUri(Constants.MIMASU_GITHUB_REPO)
                                    },
                                    modifier = Modifier.weight(1F),
                                    text = stringResource(Res.string.github_repository)
                                )
                                GoogleButton(
                                    onClick = {
                                        uriHandler.openUri(Constants.MIMASU_GITHUB_REPO)
                                    },
                                    modifier = Modifier.weight(1F),
                                    text = stringResource(Res.string.google_play)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
