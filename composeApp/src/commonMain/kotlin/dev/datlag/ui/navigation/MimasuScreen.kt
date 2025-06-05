package dev.datlag.ui.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.outlined.Lightbulb
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.datlag.LocalDarkMode
import dev.datlag.composeapp.generated.resources.Res
import dev.datlag.composeapp.generated.resources.cookies_usage
import dev.datlag.composeapp.generated.resources.github_repository
import dev.datlag.composeapp.generated.resources.google_play
import dev.datlag.composeapp.generated.resources.mimasu
import dev.datlag.composeapp.generated.resources.mimasu_description
import dev.datlag.composeapp.generated.resources.mimasu_description_full
import dev.datlag.other.Constants
import dev.datlag.tooling.Platform
import dev.datlag.tooling.compose.platform.typography
import dev.datlag.ui.custom.GitHubButton
import dev.datlag.ui.custom.GoogleButton
import dev.datlag.ui.custom.MaterialSymbols
import dev.datlag.ui.navigation.components.AboutSection
import dev.datlag.ui.navigation.components.ScreenshotSection
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MimasuScreen(
    modifier: Modifier = Modifier,
    triggerTheme: () -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val cookiesText = stringResource(Res.string.cookies_usage)

    Scaffold(
        modifier = modifier,
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = {
                    Text(text = stringResource(Res.string.mimasu))
                },
                actions = {
                    IconButton(
                        onClick = triggerTheme
                    ) {
                        val enabled = !LocalDarkMode.current

                        MaterialSymbols(
                            name = MaterialSymbols.LIGHTBULB,
                            contentDescription = null,
                            filled = enabled,
                            fallback = if (enabled) {
                                Icons.Filled.Lightbulb
                            } else {
                                Icons.Outlined.Lightbulb
                            }
                        )
                    }
                    AboutSection()
                }
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
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
                        .padding(16.dp),
                    text = stringResource(Res.string.mimasu_description),
                    textAlign = TextAlign.Center,
                )
            }
            item {
                ScreenshotSection(
                    modifier = Modifier.fillParentMaxWidth()
                )
            }
            item {
                Text(
                    modifier = Modifier
                        .fillParentMaxWidth()
                        .padding(16.dp),
                    text = stringResource(Res.string.mimasu_description_full),
                    textAlign = TextAlign.Center,
                    style = Platform.typography().bodyLarge
                )
            }
            item {
                FlowRow(
                    modifier = Modifier
                        .fillParentMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
                    verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
                    maxItemsInEachRow = 2
                ) {
                    val uriHandler = LocalUriHandler.current

                    GitHubButton(
                        modifier = Modifier.weight(1F),
                        onClick = {
                            uriHandler.openUri(Constants.MIMASU_GITHUB_REPO)
                        },
                        text = stringResource(Res.string.github_repository)
                    )
                    GoogleButton(
                        modifier = Modifier.weight(1F),
                        onClick = {
                            uriHandler.openUri(Constants.MIMASU_GOOGLE_PLAY)
                        },
                        text = stringResource(Res.string.google_play)
                    )
                }
            }
        }
    }

    LaunchedEffect(cookiesText) {
        if (cookiesText.isNotBlank()) {
            snackbarHostState.showSnackbar(
                message = cookiesText,
                withDismissAction = true,
                duration = SnackbarDuration.Indefinite
            )
        }
    }
}