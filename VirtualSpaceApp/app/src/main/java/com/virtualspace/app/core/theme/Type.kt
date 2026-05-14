package com.virtualspace.app.core.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// We'll assume Inter and Plus Jakarta Sans are available or will be added
val WorkspaceTypography = Typography(
    headlineMedium = TextStyle(
        fontFamily = FontFamily.Default, // Fallback to system default for now
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        color = WorkspaceTextPrimary
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = WorkspaceTextPrimary
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        color = WorkspaceTextSecondary
    )
)
