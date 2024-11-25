package com.pikotres.app.ui.presentation.views.shoppingCart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ShoppingCartScreen(
    viewModel: ShoppingCartViewModel = androidx.lifecycle.viewmodel.compose.viewModel() // Usamos viewModel
) {
    val cartItems = viewModel.cartItems

    // Función para manejar el checkout
    val onCheckout: () -> Unit = {
        viewModel.checkout() // Lógica de checkout
    }

    // Función para manejar la eliminación de un producto
    val onRemoveItem: (CartItem) -> Unit = { item ->
        viewModel.removeItem(item) // Elimina el artículo del carrito
    }

    // Pantalla de carrito
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Carrito de Compras", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        if (cartItems.isEmpty()) {
            Text(text = "Tu carrito está vacío.")
        } else {
            // Mostrar cada artículo del carrito
            cartItems.forEach { item ->
                CartItemRow(item, onRemoveItem)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para realizar el checkout
        Button(
            onClick = onCheckout,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Finalizar compra")
        }
    }
}

@Composable
fun CartItemRow(item: CartItem, onRemoveItem: (CartItem) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = item.name)
            Text(text = "Precio: \$${item.price}")
            Text(text = "Cantidad: ${item.quantity}")
        }

        IconButton(onClick = { onRemoveItem(item) }) {
            Icon(Icons.Default.Delete, contentDescription = "Eliminar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShoppingCartPreview() {
    ShoppingCartScreen()
}
