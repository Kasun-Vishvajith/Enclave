package com.virtualspace.app.ui.space

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.virtualspace.app.core.navigation.SpaceDestinations
import com.virtualspace.app.ui.space.components.SpaceAppGrid
import com.virtualspace.app.ui.space.components.SpaceDock
import com.virtualspace.app.ui.space.components.SpaceTopBar
import com.virtualspace.app.ui.space.components.SpaceWallpaper

@Composable
fun SpaceHomeScreen(
    navController: NavHostController,
    viewModel: SpaceHomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        SpaceWallpaper()
        
        Column(modifier = Modifier.fillMaxSize()) {
            SpaceTopBar()
            
            Box(modifier = Modifier.weight(1f)) {
                SpaceAppGrid(
                    apps = uiState.apps,
                    onAppTap = { app ->
                        navController.navigate("${SpaceDestinations.APP_VIEWER}/${app.id}")
                    },
                    onAppLongPress = { /* TODO: Context Menu */ }
                )
            }
            
            SpaceDock(
                pinnedApps = uiState.pinnedApps,
                onAppTap = { app ->
                    navController.navigate("${SpaceDestinations.APP_VIEWER}/${app.id}")
                }
            )
            
            Spacer(modifier = Modifier.navigationBarsPadding())
        }
    }
}
