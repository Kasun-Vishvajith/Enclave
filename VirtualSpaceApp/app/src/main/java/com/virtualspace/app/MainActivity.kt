package com.virtualspace.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.virtualspace.app.core.navigation.SpaceNavGraph
import com.virtualspace.app.core.theme.VirtualSpaceTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val deepLinkAppId = intent?.data?.lastPathSegment
        
        enableEdgeToEdge()
        setContent {
            VirtualSpaceTheme {
                val navController = rememberNavController()
                SpaceNavGraph(
                    navController = navController,
                    deepLinkAppId = deepLinkAppId
                )
            }
        }
    }
}
