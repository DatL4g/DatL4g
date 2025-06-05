package dev.datlag.ui.navigation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import dev.datlag.common.hoverTiltEffect
import dev.datlag.composeapp.generated.resources.Res
import dev.datlag.composeapp.generated.resources.mimasu_1
import dev.datlag.composeapp.generated.resources.mimasu_2
import dev.datlag.composeapp.generated.resources.mimasu_3
import dev.datlag.tooling.Platform
import dev.datlag.tooling.compose.platform.shapes
import org.jetbrains.compose.resources.painterResource

@Composable
fun ScreenshotSection(
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
    ) {
        item {
            Image(
                modifier = Modifier
                    .width(350.dp)
                    .height(720.dp)
                    .hoverTiltEffect()
                    .shadow(
                        elevation = 8.dp,
                        shape = Platform.shapes().medium,
                        ambientColor = LocalContentColor.current,
                        spotColor = LocalContentColor.current
                    ),
                painter = painterResource(Res.drawable.mimasu_1),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        item {
            Image(
                modifier = Modifier
                    .width(350.dp)
                    .height(720.dp)
                    .hoverTiltEffect()
                    .shadow(
                        elevation = 8.dp,
                        shape = Platform.shapes().medium,
                        ambientColor = LocalContentColor.current,
                        spotColor = LocalContentColor.current
                    ),
                painter = painterResource(Res.drawable.mimasu_2),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        item {
            Image(
                modifier = Modifier
                    .width(350.dp)
                    .height(720.dp)
                    .hoverTiltEffect()
                    .shadow(
                        elevation = 8.dp,
                        shape = Platform.shapes().medium,
                        ambientColor = LocalContentColor.current,
                        spotColor = LocalContentColor.current
                    ),
                painter = painterResource(Res.drawable.mimasu_3),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}