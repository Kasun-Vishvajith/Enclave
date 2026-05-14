package com.virtualspace.app.ui.space.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.virtualspace.app.core.theme.WorkspaceBorder
import com.virtualspace.app.core.theme.WorkspaceTextPrimary
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun SpaceTopBar() {
    var currentTime by remember { mutableStateOf(Calendar.getInstance().time) }
    
    LaunchedEffect(Unit) {
        while (true) {
            currentTime = Calendar.getInstance().time
            kotlinx.coroutines.delay(1000)
        }
    }
    
    val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
            .statusBarsPadding(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "Workspace",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = WorkspaceTextPrimary
            )
            Text(
                text = timeFormat.format(currentTime),
                fontSize = 12.sp,
                color = WorkspaceTextPrimary.copy(alpha = 0.6f)
            )
        }
        
        IconButton(onClick = { /* TODO: Open Settings */ }) {
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "Settings",
                tint = WorkspaceBorder
            )
        }
    }
}
