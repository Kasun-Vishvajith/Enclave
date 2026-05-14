package com.virtualspace.app.core.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val WorkspaceShapes = Shapes(
    small = RoundedCornerShape(8.dp),   // Icon backgrounds - slightly sharper
    medium = RoundedCornerShape(12.dp),  // Cards, dock
    large = RoundedCornerShape(16.dp)    // Bottom sheets, app viewer
)
