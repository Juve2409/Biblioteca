package com.sena.bibliotecaapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sena.bibliotecaapp.data.Reservation

@Composable
fun ReservationsScreen(
    reservations: List<Reservation>,
    onSelectReservation: (Reservation) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Mis reservas",
            style = MaterialTheme.typography.headlineMedium
        )

        if (reservations.isEmpty()) {
            Text(text = "No tienes reservas activas.")
        } else {
            reservations.forEach { reservation ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = reservation.book.nombre,
                            style = MaterialTheme.typography.titleMedium
                        )

                        Text(text = "Autor: ${reservation.book.autor}")
                        Text(text = "Fecha de reserva: ${reservation.fechaReserva}")
                        Text(text = "Fecha de devolución: ${reservation.fechaDevolucion}")
                        Text(text = "Estado: ${reservation.estado}")

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Button(
                                onClick = {
                                    onSelectReservation(reservation)
                                }
                            ) {
                                Text("Ver detalle")
                            }
                        }
                    }
                }
            }
        }
    }
}
