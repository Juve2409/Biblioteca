
package com.sena.bibliotecaapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sena.bibliotecaapp.ui.composable.PrimaryButton

@Composable
fun HomeScreen(
    onVerLibros: () -> Unit = {},
    onVerReservas: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Bienvenido a BibliotecaApp",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Tu espacio para explorar y reservar libros.",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(32.dp))

        PrimaryButton(
            texto = "Ver Catálogo",
            onClick = onVerLibros
        )

        Spacer(modifier = Modifier.height(16.dp))

        PrimaryButton(
            texto = "Mis reservas",
            onClick = onVerReservas
        )
    }
}
