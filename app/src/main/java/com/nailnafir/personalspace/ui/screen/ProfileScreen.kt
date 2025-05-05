package com.nailnafir.personalspace.ui.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.nailnafir.personalspace.ui.theme.sm
import com.nailnafir.personalspace.ui.theme.xl
import com.nailnafir.personalspace.ui.theme.xs

@Composable
fun ProfileScreen(paddingValues: PaddingValues) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = paddingValues.calculateTopPadding(),
                bottom = paddingValues.calculateBottomPadding(),
            )
            .background(MaterialTheme.colorScheme.background),
    ) {
        Box(
            modifier = Modifier
                .height(350.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            Box(
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .clip(RoundedCornerShape(topStart = xl, topEnd = xl))
                    .background(MaterialTheme.colorScheme.primary)
            )
            Column(
                modifier = Modifier.padding(top = 50.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Profile Avatar",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                )
                Box(modifier = Modifier.height(sm))
                Text(
                    text = "Nailul Firdaus",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
                Text(
                    text = "Tukang Ngetik",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Light,
                        color = Color.White
                    )
                )
                Box(modifier = Modifier.height(sm))
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    ),
                    elevation = ButtonDefaults.buttonElevation(xs / 2),
                    shape = MaterialTheme.shapes.large,
                    onClick = {
                        Toast.makeText(context, "Ubah profil disini", Toast.LENGTH_SHORT).show()
                    }
                ) {
                    Text(
                        text = "Ubah Profil",
                        style = MaterialTheme.typography.labelMedium.copy(
                            color = Color.Black
                        )
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(top = 300.dp)
                    .clip(RoundedCornerShape(topStart = xl, topEnd = xl))
                    .background(MaterialTheme.colorScheme.background)
            ) {
                Text(
                    text = "Ubah Profil",
                    style = MaterialTheme.typography.labelMedium.copy(
                        color = Color.Black
                    )
                )
            }
        }
    }
}