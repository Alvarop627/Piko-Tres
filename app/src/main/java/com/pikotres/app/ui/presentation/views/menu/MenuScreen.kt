package com.pikotres.app.ui.presentation.views.menu

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MenuScreen(viewModel: MenuViewModel = viewModel()) {
    // Observar los datos del ViewModel con collectAsState
    val menuItems by viewModel.menuItems.collectAsState(initial = emptyList())

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Menú Principal",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Mostrar una lista de elementos del menú
        menuItems.forEach { item ->
            MenuItemView(item)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun MenuItemView(item: String) {
    Text(
        text = item,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.fillMaxWidth().padding(8.dp)
    )
}
