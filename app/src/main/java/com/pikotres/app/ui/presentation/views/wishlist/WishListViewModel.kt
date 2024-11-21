package com.pikotres.app.ui.presentation.views.wishlist

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

// Datos del artículo en la lista de deseos
data class WishlistItem(val name: String, val price: Double)

class WishlistViewModel : ViewModel() {
    // Estado mutable para los artículos de la lista de deseos
    var wishlistItems = mutableStateListOf<WishlistItem>()
        private set

    init {
        // Inicializar con algunos artículos de ejemplo
        wishlistItems.addAll(
            listOf(
                WishlistItem(name = "Camiseta", price = 15.99),
                WishlistItem(name = "Chaqueta", price = 49.99)
            )
        )
    }

    // Función para agregar un artículo a la lista de deseos
    fun addItem(item: WishlistItem) {
        wishlistItems.add(item)
    }

    // Función para eliminar un artículo de la lista de deseos
    fun removeItem(item: WishlistItem) {
        wishlistItems.remove(item)
    }
}
