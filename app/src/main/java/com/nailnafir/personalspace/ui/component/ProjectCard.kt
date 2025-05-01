package com.nailnafir.personalspace.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.nailnafir.personalspace.ui.theme.lg
import com.nailnafir.personalspace.ui.theme.md
import com.nailnafir.personalspace.ui.theme.sm
import com.nailnafir.personalspace.ui.theme.xl
import com.nailnafir.personalspace.ui.theme.xs
import java.util.Date

@Composable
fun ProjectCard(
    percentage: Int,
    title: String,
    subtitle: String,
    date: Date,
) {
    val percentage = 88
    val progress = percentage / 100f

    val progressColor = when {
        percentage >= 80 -> Color.Green
        percentage >= 50 -> Color.Yellow
        else -> Color.Red
    }

    Box {
        Card(
            shape = CardDefaults.elevatedShape,
            elevation = CardDefaults.cardElevation(xs),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary,
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(sm)
            ) {
                Text(
                    text = "Mega Project",
                    style = MaterialTheme.typography.labelLarge
                )
                Box(modifier = Modifier.height(xs))
                Text(
                    text = "Project ini merupakan kolaborasi BUMN dan Swasta",
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontWeight = FontWeight.Light,
                    )
                )
                Box(modifier = Modifier.height(lg))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "tanggal",
                        tint = Color.White.copy(alpha = 0.5f),
                        modifier = Modifier.size(md)
                    )
                    Box(modifier = Modifier.width(xs))
                    Text(
                        text = "2025/01/28",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight.ExtraLight,
                        )
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(sm),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                progress = {
                    progress
                },
                modifier = Modifier.size(xl),
                color = progressColor,
                strokeWidth = xs / 2,
                trackColor = ProgressIndicatorDefaults.circularIndeterminateTrackColor,
            )
            Text(
                text = "$percentage%",
                style = MaterialTheme.typography.labelSmall.copy(fontSize = sm.value.sp),
                color = Color.White
            )
        }
    }
}