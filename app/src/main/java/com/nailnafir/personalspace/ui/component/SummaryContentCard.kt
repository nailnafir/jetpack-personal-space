package com.nailnafir.personalspace.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.nailnafir.personalspace.data.SummaryContentType
import com.nailnafir.personalspace.data.summaryContentDropdown
import com.nailnafir.personalspace.ui.theme.lg
import com.nailnafir.personalspace.ui.theme.md
import com.nailnafir.personalspace.ui.theme.xs
import com.nailnafir.personalspace.utility.formatDateIndonesian
import java.util.Date

@Composable
fun SummaryContentCard(
    percentage: Int? = null,
    like: Int? = null,
    type: SummaryContentType,
    title: String,
    subtitle: String,
    date: Date,
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.padding(bottom = xs),
        shape = MaterialTheme.shapes.large,
        elevation = CardDefaults.cardElevation(xs / 2),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
    ) {
        Column(
            modifier = Modifier.padding(md),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top,
            ) {
                Column {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.labelMedium
                    )
                    Box(modifier = Modifier.height(xs))
                    Text(
                        text = subtitle,
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontWeight = FontWeight.Light,
                        )
                    )
                }
                Box(
                    modifier = Modifier.padding(xs)
                ) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Lainnya",
                        modifier = Modifier
                            .size(md)
                            .clickable {
                                expanded = !expanded
                            }
                    )
                    DropdownMenu(
                        expanded = expanded,
                        shape = MaterialTheme.shapes.large,
                        shadowElevation = xs / 2,
                        onDismissRequest = { expanded = false },
                        containerColor = MaterialTheme.colorScheme.background
                    ) {
                        summaryContentDropdown.forEach {
                            DropdownMenuItem(
                                colors = MenuDefaults.itemColors(
                                    textColor = if (it.title.uppercase().contains("HAPUS")) Color.Red else Color.Unspecified,
                                    leadingIconColor = if (it.title.uppercase().contains("HAPUS")) Color.Red else Color.Unspecified
                                ),
                                leadingIcon = {
                                    Icon(
                                        imageVector = it.icon,
                                        contentDescription = "Ubah",
                                        modifier = Modifier.size(md),
                                    )
                                },
                                text = {
                                    Column {
                                        Text(
                                            text = it.title,
                                            style = MaterialTheme.typography.labelMedium.copy(
                                                fontWeight = FontWeight.SemiBold
                                            ),
                                        )
                                        Text(
                                            text = it.subtitle,
                                            style = MaterialTheme.typography.labelMedium.copy(
                                                fontWeight = FontWeight.Light
                                            ),
                                        )
                                    }
                                },
                                onClick = it.onClick
                            )
                        }
                    }
                }
            }
            Box(modifier = Modifier.height(lg))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Tanggal",
                        modifier = Modifier.size(md)
                    )
                    Box(modifier = Modifier.width(xs))
                    Text(
                        text = formatDateIndonesian(
                            date = date,
                            format = "dd MMMM yyyy",
                        ),
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight.Light,
                        )
                    )
                }
                if (type == SummaryContentType.KONTAK && like != null) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            imageVector = Icons.Default.ThumbUp,
                            contentDescription = "Suka",
                            modifier = Modifier.size(md)
                        )
                        Box(modifier = Modifier.width(xs))
                        Text(
                            text = "$like",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight.Light,
                            )
                        )
                    }
                }
                if (type != SummaryContentType.KONTAK && percentage != null) {
                    val progress = percentage / 100f
                    val progressColor = when {
                        percentage >= 80 -> Color.Green
                        percentage >= 50 -> Color.Yellow
                        else -> Color.Red
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        CircularProgressIndicator(
                            progress = { progress },
                            modifier = Modifier.size(md),
                            color = progressColor,
                            strokeWidth = xs,
                            trackColor = ProgressIndicatorDefaults.circularIndeterminateTrackColor,
                        )
                        Box(modifier = Modifier.width(xs))
                        Text(
                            text = "$percentage%",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight.Light,
                            )
                        )
                    }
                }
            }
        }
    }
}