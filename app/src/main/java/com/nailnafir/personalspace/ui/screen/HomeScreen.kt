package com.nailnafir.personalspace.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.items as columnItems
import androidx.compose.foundation.lazy.grid.items as gridItems
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.nailnafir.personalspace.data.SummaryContentType
import com.nailnafir.personalspace.data.overviewMenu
import com.nailnafir.personalspace.data.summaryContent
import com.nailnafir.personalspace.data.summaryFilter
import com.nailnafir.personalspace.ui.component.OverviewCard
import com.nailnafir.personalspace.ui.component.OverviewChartCard
import com.nailnafir.personalspace.ui.component.SearchBar
import com.nailnafir.personalspace.ui.component.SummaryContentCard
import com.nailnafir.personalspace.ui.component.SummaryFilterChip
import com.nailnafir.personalspace.ui.component.TopNavigationBar
import com.nailnafir.personalspace.ui.theme.lg
import com.nailnafir.personalspace.ui.theme.md
import com.nailnafir.personalspace.ui.theme.sm
import com.nailnafir.personalspace.ui.theme.xs

@SuppressLint("ConfigurationScreenWidthHeight")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(paddingValues: PaddingValues) {
    val scaffoldSheetState = rememberBottomSheetScaffoldState()

    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    var selectedIndex by remember { mutableIntStateOf(0) }
    var searchQuery by remember { mutableStateOf("") }

    val categoryFilteredContent = when (summaryFilter[selectedIndex].label) {
        "Tugas" -> summaryContent.filter { it.type == SummaryContentType.TASK }
        "Pekerjaan" -> summaryContent.filter { it.type == SummaryContentType.WORK }
        "Pesan" -> summaryContent.filter { it.type == SummaryContentType.MESSAGE }
        "Blog" -> summaryContent.filter { it.type == SummaryContentType.BLOG }
        else -> summaryContent
    }

    val filteredContent = if (searchQuery.isBlank()) {
        categoryFilteredContent
    } else {
        categoryFilteredContent.filter {
            it.title.contains(
                searchQuery,
                ignoreCase = true
            ) || it.subtitle.contains(
                searchQuery,
                ignoreCase = true
            )
        }
    }

    BottomSheetScaffold(
        scaffoldState = scaffoldSheetState,
        sheetPeekHeight = screenHeight - paddingValues.calculateTopPadding() - TopAppBarDefaults.TopAppBarExpandedHeight
                - 200.dp - 120.dp - (sm * 10),
        sheetContainerColor = MaterialTheme.colorScheme.background,
        sheetShadowElevation = sm,
        sheetContent = {
            Column(
                modifier = Modifier
                    .padding(
                        bottom = paddingValues.calculateBottomPadding(),
                        start = xs * 3,
                        end = xs * 3,
                    ),
                verticalArrangement = Arrangement.Top,
            ) {
                SearchBar(
                    searchQuery = searchQuery,
                    onValueChange = { searchQuery = it },
                )
                Spacer(modifier = Modifier.height(sm))
                LazyRow(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(sm),
                ) {
                    itemsIndexed(summaryFilter) { index, item ->
                        SummaryFilterChip(
                            label = item.label,
                            count = item.count,
                            selected = selectedIndex == index,
                            onClick = { selectedIndex = index },
                        )
                    }
                }
                Spacer(modifier = Modifier.height(lg))
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(md),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    columnItems(filteredContent) {
                        SummaryContentCard(
                            percentageCount = it.percentageCount,
                            likeCount = it.likeCount,
                            readCount = it.readCount,
                            type = it.type,
                            title = it.title,
                            subtitle = it.subtitle,
                            date = it.date,
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(xs))
                    }
                }
            }
        },
        topBar = {
            TopNavigationBar()
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
                .padding(
                    bottom = paddingValues.calculateBottomPadding(),
                    top = xs * 3,
                    start = xs * 3,
                    end = xs * 3,
                ),
        ) {
            OverviewChartCard()
            Spacer(modifier = Modifier.height(xs * 3))
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(md),
                horizontalArrangement = Arrangement.spacedBy(md),
            ) {
                gridItems(overviewMenu) {
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