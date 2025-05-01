package com.nailnafir.personalspace.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.nailnafir.personalspace.data.overviewMenu
import com.nailnafir.personalspace.ui.component.OverviewCard
import com.nailnafir.personalspace.ui.component.OverviewChartCard
import com.nailnafir.personalspace.ui.component.SearchBar
import com.nailnafir.personalspace.ui.theme.md
import com.nailnafir.personalspace.ui.theme.sm
import com.nailnafir.personalspace.ui.theme.xs

@SuppressLint("ConfigurationScreenWidthHeight")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val scaffoldSheetState = rememberBottomSheetScaffoldState()

    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val sheetPeekHeight = screenHeight / 3

    BottomSheetScaffold(
        scaffoldState = scaffoldSheetState,
        sheetPeekHeight = sheetPeekHeight,
        sheetContainerColor = MaterialTheme.colorScheme.background,
        sheetShadowElevation = sm,
        sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(screenHeight - (sm * 6)),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SearchBar()
            }
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    MaterialTheme.colorScheme.background
                        .copy(alpha = 0.85f)
                        .compositeOver(MaterialTheme.colorScheme.primary),
                )
                .padding(xs * 3),
        ) {
            OverviewChartCard()
            Spacer(modifier = Modifier.height(xs * 3))
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(md),
                horizontalArrangement = Arrangement.spacedBy(md),
            ) {
                items(overviewMenu) {
                    OverviewCard(
                        title = it.title,
                        count = it.count,
                        icon = ImageVector.vectorResource(id = it.iconResId)
                    )
                }
            }
        }
    }
}