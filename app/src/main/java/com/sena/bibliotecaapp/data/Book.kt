package com.sena.bibliotecaapp.data

import androidx.annotation.DrawableRes

data class Book(
    val id: Int,
    val nombre: String,
    val autor: String,
    val categoria: String,
    val description: String,
    @DrawableRes val portada: Int
)