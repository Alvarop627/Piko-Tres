package com.pikotres.app.ui.presentation.views.shoppingCart

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf

// Datos del item del carrito
data class CartItem(val name: String, val price: Double, val quantity: Int)

// ViewModel para la pantalla del carrito
class ShoppingCartViewModel : ViewModel() {
    // Estado mutable para los artículos del carrito
    var cartItems = mutableStateListOf<CartItem>()
        private set

    init {
        // Inicializar con algunos artículos de ejemplo
        cartItems.addAll(
            listOf(
                CartItem(name = "Camiseta", price = 15.99, quantity = 2),
                CartItem(name = "Pantalón", price = 39.99, quantity = 1),
                CartItem(name = "Zapatos", price = 59.99, quantity = 1)
            )
        )
    }

    // Función para agregar un artículo al carrito
    fun addItem(item: CartItem) {
        cartItems.add(item)
    }

    // Función para eliminar un artículo del carrito
    fun removeItem(item: CartItem) {
        cartItems.remove(item)
    }

    // Función para finalizar la compra (checkout)
    fun checkout() {
        // Lógica para finalizar la compra
    }
}
