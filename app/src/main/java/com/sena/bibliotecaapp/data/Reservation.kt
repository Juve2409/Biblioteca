package com.sena.bibliotecaapp.data

data class Reservation(
    val id: Int,
    val book: Book,
    val fechaReserva: String,
    val fechaDevolucion: String,
    val estado: String = "Activa"
)
