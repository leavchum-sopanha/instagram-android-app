package com.instagramapp.mvvm_module

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.instagramapp.setAppLocale

class LanguageViewModel : ViewModel() {
    private val _currentLanguage = mutableStateOf("English")
    val currentLanguage: State<String> get() = _currentLanguage

    fun switchLanguage(context: Context) {
        val newLanguage = if (_currentLanguage.value == "English") "Khmer" else "English"
        _currentLanguage.value = newLanguage

        // Restart the activity to apply the new language
        setAppLocale(context, newLanguage)
    }
}