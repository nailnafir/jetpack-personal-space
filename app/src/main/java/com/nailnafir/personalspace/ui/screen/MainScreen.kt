package com.nailnafir.personalspace.ui.screen

import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.nailnafir.personalspace.data.BottomNavigationItem
import kotlinx.coroutines.launch
import com.nailnafir.personalspace.ui.component.BottomNavigationBar

@Composable
fun MainScreen() {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { BottomNavigationItem.Items.size })
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                selectedIndex = pagerState.currentPage,
                onItemSelected = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(it)
                    }
                }
            )
        },
    ) {
        HorizontalPager(
            state = pagerState,
        ) { page ->
            when (page) {
                0 -> HomeScreen(it)
                1 -> ProfileScreen()
            }
        }
    }
}