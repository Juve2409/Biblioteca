package com.sena.bibliotecaapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sena.bibliotecaapp.data.Reservation
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun RenewReservationScreen(
    reservation: Reservation,
    onConfirm: (String) -> Unit,
    onBack: () -> Unit
) {
    var mostrarCalendario by remember {
        mutableStateOf(false)
    }

    var nuevaFecha by remember {
        mutableStateOf("")
    }

    val formatoFecha = SimpleDateFormat(
        "dd/MM/yyyy",
        Locale.getDefault()
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Renovar reserva",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(text = "Libro: ${reservation.book.nombre}")

        Text(text = "Fecha actual: ${reservation.fechaDevolucion}")

        OutlinedButton(
            onClick = {
                mostrarCalendario = true
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = if (nuevaFecha.isEmpty()) {
                    "Seleccionar nueva fecha"
                } else {
                    "Nueva fecha: $nuevaFecha"
                }
            )
        }

        Button(
            onClick = {
                if (nuevaFecha.isNotEmpty()) {
                    onConfirm(nuevaFecha)
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = nuevaFecha.isNotEmpty()
        ) {
            Text("Continuar")
        }

        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver")
        }
    }

    if (mostrarCalendario) {
        val datePickerState = rememberDatePickerState()

        DatePickerDialog(
            onDismissRequest = {
                mostrarCalendario = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        datePickerState.selectedDateMillis?.let {
                            nuevaFecha = formatoFecha.format(Date(it))
                        }
                        mostrarCalendario = false
                    }
                ) {
                    Text("Aceptar")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        mostrarCalendario = false
                    }
                ) {
                    Text("Cancelar")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }
}
