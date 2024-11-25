package com.pikotres.app.ui.presentation.views.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pikotres.app.ui.theme.PikoTresTheme

// HomeScreen composable
@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel()) {
    val productsCarousel1 = viewModel.productsCarousel1.collectAsState().value
    val productsCarousel2 = viewModel.productsCarousel2.collectAsState().value
    val bannerImage = viewModel.bannerImage.collectAsState().value

    Column(modifier = Modifier.fillMaxSize()) {
        // Primer carrusel de productos
        ProductCarousel(products = productsCarousel1)

        Spacer(modifier = Modifier.height(16.dp))

        // Imagen de banner
        BannerImage(image = bannerImage)

        Spacer(modifier = Modifier.height(16.dp))

        // Segundo carrusel de productos
        ProductCarousel(products = productsCarousel2)
    }
}

// Carrusel de productos
@Composable
fun ProductCarousel(products: List<String>) {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(products.size) { index ->
            ProductCard(productName = products[index])
        }
    }
}

// Tarjeta de producto
@Composable
fun ProductCard(productName: String) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = productName, modifier = Modifier.padding(16.dp))
        }
    }
}

// Imagen de banner
@Composable
fun BannerImage(image: Int) {
    Image(
        painter = painterResource(id = image),
        contentDescription = "Banner de productos",
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    PikoTresTheme {
        // Usamos viewModel() para obtener el ViewModel
        HomeScreen(viewModel = viewModel())
    }
}
