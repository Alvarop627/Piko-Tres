package com.pikotres.app.ui.presentation.views.wishlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WishlistScreen(
    viewModel: WishlistViewModel = androidx.lifecycle.viewmodel.compose.viewModel() // Usamos viewModel
) {
    val wishlistItems = viewModel.wishlistItems

    // Función para manejar la eliminación de un producto
    val onRemoveItem: (WishlistItem) -> Unit = { item ->
        viewModel.removeItem(item) // Elimina el artículo de la lista de deseos
    }

    // Pantalla de lista de deseos
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Lista de deseos", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        if (wishlistItems.isEmpty()) {
            Text(text = "Tu lista de deseos está vacía.")
        } else {
            // Mostrar cada artículo de la lista de deseos
            wishlistItems.forEach { item ->
                WishlistItemRow(item, onRemoveItem)
            }
        }
    }
}

@Composable
fun WishlistItemRow(item: WishlistItem, onRemoveItem: (WishlistItem) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = item.name)
            Text(text = "Precio: \$${item.price}")
        }

        IconButton(onClick = { onRemoveItem(item) }) {
            Icon(Icons.Default.Delete, contentDescription = "Eliminar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WishlistPreview() {
    WishlistScreen()
}
