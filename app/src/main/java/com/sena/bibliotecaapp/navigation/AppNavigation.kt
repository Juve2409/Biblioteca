
package com.sena.bibliotecaapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sena.bibliotecaapp.R
import com.sena.bibliotecaapp.data.Book
import com.sena.bibliotecaapp.data.Reservation
import com.sena.bibliotecaapp.ui.screen.BooksScreen
import com.sena.bibliotecaapp.ui.screen.ConfirmationScreen
import com.sena.bibliotecaapp.ui.screen.DetailScreen
import com.sena.bibliotecaapp.ui.screen.HomeScreen
import com.sena.bibliotecaapp.ui.screen.ReservationsScreen
import com.sena.bibliotecaapp.ui.screen.ReservationDetailScreen
import com.sena.bibliotecaapp.ui.screen.RenewReservationScreen
import com.sena.bibliotecaapp.ui.screen.RenewalConfirmationScreen
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    // Lista de libros
    val libros = remember {
        listOf(
            Book(
                id = 1,
                nombre = "The Abandoned Clunker",
                autor = "Theodore Ash",
                categoria = "Pelicula",
                description = "Historia de terror y suspenso.",
                portada = R.drawable.img
            ),
            Book(
                id = 2,
                nombre = "Los Hombres del Norte",
                autor = "John Haywood",
                categoria = "Investigación",
                description = "Historia de Vikingos alejandose de mitos y leyendas.",
                portada = R.drawable.img_1
            ),
            Book(
                id = 3,
                nombre = "Harry Potter y la piedra filosofal",
                autor = "J.K. Rowling",
                categoria = "Fantasía",
                description = "Aventura en un mundo lleno de personajes fantásticos.",
                portada = R.drawable.img_2
            ),
            Book(
                id = 4,
                nombre = "Diseñadas a su imagen",
                autor = "Miguel Nuñez",
                categoria = "Religión",
                description = "Relatos sobre la identidad femenina desde la perspectiva biblica.",
                portada = R.drawable.img_3
            )
        )
    }

    val libroSeleccionado = remember {
        mutableStateOf<Book?>(null)
    }

    // Reservas iniciales
    val reservas = remember {
        mutableStateOf(
            listOf(
                Reservation(
                    id = 1,
                    book = libros[0],
                    fechaReserva = "01/11/2026",
                    fechaDevolucion = "10/11/2026"
                ),
                Reservation(
                    id = 2,
                    book = libros[2],
                    fechaReserva = "02/11/2026",
                    fechaDevolucion = "12/11/2026"
                )
            )
        )
    }

    val reservaSeleccionada = remember {
        mutableStateOf<Reservation?>(null)
    }

    val nuevaFechaReserva = remember {
        mutableStateOf("")
    }

    NavHost(
        navController = navController,
        startDestination = "inicio"
    ) {

        // INICIO
        composable("inicio") {
            HomeScreen(
                onVerLibros = {
                    navController.navigate("libros")
                },
                onVerReservas = {
                    navController.navigate("reservas")
                }
            )
        }

        // CATÁLOGO DE LIBROS
        composable("libros") {
            BooksScreen(
                libros = libros,
                onVerDetalle = { book ->
                    libroSeleccionado.value = book
                    navController.navigate("detalle")
                }
            )
        }

        // DETALLE DEL LIBRO
        composable("detalle") {
            val book = libroSeleccionado.value

            if (book != null) {
                DetailScreen(
                    book = book,
                    imageResId = book.portada,
                    onReservar = {
                        navController.navigate("confirmacion")
                    }
                )
            }
        }

        // CONFIRMACIÓN Y CREACIÓN DE RESERVA
        composable("confirmacion") {
            val book = libroSeleccionado.value

            if (book != null) {
                ConfirmationScreen(
                    book = book,
                    onVolverInicio = {

                        // Formato de fecha
                        val formatoFecha = SimpleDateFormat(
                            "dd/MM/yyyy",
                            Locale.getDefault()
                        )

                        // Fecha actual
                        val fechaActual = formatoFecha.format(Date())

                        // Fecha de devolución: 7 días después
                        val calendario = Calendar.getInstance()
                        calendario.add(Calendar.DAY_OF_YEAR, 7)

                        val fechaDevolucion = formatoFecha.format(
                            calendario.time
                        )

                        // Crear nueva reserva
                        val nuevaReserva = Reservation(
                            id = (reservas.value.maxOfOrNull { it.id } ?: 0) + 1,
                            book = book,
                            fechaReserva = fechaActual,
                            fechaDevolucion = fechaDevolucion
                        )

                        // Agregar reserva al listado
                        reservas.value = reservas.value + nuevaReserva

                        // Limpiar libro seleccionado
                        libroSeleccionado.value = null

                        // Regresar al inicio
                        navController.popBackStack(
                            "inicio",
                            inclusive = false
                        )
                    }
                )
            }
        }

        // MIS RESERVAS
        composable("reservas") {
            ReservationsScreen(
                reservations = reservas.value,
                onSelectReservation = { reservation ->
                    reservaSeleccionada.value = reservation
                    navController.navigate("detalleReserva")
                }
            )
        }

        // DETALLE DE LA RESERVA
        composable("detalleReserva") {
            val reservation = reservaSeleccionada.value

            if (reservation != null) {
                ReservationDetailScreen(
                    reservation = reservation,
                    onRenew = {
                        nuevaFechaReserva.value = ""
                        navController.navigate("renovarReserva")
                    },
                    onCancel = {

                        // Cancelar reserva
                        reservas.value = reservas.value.filter {
                            it.id != reservation.id
                        }

                        reservaSeleccionada.value = null

                        navController.popBackStack(
                            "reservas",
                            inclusive = false
                        )
                    },
                    onBack = {
                        navController.popBackStack()
                    }
                )
            }
        }

        // RENOVAR RESERVA
        composable("renovarReserva") {
            val reservation = reservaSeleccionada.value

            if (reservation != null) {
                RenewReservationScreen(
                    reservation = reservation,
                    onConfirm = { fecha ->
                        nuevaFechaReserva.value = fecha
                        navController.navigate("confirmacionRenovacion")
                    },
                    onBack = {
                        navController.popBackStack()
                    }
                )
            }
        }

        // CONFIRMACIÓN DE RENOVACIÓN
        composable("confirmacionRenovacion") {
            val reservation = reservaSeleccionada.value

            if (reservation != null) {
                RenewalConfirmationScreen(
                    reservation = reservation,
                    nuevaFecha = nuevaFechaReserva.value,
                    onConfirm = {

                        // Actualizar fecha de devolución
                        val reservaActualizada = reservation.copy(
                            fechaDevolucion = nuevaFechaReserva.value
                        )

                        reservas.value = reservas.value.map { reserva ->
                            if (reserva.id == reservation.id) {
                                reservaActualizada
                            } else {
                                reserva
                            }
                        }

                        // Limpiar selección
                        reservaSeleccionada.value = null

                        // Regresar a Mis reservas
                        navController.popBackStack(
                            "reservas",
                            inclusive = false
                        )
                    },
                    onBack = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
