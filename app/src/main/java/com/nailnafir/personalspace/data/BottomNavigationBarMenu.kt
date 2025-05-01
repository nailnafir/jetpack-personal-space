package com.nailnafir.personalspace.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationItem(
    val icon: ImageVector,
    val label: String
) {
    data object Home: BottomNavigationItem(
        icon = Icons.Default.Home,
        label = "Beranda"
    )
    data object Profile: BottomNavigationItem(
        icon = Icons.Default.Person,
        label = "Saya"
    )

    companion object {
        val Items = listOf(Home, Profile)
    }
}