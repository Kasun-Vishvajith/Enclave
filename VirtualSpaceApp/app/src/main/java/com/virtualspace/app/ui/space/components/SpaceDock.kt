package com.virtualspace.app.ui.space.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.virtualspace.app.core.theme.WorkspaceBorder
import com.virtualspace.app.core.theme.WorkspaceWhite
import com.virtualspace.app.data.model.SpaceApp

@Composable
fun SpaceDock(
    pinnedApps: List<SpaceApp>,
    onAppTap: (SpaceApp) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(80.dp)
            .background(
                color = WorkspaceWhite.copy(alpha = 0.9f),
                shape = RoundedCornerShape(20.dp)
            )
            .border(
                width = 2.dp,
                color = WorkspaceBorder,
                shape = RoundedCornerShape(20.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            pinnedApps.take(4).forEach { app ->
                SpaceAppIcon(
                    app = app,
                    onTap = { onAppTap(app) },
                    onLongPress = { }, // No long press in dock for now
                    modifier = Modifier.size(64.dp)
                )
            }
        }
    }
}
