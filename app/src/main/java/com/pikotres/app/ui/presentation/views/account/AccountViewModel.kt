package com.pikotres.app.ui.presentation.views.account

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

// Datos del usuario en la cuenta
data class UserAccount(
    val username: String,
    val email: String
)

class AccountViewModel : ViewModel() {
    // Estado mutable para el usuario
    var userAccount by mutableStateOf<UserAccount?>(null)
        private set

    init {
        // Inicializar con datos de ejemplo (esto normalmente vendría de una API o base de datos)
        userAccount = UserAccount(username = "Juan Pérez", email = "juan@ejemplo.com")
    }

    // Función para actualizar el nombre de usuario
    fun updateUsername(newUsername: String) {
        userAccount = userAccount?.copy(username = newUsername)
    }

    // Función para actualizar el correo electrónico
    fun updateEmail(newEmail: String) {
        userAccount = userAccount?.copy(email = newEmail)
    }
}
