package com.sena.bibliotecaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sena.bibliotecaapp.navigation.AppNavigation
import com.sena.bibliotecaapp.ui.theme.BibliotecaAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BibliotecaAppTheme {
                AppNavigation()
            }
        }
    }
}
