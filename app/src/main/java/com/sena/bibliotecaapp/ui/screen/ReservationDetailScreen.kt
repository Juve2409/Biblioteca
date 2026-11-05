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
fun ReservationDetailScreen(
    reservation: Reservation,
    onRenew: () -> Unit,
    onCancel: () -> Unit,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Detalle de la reserva",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = reservation.book.nombre,
            style = MaterialTheme.typography.titleLarge
        )

        Text(text = "Autor: ${reservation.book.autor}")

        Text(text = "Categoría: ${reservation.book.categoria}")

        Text(text = "Fecha de reserva: ${reservation.fechaReserva}")

        Text(text = "Fecha de devolución: ${reservation.fechaDevolucion}")

        Text(text = "Estado: ${reservation.estado}")

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = onRenew,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Renovar reserva")
        }

        OutlinedButton(
            onClick = onCancel,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cancelar reserva")
        }

        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver")
        }
    }
}
