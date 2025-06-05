package dev.datlag.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.pointerInput

@Composable
fun Modifier.hoverTiltEffect(
    maxTiltAngle: Float = 2f, // Maximum tilt in degrees
): Modifier {
    var rotationX by remember { mutableFloatStateOf(0f) }
    var rotationY by remember { mutableFloatStateOf(0f) }
    var scale by remember { mutableFloatStateOf(1F) }

    return this.graphicsLayer {
        this.rotationX = rotationX
        this.rotationY = rotationY
        this.scaleX = scale
        this.scaleY = scale
    }.pointerInput(Unit) {
        awaitPointerEventScope {
            while (true) {
                val event = awaitPointerEvent()
                when (event.type) {
                    PointerEventType.Enter -> {
                        scale = 1.02F
                    }
                    PointerEventType.Move -> {
                        val position = event.changes.first().position
                        val (width, height) = size
                        val centerX = width / 2f
                        val centerY = height / 2f

                        val normalizedX = (position.x - centerX) / centerX
                        val normalizedY = (position.y - centerY) / centerY

                        rotationY = -normalizedX * maxTiltAngle
                        rotationX = normalizedY * maxTiltAngle
                    }
                    PointerEventType.Exit -> {
                        rotationX = 0f
                        rotationY = 0f
                        scale = 1F
                    }
                }
            }
        }
    }
}