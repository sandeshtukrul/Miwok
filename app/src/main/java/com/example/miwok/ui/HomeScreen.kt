package com.example.miwok.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.miwok.R.string.label_miwok
import com.example.miwok.R.string.tab_colors
import com.example.miwok.R.string.tab_family
import com.example.miwok.R.string.tab_numbers
import com.example.miwok.R.string.tab_phrases
import kotlinx.coroutines.launch

@Composable
fun HomeScreen() {

    Scaffold(topBar = { TopAppBar() }) { paddingValues ->
        TabRowAndHorizontalPager(paddingValues)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar() {
    CenterAlignedTopAppBar(
        title = { Text(stringResource(label_miwok), fontWeight = FontWeight.Bold) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorScheme.primary,
            titleContentColor = colorScheme.onPrimary
        )
    )
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun TabRowAndHorizontalPager(paddingValues: PaddingValues) {
    val tabs = listOf(
        stringResource(tab_numbers),
        stringResource(tab_family),
        stringResource(tab_colors),
        stringResource(tab_phrases)
    )

    val pagerState = rememberPagerState { tabs.size }

    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
        // TabRow
        PrimaryTabRow(
            contentColor = colorScheme.onPrimaryContainer,
            containerColor = colorScheme.primaryContainer,
            selectedTabIndex = pagerState.currentPage
        ) {
            tabs.forEachIndexed { index, title ->

                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(
                            text = title,
                            fontWeight = if (pagerState.currentPage == index) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { pageIndex ->
            when (pageIndex) {
                0 -> {
                    NumberScreen()
                }

                1 -> {
                    FamilyScreen()
                }

                2 -> {
                    ColorsScreen()
                }

                3 -> {
                    PhrasesScreen()
                }
            }
        }


    }
}






