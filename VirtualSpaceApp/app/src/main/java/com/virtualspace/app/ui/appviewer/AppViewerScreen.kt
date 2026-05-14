package com.virtualspace.app.ui.appviewer

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.virtualspace.app.core.theme.WorkspaceBorder
import com.virtualspace.app.core.theme.WorkspaceWhite

@Composable
fun AppViewerScreen(
    appId: String,
    navController: NavHostController
) {
    // In a real app, fetch app details by ID
    val appName = appId.replaceFirstChar { it.uppercase() }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        color = WorkspaceWhite
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            // App Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = WorkspaceBorder
                    )
                }
                
                Text(
                    text = appName,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = WorkspaceBorder
                )
            }
            
            // App Content Placeholder
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .border(
                        width = 2.dp,
                        color = WorkspaceBorder,
                        shape = RoundedCornerShape(16.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "$appName Mini-App Content",
                    style = MaterialTheme.typography.bodyLarge,
                    color = WorkspaceBorder.copy(alpha = 0.5f)
                )
            }
            
            Spacer(modifier = Modifier.navigationBarsPadding())
        }
    }
}
