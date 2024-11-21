package com.pikotres.app.ui.presentation.views.account

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun AccountScreen(
    viewModel: AccountViewModel = androidx.lifecycle.viewmodel.compose.viewModel() // Usamos el ViewModel
) {
    val userAccount = viewModel.userAccount

    if (userAccount == null) {
        // Si no hay información de cuenta disponible
        Text(text = "Cargando...", modifier = Modifier.padding(16.dp))
    } else {
        // Pantalla de cuenta con nombre y correo electrónico
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Cuenta de usuario", style = MaterialTheme.typography.titleLarge)

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Nombre de usuario:")
            var username by remember { mutableStateOf(TextFieldValue(userAccount.username)) }
            BasicTextField(
                value = username,
                onValueChange = { username = it },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Correo electrónico:")
            var email by remember { mutableStateOf(TextFieldValue(userAccount.email)) }
            BasicTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                // Guardar los cambios (en este caso, actualizamos el ViewModel)
                viewModel.updateUsername(username.text)
                viewModel.updateEmail(email.text)
            }) {
                Text(text = "Guardar cambios")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AccountPreview() {
    AccountScreen()
}