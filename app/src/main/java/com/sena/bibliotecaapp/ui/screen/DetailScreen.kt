package com.sena.bibliotecaapp.ui.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sena.bibliotecaapp.data.Book
import com.sena.bibliotecaapp.ui.composable.PrimaryButton

@Composable
fun DetailScreen(
    book: Book,
    imageResId: Int,
    onReservar: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Detalle del libro",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        Image(
            painter = painterResource(id = imageResId),
            contentDescription = book.nombre,
            modifier = Modifier.size(width = 180.dp, height = 240.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = book.nombre,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(text = "Autor: ${book.autor}")
        Text(text = "Categoría: ${book.categoria}")

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = book.description,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(28.dp))

        PrimaryButton(
            texto = "Reservar libro",
            onClick = onReservar
        )
    }
}
