package com.virtualspace.app.ui.space.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.virtualspace.app.core.theme.WorkspacePaper

@Composable
fun SpaceWallpaper() {
    val infiniteTransition = rememberInfiniteTransition(label = "wallpaper")
    
    // Subtle movement for the grid/dots
    val offsetX by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 40f,
        animationSpec = infiniteRepeatable(
            animation = tween(10000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "offsetX"
    )
    
    val offsetY by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 40f,
        animationSpec = infiniteRepeatable(
            animation = tween(15000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "offsetY"
    )

    Canvas(modifier = Modifier.fillMaxSize()) {
        // Draw the light workspace background
        drawRect(color = WorkspacePaper)
        
        // Draw a subtle dot grid (2D Workspace style)
        val dotSpacing = 40.dp.toPx()
        val dotRadius = 1.dp.toPx()
        val gridColor = Color(0x1A2D2D2D) // Very subtle lines
        
        for (x in -1..(size.width / dotSpacing).toInt() + 1) {
            for (y in -1..(size.height / dotSpacing).toInt() + 1) {
                drawCircle(
                    color = gridColor,
                    radius = dotRadius,
                    center = Offset(
                        x * dotSpacing + offsetX % dotSpacing,
                        y * dotSpacing + offsetY % dotSpacing
                    )
                )
            }
        }
    }
}
