package com.virtualspace.app.core.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat
import com.virtualspace.app.MainActivity
import com.virtualspace.app.data.model.SpaceApp

object ShortcutUtils {

    fun pinAppToHomeScreen(context: Context, spaceApp: SpaceApp) {
        if (!ShortcutManagerCompat.isRequestPinShortcutSupported(context)) return

        val intent = Intent(context, MainActivity::class.java).apply {
            action = Intent.ACTION_VIEW
            data = Uri.parse("virtualspace://open/${spaceApp.id}")
            flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        }

        val shortcutInfo = ShortcutInfoCompat.Builder(context, spaceApp.id)
            .setShortLabel(spaceApp.name)
            .setLongLabel("Open ${spaceApp.name} in Virtual Space")
            // In a real app, use the actual icon resource
            // .setIcon(IconCompat.createWithResource(context, spaceApp.iconRes))
            .setIntent(intent)
            .build()

        ShortcutManagerCompat.requestPinShortcut(context, shortcutInfo, null)
    }
}
