package com.pikotres.app.ui.presentation.views.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pikotres.app.ui.presentation.views.account.AccountScreen
import com.pikotres.app.ui.presentation.views.home.HomeScreen
import com.pikotres.app.ui.presentation.views.menu.MenuScreen
import com.pikotres.app.ui.presentation.views.shoppingCart.ShoppingCartScreen
import com.pikotres.app.ui.presentation.views.wishlist.WishlistScreen
import com.pikotres.app.ui.theme.PikoTresTheme

// MainActivity que maneja la UI
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PikoTresTheme {
                // Aquí usas `viewModel()` para obtener la instancia del ViewModel
                val viewModel: MainActivityViewModel = viewModel()
                val selectedTab = viewModel.selectedTab.value

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        NavigationBar(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            BottomNavigationBar(
                                selectedTab = selectedTab,
                                onTabSelected = { index -> viewModel.selectTab(index) }
                            )
                        }
                    }
                ) { innerPadding ->  // innerPadding aquí
                    // Contenido según la pestaña seleccionada
                    Box(modifier = Modifier.padding(innerPadding)) { // Usamos innerPadding aquí
                        when (selectedTab) {
                            0 -> MenuScreen()
                            1 -> WishlistScreen()
                            2 -> HomeScreen()  // Tienda seleccionada por defecto
                            3 -> AccountScreen()
                            4 -> ShoppingCartScreen()
                        }
                    }
                }
            }
        }
    }
}

// Barra de navegación en la parte inferior con la nueva API de Material3
@Composable
fun BottomNavigationBar(selectedTab: Int, onTabSelected: (Int) -> Unit) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth()
    ) {
        val items = listOf(
            NavigationItem("Menú", Icons.Default.Menu),
            NavigationItem("Lista de deseos", Icons.Default.Favorite),
            NavigationItem("Tienda", Icons.Default.CheckCircle),
            NavigationItem("Cuenta", Icons.Default.Person),
            NavigationItem("Carrito", Icons.Default.ShoppingCart)
        )

        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.name) },
                label = { Text(item.name) },
                selected = selectedTab == index,
                onClick = { onTabSelected(index) }
            )
        }
    }
}

data class NavigationItem(val name: String, val icon: ImageVector)

// Preview para ver la interfaz
@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    // Simulamos un estado del ViewModel para la preview
    val selectedTab = remember { mutableStateOf(2) } // Tienda seleccionada por defecto

    PikoTresTheme {
        Scaffold(
            bottomBar = {
                BottomNavigationBar(
                    selectedTab = selectedTab.value,
                    onTabSelected = { index -> selectedTab.value = index }
                )
            }
        ) { innerPadding -> // Aplicamos innerPadding aquí también
            Box(modifier = Modifier.padding(innerPadding)) {
                // Pantallas simuladas para cada pestaña
                when (selectedTab.value) {
                    0 -> MenuScreen()
                    1 -> WishlistScreen()
                    2 -> HomeScreen()
                    3 -> AccountScreen()
                    4 -> ShoppingCartScreen()
                    else -> Text("Pestaña desconocida", modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}
