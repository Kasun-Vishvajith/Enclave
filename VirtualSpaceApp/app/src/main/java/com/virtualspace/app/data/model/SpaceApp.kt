package com.virtualspace.app.data.model

import androidx.compose.ui.graphics.Color

data class SpaceApp(
    val id: String,                    // Unique identifier e.g. "notes", "calculator"
    val name: String,                  // Display name e.g. "Notes"
    val iconRes: Int,                  // Drawable resource ID for the icon
    val lottieRes: Int? = null,        // Optional Lottie animation on tap
    val route: String,                 // Navigation route to open the app
    val isPinnable: Boolean = true,    // Whether user can pin to home screen
    val accentColor: Long = 0xFF4A90E2 // Per-app accent color (default blue)
)
