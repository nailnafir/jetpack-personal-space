package com.nailnafir.personalspace.ui.component

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil.compose.AsyncImage
import com.nailnafir.personalspace.data.SummaryContentType
import com.nailnafir.personalspace.ui.theme.lg
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

    val showRemoveDialog = remember { mutableStateOf(false) }
    val showDetailDialog = remember { mutableStateOf(false) }

    when {
        showRemoveDialog.value -> {
            Dialog(
                properties = DialogProperties(
                    usePlatformDefaultWidth = false
                ),
                onDismissRequest = {
                    showDetailDialog.value = false
                },
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(xs * 3),
                    shape = AlertDialogDefaults.shape,
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.background,
                    ),
                ) {
                    Column(
                        modifier = Modifier.padding(md),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.errorContainer)
                                .size(lg * 2),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Hapus",
                                modifier = Modifier.size(lg),
                                tint = MaterialTheme.colorScheme.error
                            )
                        }
                        Spacer(modifier = Modifier.height(lg))
                        Text(
                            text = "Yakin mau dihapus?",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onBackground,
                            )
                        )
                        Spacer(modifier = Modifier.height(sm))
                        Text(
                            text = "Tindakan ini akan menghapus data permanen dan tidak dapat dikembalikan",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleSmall.copy(
                                fontWeight = FontWeight.Light,
                                color = MaterialTheme.colorScheme.onBackground,
                            )
                        )
                        Spacer(modifier = Modifier.height(lg))
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.error,
                                contentColor = MaterialTheme.colorScheme.onError,
                            ),
                            shape = MaterialTheme.shapes.large,
                            onClick = {
                                Toast.makeText(context, "Berhasil", Toast.LENGTH_SHORT).show()
                                showRemoveDialog.value = false
                            }
                        ) {
                            Text(
                                text = "Hapus",
                                style = MaterialTheme.typography.labelMedium
                            )
                        }
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            border = BorderStroke(
                                color = MaterialTheme.colorScheme.error,
                                width = 1.dp
                            ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.background,
                                contentColor = MaterialTheme.colorScheme.error,
                            ),
                            shape = MaterialTheme.shapes.large,
                            onClick = {
                                showRemoveDialog.value = false
                            }
                        ) {
                            Text(
                                text = "Kembali",
                                style = MaterialTheme.typography.labelMedium
                            )
                        }
                    }
                }
            }
        }
    }

    when {
        showDetailDialog.value -> {
            Dialog(
                properties = DialogProperties(
                    usePlatformDefaultWidth = false
                ),
                onDismissRequest = {
                    showDetailDialog.value = false
                },
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(xs * 3),
                    shape = AlertDialogDefaults.shape,
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.background,
                    ),
                ) {
                    Column(
                        modifier = Modifier.padding(md),
                    ) {
                        AsyncImage(
                            model = "https://picsum.photos/120",
                            contentDescription = "Gambar",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp)
                                .clip(MaterialTheme.shapes.large)
                        )
                        Spacer(modifier = Modifier.height(sm))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
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
                        Spacer(modifier = Modifier.height(lg))
                        Text(
                            text = title,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.titleMedium.copy(
                                color = MaterialTheme.colorScheme.onBackground,
                            )
                        )
                        Spacer(modifier = Modifier.height(sm))
                        Text(
                            text = subtitle,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.titleSmall.copy(
                                color = MaterialTheme.colorScheme.onBackground.copy(
                                    alpha = 0.5f
                                ),
                            )
                        )
                        Spacer(modifier = Modifier.height(lg))
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                contentColor = MaterialTheme.colorScheme.onPrimary,
                            ),
                            shape = MaterialTheme.shapes.large,
                            onClick = {
                                Toast.makeText(context, "Berhasil", Toast.LENGTH_SHORT).show()
                                showDetailDialog.value = false
                            }
                        ) {
                            Text(
                                text = "Ubah",
                                style = MaterialTheme.typography.labelMedium
                            )
                        }
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            border = BorderStroke(
                                color = MaterialTheme.colorScheme.primary,
                                width = 1.dp
                            ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.background,
                                contentColor = MaterialTheme.colorScheme.primary,
                            ),
                            shape = MaterialTheme.shapes.large,
                            onClick = {
                                showDetailDialog.value = false
                            }
                        ) {
                            Text(
                                text = "Kembali",
                                style = MaterialTheme.typography.labelMedium
                            )
                        }
                    }
                }
            }
        }
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                showDetailDialog.value = true
            },
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
                    .align(Alignment.TopEnd)
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
                    Spacer(modifier = Modifier.height(sm))
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
                }
                Box(
                    modifier = Modifier
                        .size(lg)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.error)
                        .clickable {
                            showRemoveDialog.value = true
                        },
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Hapus",
                        tint = MaterialTheme.colorScheme.onError,
                        modifier = Modifier.size(md)
                    )
                }
            }
        }
    }
}