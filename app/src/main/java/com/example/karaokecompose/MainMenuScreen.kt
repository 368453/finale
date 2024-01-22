package com.example.karaokecompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController

class MainMenuScreen {
    companion object {

        @Composable
        fun create(navController: NavController, modifier: Modifier = Modifier) {
            val items =
                listOf("Downloaded Lyrics", "Top 100 Charts", "Search by Artist", "Search by Song")
            Column {
                TitleBar("Karaoke App", false, navController)
                MainMenu(items, navController)
            }
        }
    }
}




