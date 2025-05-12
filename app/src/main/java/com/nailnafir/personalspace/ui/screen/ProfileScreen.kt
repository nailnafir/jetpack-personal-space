package com.nailnafir.personalspace.ui.screen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.nailnafir.personalspace.data.profileContactItem
import com.nailnafir.personalspace.ui.component.dashedLine
import com.nailnafir.personalspace.ui.component.shimmerLoader
import com.nailnafir.personalspace.ui.theme.md
import com.nailnafir.personalspace.ui.theme.sm
import com.nailnafir.personalspace.ui.theme.xl
import com.nailnafir.personalspace.ui.theme.xs

@SuppressLint("ConfigurationScreenWidthHeight")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(paddingValues: PaddingValues) {
    val context = LocalContext.current
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    val scaffoldSheetState = rememberBottomSheetScaffoldState()

    BottomSheetScaffold(
        scaffoldState = scaffoldSheetState,
        sheetPeekHeight = screenHeight - paddingValues.calculateTopPadding()
                - 180.dp - 150.dp - sm,
        sheetContainerColor = MaterialTheme.colorScheme.background,
        sheetShadowElevation = sm,
        sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        bottom = paddingValues.calculateBottomPadding(),
                        start = xs * 3,
                        end = xs * 3,
                    )
                    .height(screenHeight),
                verticalArrangement = Arrangement.spacedBy(md),
            ) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(md),
                ) {
                    item {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = xs),
                            shape = MaterialTheme.shapes.large,
                            elevation = CardDefaults.cardElevation(xs / 2),
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                            ),
                        ) {
                            Column(
                                modifier = Modifier.padding(md)
                            ) {
                                Text(
                                    text = "Tentang Saya",
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.onPrimaryContainer
                                    )
                                )
                                Spacer(modifier = Modifier.height(sm))
                                Text(
                                    text = "Aku adalah seorang kapiten. Mempunyai pedang panjang. Kalau berjalan prok prok prok.",
                                    style = MaterialTheme.typography.titleSmall.copy(
                                        color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.5f),
                                    )
                                )
                            }
                        }
                    }
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                                .dashedLine(
                                    color = MaterialTheme.colorScheme.primaryContainer,
                                    strokeWidth = 3.dp,
                                )
                        )
                    }
                    item {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = xs),
                            shape = MaterialTheme.shapes.large,
                            elevation = CardDefaults.cardElevation(xs / 2),
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                            ),
                        ) {
                            Column(
                                modifier = Modifier.padding(md)
                            ) {
                                Text(
                                    text = "Kontak",
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.onPrimaryContainer
                                    )
                                )
                                Spacer(modifier = Modifier.height(sm))
                                profileContactItem.forEach {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(sm),
                                        verticalAlignment = Alignment.CenterVertically,
                                    ) {
                                        Icon(
                                            imageVector = ImageVector.vectorResource(id = it.iconResId),
                                            contentDescription = it.label,
                                            tint = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.5f),
                                        )
                                        Text(
                                            text = it.type,
                                            style = MaterialTheme.typography.titleSmall.copy(
                                                fontWeight = FontWeight.Light,
                                                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.5f),
                                            )
                                        )
                                        Spacer(modifier = Modifier.weight(1f))
                                        Text(
                                            text = it.label,
                                            style = MaterialTheme.typography.titleSmall.copy(
                                                color = MaterialTheme.colorScheme.onPrimaryContainer,
                                            )
                                        )
                                    }
                                }
                            }
                        }
                    }
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                                .dashedLine(
                                    color = MaterialTheme.colorScheme.primaryContainer,
                                    strokeWidth = 3.dp,
                                )
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(xs))
                    }
                }
            }
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary)
                .padding(bottom = paddingValues.calculateBottomPadding()),
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopCenter
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 180.dp - 50.dp)
                        .clip(RoundedCornerShape(topStart = xl, topEnd = xl))
                        .background(MaterialTheme.colorScheme.primaryContainer)
                )
                Column(
                    modifier = Modifier.padding(top = 50.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Box {
                        Image(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Profile Avatar",
                            modifier = Modifier
                                .size(180.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.background)
                        )
                        Box(
                            modifier = Modifier
                                .padding(top = 50.dp + 180.dp - (180.dp / 2))
                                .clip(MaterialTheme.shapes.large)
                                .background(MaterialTheme.colorScheme.primary)
                                .shimmerLoader()
                                .align(Alignment.BottomCenter)
                        ) {
                            Text(
                                text = "V.I.P",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onPrimary
                                ),
                                modifier = Modifier.padding(
                                    vertical = xs,
                                    horizontal = sm,
                                )
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(sm))
                    Text(
                        text = "Nailul Firdaus",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    )
                    Text(
                        text = "Tukang Ngetik",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Light,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    )
                    Spacer(modifier = Modifier.height(sm))
                    Text(
                        text = "'There is no place better than 127.0.0.1'",
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                        )
                    )
                    Spacer(modifier = Modifier.height(sm))
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = xs * 3),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onPrimary,
                        ),
                        shape = MaterialTheme.shapes.large,
                        onClick = {
                            Toast.makeText(context, "Berhasil ubah profil", Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Text(
                            text = "Ubah Profil",
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
            }
        }
    }
}