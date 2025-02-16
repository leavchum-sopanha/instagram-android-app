package com.instagramapp.mvvm_module

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ThemeViewModel : ViewModel() {
    var dark = mutableStateOf(false) // Start in light mode

    fun toDarkMode() {
        dark.value = true
    }

    fun toLightMode() {
        dark.value = false
    }
}