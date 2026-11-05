
package com.sena.bibliotecaapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFF173B65)
        )

        Text(
            reservation.book.nombre,
            style = MaterialTheme.typography.titleLarge
        )

        Text("Autor: ${reservation.book.autor}")
        Text("Categoría: ${reservation.book.categoria}")
        Text("Fecha de reserva: ${reservation.fechaReserva}")
        Text("Fecha de devolución: ${reservation.fechaDevolucion}")

        Text(
            "Estado: ${reservation.estado}",
            color = Color(0xFF269B65)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Botón renovar
        Button(
            onClick = onRenew,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF269B65),
                contentColor = Color.White
            )
        ) {
            Text("Renovar reserva")
        }

        // Botón cancelar
        Button(
            onClick = onCancel,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE53935),
                contentColor = Color.White
            )
        ) {
            Text("Cancelar reserva")
        }

        // Botón volver
        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color(0xFF2457C5)
            )
        ) {
            Text("Volver")
        }
    }
}
