package com.sena.bibliotecaapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sena.bibliotecaapp.data.Reservation

@Composable
fun RenewalConfirmationScreen(
    reservation: Reservation,
    nuevaFecha: String,
    onConfirm: () -> Unit,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = "Confirmar renovación",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Estás a punto de renovar tu reserva."
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Libro:",
            style = MaterialTheme.typography.titleMedium
        )

        Text(text = reservation.book.nombre)

        Text(
            text = "Fecha anterior:",
            style = MaterialTheme.typography.titleMedium
        )

        Text(text = reservation.fechaDevolucion)

        Text(
            text = "Nueva fecha de devolución:",
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            text = nuevaFecha,
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onConfirm,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Confirmar renovación")
        }

        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver")
        }
    }
}
