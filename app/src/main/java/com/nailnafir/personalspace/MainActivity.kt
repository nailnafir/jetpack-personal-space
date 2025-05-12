package com.nailnafir.personalspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.nailnafir.personalspace.ui.screen.MainScreen
import com.nailnafir.personalspace.ui.theme.PersonalSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PersonalSpaceTheme(dynamicColor = false) {
                MainScreen()
            }
        }
    }
}