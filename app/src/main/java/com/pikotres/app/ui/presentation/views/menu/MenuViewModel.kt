package com.pikotres.app.ui.presentation.views.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MenuViewModel : ViewModel() {
    private val _menuItems = MutableStateFlow<List<String>>(emptyList())
    val menuItems: StateFlow<List<String>> get() = _menuItems

    init {
        loadMenuItems()
    }

    private fun loadMenuItems() {
        viewModelScope.launch {
            // Simula la carga de datos (podría ser desde un repositorio o servicio)
            _menuItems.value = listOf("Item 1", "Item 2", "Item 3", "Item 4")
        }
    }
}

