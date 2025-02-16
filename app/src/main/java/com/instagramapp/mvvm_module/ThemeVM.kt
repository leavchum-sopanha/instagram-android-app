package com.instagramapp.mvvm_module

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State

class ThemeViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    // Use SavedStateHandle to persist the current theme
    private val _dark = mutableStateOf(savedStateHandle.get<Boolean>("dark") ?: false)
    val dark: State<Boolean> get() = _dark

    fun toDarkMode() {
        _dark.value = true
        savedStateHandle["dark"] = true // Save the new theme state
    }

    fun toLightMode() {
        _dark.value = false
        savedStateHandle["dark"] = false // Save the new theme state
    }
}