package com.sena.bibliotecaapp.ui.screen

import androidx.compose.foundation.background
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    onVerLibros: () -> Unit = {},
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFF3F1FF),
                        Color.White
                    )
                )
            )
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "🏛️",
            fontSize = 110.sp
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "¡Bienvenido a tu\nBiblioteca!",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF101B45),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Descubre, aprende y reserva tus libros favoritos.",
            fontSize = 16.sp,
            color = Color(0xFF34416A),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(55.dp))

        Button(
            onClick = onVerLibros,
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF5134D5)
            )
        ) {
            Text(
                text = "📖  Ver libros",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}