
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
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFF173B65)
        )

        Text("Estás a punto de renovar tu reserva.")

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            "Libro:",
            style = MaterialTheme.typography.titleMedium
        )
        Text(reservation.book.nombre)

        Text(
            "Fecha anterior:",
            style = MaterialTheme.typography.titleMedium
        )
        Text(reservation.fechaDevolucion)

        Text(
            "Nueva fecha de devolución:",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            nuevaFecha,
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFF269B65)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Confirmar renovación
        Button(
            onClick = onConfirm,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF269B65),
                contentColor = Color.White
            )
        ) {
            Text("Confirmar renovación")
        }

        // Volver
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
