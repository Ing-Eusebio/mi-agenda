package com.recordatorios.voz.data

import android.content.Context

/**
 * Guarda el nombre de la persona que usa la app, para que la alarma pueda
 * decir "Ismael, reunión con María" en vez de solo "Reunión con María".
 */
object UserPrefs {
    private const val PREFS_NAME = "mi_agenda_prefs"
    private const val KEY_USER_NAME = "user_name"

    fun getName(context: Context): String? {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getString(KEY_USER_NAME, null)?.takeIf { it.isNotBlank() }
    }

    fun setName(context: Context, name: String) {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .edit()
            .putString(KEY_USER_NAME, name.trim())
            .apply()
    }
}
