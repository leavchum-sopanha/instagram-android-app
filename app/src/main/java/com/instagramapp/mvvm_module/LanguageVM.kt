package com.instagramapp.mvvm_module

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.instagramapp.MainActivity
import java.util.Locale

class LanguageViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    // Use SavedStateHandle to persist the current language
    private val _currentLanguage = mutableStateOf(savedStateHandle.get<String>("currentLanguage") ?: "en")
    val currentLanguage: State<String> get() = _currentLanguage

    // Emit a state change when the language is switched
    fun switchLanguage(context: Context) {
        val newLanguage = if (_currentLanguage.value == "en") "km" else "en" // Toggle between English and Khmer
        _currentLanguage.value = newLanguage
        savedStateHandle["currentLanguage"] = newLanguage // Save the new language

        // Update the app's locale
        setAppLocale(context, newLanguage)
    }

    private fun setAppLocale(context: Context, languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)

        val config = Configuration(context.resources.configuration)
        config.setLocale(locale)

        context.resources.updateConfiguration(config, context.resources.displayMetrics)

        // Restart the activity to apply the new locale
//        val intent = Intent(context, MainActivity::class.java)
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
//        context.startActivity(intent)
    }
}