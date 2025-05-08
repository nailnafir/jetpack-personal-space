package com.nailnafir.personalspace.ui.component

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.nailnafir.personalspace.data.SummaryContentType
import com.nailnafir.personalspace.data.summaryContentDropdown
import com.nailnafir.personalspace.ui.theme.md
import com.nailnafir.personalspace.ui.theme.sm
import com.nailnafir.personalspace.ui.theme.xs
import com.nailnafir.personalspace.utility.formatDateIndonesian
import com.nailnafir.personalspace.utility.isMoreThan7DaysFromNow
import java.util.Date

@Composable
fun SummaryContentCard(
    percentageCount: Int? = null,
    likeCount: Int? = null,
    readCount: Int? = null,
    type: SummaryContentType,
    title: String,
    subtitle: String,
    date: Date,
) {
    val context = LocalContext.current

    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        shape = MaterialTheme.shapes.large,
        elevation = CardDefaults.cardElevation(xs / 2),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        ),
    ) {
        Box {
            if (!date.isMoreThan7DaysFromNow()) Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.error)
                    .shimmerLoader()
                    .padding(
                        vertical = xs,
                        horizontal = sm,
                    )
            ) {
                Text(
                    text = "BARU",
                    color = MaterialTheme.colorScheme.onError,
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(md),
                verticalAlignment = Alignment.Top,
            ) {
                AsyncImage(
                    model = "https://picsum.photos/120",
                    contentDescription = "Gambar",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(100.dp)
                        .clip(MaterialTheme.shapes.large)
                )
                Spacer(modifier = Modifier.width(sm))
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = title,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                        )
                    )
                    Spacer(modifier = Modifier.height(xs))
                    Text(
                        text = subtitle,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleSmall.copy(
                            color = MaterialTheme.colorScheme.onPrimaryContainer.copy(
                                alpha = 0.5f
                            ),
                        )
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = "Tanggal",
                            modifier = Modifier.size(md),
                            tint = MaterialTheme.colorScheme.onPrimaryContainer,
                        )
                        Spacer(modifier = Modifier.width(xs))
                        Text(
                            text = formatDateIndonesian(
                                date = date,
                                format = "dd MMMM yyyy",
                            ),
                            style = MaterialTheme.typography.titleSmall.copy(
                                fontWeight = FontWeight.Light,
                                color = MaterialTheme.colorScheme.onPrimaryContainer,
                            )
                        )
                    }
                }
                Spacer(modifier = Modifier.width(sm))
                Column (
                    horizontalAlignment = Alignment.End
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
                                    textColor = if (it.title.uppercase().contains("HAPUS"))
                                        MaterialTheme.colorScheme.error
                                    else MaterialTheme.colorScheme.onBackground,
                                    leadingIconColor = if (it.title.uppercase().contains("HAPUS"))
                                        MaterialTheme.colorScheme.error
                                    else MaterialTheme.colorScheme.onBackground,
                                ),
                                leadingIcon = {
                                    Icon(
                                        imageVector = it.icon,
                                        contentDescription = it.title,
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
                                onClick = {
                                    Toast.makeText(context, "${it.title} $title", Toast.LENGTH_SHORT).show()
                                }
                            )
                        }
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (type == SummaryContentType.BLOG && readCount != null) {
                            Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = "Baca",
                                modifier = Modifier.size(md),
                                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                            )
                            Spacer(modifier = Modifier.width(xs))
                            Text(
                                text = "$readCount",
                                style = MaterialTheme.typography.titleSmall.copy(
                                    fontWeight = FontWeight.Light,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                )
                            )
                        }
                        if (type == SummaryContentType.MESSAGE && likeCount != null) {
                            Icon(
                                imageVector = Icons.Default.ThumbUp,
                                contentDescription = "Suka",
                                modifier = Modifier.size(md),
                                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                            )
                            Spacer(modifier = Modifier.width(xs))
                            Text(
                                text = "$likeCount",
                                style = MaterialTheme.typography.titleSmall.copy(
                                    fontWeight = FontWeight.Light,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                )
                            )
                        }
                        if (type != SummaryContentType.MESSAGE && percentageCount != null) {
                            val progress = percentageCount / 100f
                            val progressColor = when {
                                percentageCount >= 80 -> Color.Green
                                percentageCount >= 50 -> Color.Yellow
                                else -> Color.Red
                            }
                            CircularProgressIndicator(
                                progress = { progress },
                                modifier = Modifier.size(md),
                                color = progressColor,
                                strokeWidth = xs,
                                trackColor = ProgressIndicatorDefaults.circularIndeterminateTrackColor,
                            )
                            Spacer(modifier = Modifier.width(xs))
                            Text(
                                text = "$percentageCount%",
                                style = MaterialTheme.typography.titleSmall.copy(
                                    fontWeight = FontWeight.Light,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}