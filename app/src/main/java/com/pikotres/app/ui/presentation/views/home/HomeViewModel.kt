package com.pikotres.app.ui.presentation.views.home

import androidx.lifecycle.ViewModel
import com.pikotres.app.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {
    // Listas de productos para los carruseles
    private val _productsCarousel1 = MutableStateFlow(listOf("Producto 1", "Producto 2", "Producto 3"))
    val productsCarousel1: StateFlow<List<String>> = _productsCarousel1

    private val _productsCarousel2 = MutableStateFlow(listOf("Producto A", "Producto B", "Producto C"))
    val productsCarousel2: StateFlow<List<String>> = _productsCarousel2

    // ID de la imagen de banner
    private val _bannerImage = MutableStateFlow(R.drawable.banner_image) // Usa una imagen de recursos locales
    val bannerImage: StateFlow<Int> = _bannerImage
}
