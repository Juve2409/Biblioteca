package com.sena.bibliotecaapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sena.bibliotecaapp.R
import com.sena.bibliotecaapp.data.Book
import com.sena.bibliotecaapp.ui.screen.ConfirmationScreen
import com.sena.bibliotecaapp.ui.screen.BooksScreen
import com.sena.bibliotecaapp.ui.screen.DetailScreen
import com.sena.bibliotecaapp.ui.screen.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

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
                description = "Relatos sobre la identidad femenina desde la perspectiva biblica",
                portada = R.drawable.img_3
            )
        )
    }

    val libroSeleccionado = remember {
        mutableStateOf<Book?>(null)
    }

    NavHost(
        navController = navController,
        startDestination = "inicio"
    ) {
        composable("inicio") {
            HomeScreen(
                onVerLibros = {
                    navController.navigate("libros")
                }
            )
        }

        composable("libros") {
            BooksScreen(
                libros = libros,
                onVerDetalle = { book ->
                    libroSeleccionado.value = book
                    navController.navigate("detalle")
                }
            )
        }

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

        composable("confirmacion") {
            val book = libroSeleccionado.value
            if (book != null) {
                ConfirmationScreen(
                    book = book,
                    onVolverInicio = {
                        libroSeleccionado.value = null
                        navController.popBackStack("inicio", inclusive = false)
                    }
                )
            }
        }
    }
}
