package com.virtualspace.app.data.repository

import com.virtualspace.app.data.model.SpaceApp
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SpaceAppsRepository @Inject constructor() {

    fun getSpaceApps(): List<SpaceApp> {
        return listOf(
            SpaceApp(
                id = "notes", 
                name = "Notes", 
                iconRes = 0, // Placeholder
                route = "app_viewer/notes", 
                accentColor = 0xFF4CAF50
            ),
            SpaceApp(
                id = "calculator", 
                name = "Calc", 
                iconRes = 0, 
                route = "app_viewer/calculator", 
                accentColor = 0xFF2196F3
            ),
            SpaceApp(
                id = "clock", 
                name = "Clock", 
                iconRes = 0, 
                route = "app_viewer/clock", 
                accentColor = 0xFFFF9800
            ),
            SpaceApp(
                id = "weather", 
                name = "Weather", 
                iconRes = 0, 
                route = "app_viewer/weather", 
                accentColor = 0xFF00BCD4
            ),
            SpaceApp(
                id = "music", 
                name = "Music", 
                iconRes = 0, 
                route = "app_viewer/music", 
                accentColor = 0xFFE91E63
            ),
            SpaceApp(
                id = "browser", 
                name = "Browser", 
                iconRes = 0, 
                route = "app_viewer/browser", 
                accentColor = 0xFF9C27B0
            ),
        )
    }
}
