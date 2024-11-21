package com.pikotres.app.ui.presentation.views.main

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

// ViewModel para MainActivity
class MainActivityViewModel : ViewModel() {
    // Estado para la pestaña seleccionada
    private val _selectedTab = mutableStateOf(2)
    val selectedTab: State<Int> = _selectedTab

    // Método para cambiar la pestaña seleccionada
    fun selectTab(index: Int) {
        _selectedTab.value = index
    }
}
