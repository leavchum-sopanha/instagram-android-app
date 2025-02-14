package com.instagramapp.mvvm_module

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ThemeViewModel : ViewModel() {
    private val _dark: MutableState<Boolean> = mutableStateOf(false)
    val dark: Boolean
        get() = _dark.value

    fun toLightMode() {
        _dark.value = false
    }

    fun toDarkMode() {
        _dark.value = true
    }
}
