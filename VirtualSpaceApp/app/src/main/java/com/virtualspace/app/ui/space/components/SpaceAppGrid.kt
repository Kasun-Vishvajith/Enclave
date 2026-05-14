package com.virtualspace.app.ui.space.components

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.virtualspace.app.data.model.SpaceApp
import kotlinx.coroutines.delay

@Composable
fun SpaceAppGrid(
    apps: List<SpaceApp>,
    onAppTap: (SpaceApp) -> Unit,
    onAppLongPress: (SpaceApp) -> Unit
) {
    var visible by remember { mutableStateOf(false) }
    
    LaunchedEffect(Unit) {
        delay(100)
        visible = true
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        contentPadding = PaddingValues(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(apps, key = { _, app -> app.id }) { index, app ->
            var itemVisible by remember { mutableStateOf(false) }
            
            LaunchedEffect(visible) {
                if (visible) {
                    delay(index * 50L)
                    itemVisible = true
                }
            }
            
            AnimatedVisibility(
                visible = itemVisible,
                enter = fadeIn(animationSpec = tween(300)) + 
                        slideInVertically(
                            initialOffsetY = { 50 },
                            animationSpec = spring(stiffness = Spring.StiffnessLow)
                        )
            ) {
                SpaceAppIcon(
                    app = app,
                    onTap = { onAppTap(app) },
                    onLongPress = { onAppLongPress(app) }
                )
            }
        }
    }
}
