package com.virtualspace.app.core.navigation

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.virtualspace.app.ui.appviewer.AppViewerScreen
import com.virtualspace.app.ui.space.SpaceHomeScreen

@Composable
fun SpaceNavGraph(
    navController: NavHostController,
    startDestination: String = SpaceDestinations.HOME,
    deepLinkAppId: String? = null
) {
    NavHost(
        navController = navController,
        startDestination = if (deepLinkAppId != null)
            "${SpaceDestinations.APP_VIEWER}/$deepLinkAppId"
        else SpaceDestinations.HOME
    ) {
        composable(SpaceDestinations.HOME) {
            SpaceHomeScreen(navController = navController)
        }
        composable(
            route = "${SpaceDestinations.APP_VIEWER}/{appId}",
            arguments = listOf(navArgument("appId") { type = NavType.StringType }),
            enterTransition = {
                slideInVertically(initialOffsetY = { it }) + fadeIn()
            },
            exitTransition = {
                slideOutVertically(targetOffsetY = { it }) + fadeOut()
            }
        ) { backStackEntry ->
            val appId = backStackEntry.arguments?.getString("appId") ?: return@composable
            AppViewerScreen(appId = appId, navController = navController)
        }
    }
}
