package dev.datlag.ui.navigation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.datlag.composeapp.generated.resources.Res
import dev.datlag.composeapp.generated.resources.data_protection
import dev.datlag.composeapp.generated.resources.data_protection_text
import dev.datlag.composeapp.generated.resources.imprint
import dev.datlag.composeapp.generated.resources.imprint_text
import dev.datlag.other.Constants
import dev.datlag.tooling.Platform
import dev.datlag.tooling.compose.platform.typography
import dev.datlag.ui.custom.MaterialSymbols
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutSection(
    modifier: Modifier = Modifier
) {
    var showInfo by remember { mutableStateOf(false) }

    if (showInfo) {
        ModalBottomSheet(
            onDismissRequest = {
                showInfo = false
            }
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    Text(
                        text = stringResource(Res.string.imprint),
                        style = Platform.typography().headlineMedium
                    )
                }
                item {
                    SelectionContainer {
                        Text(text = Constants.OWNER)
                    }
                }
                item {
                    SelectionContainer {
                        Text(text = Constants.ownerContact)
                    }
                }
                item {
                    Text(
                        modifier = Modifier.padding(vertical = 8.dp),
                        text = stringResource(Res.string.imprint_text)
                    )
                }
                item {
                    Text(
                        modifier = Modifier.padding(top = 16.dp),
                        text = stringResource(Res.string.data_protection),
                        style = Platform.typography().titleLarge
                    )
                }
                item {
                    Text(text = stringResource(Res.string.data_protection_text))
                }
            }
        }
    }

    IconButton(
        onClick = {
            showInfo = !showInfo
        },
        modifier = modifier
    ) {
        MaterialSymbols(
            name = MaterialSymbols.INFO,
            contentDescription = null,
            filled = showInfo
        )
    }
}