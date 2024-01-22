package com.example.karaokecompose

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.example.karaoke.db.database.Lyric
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SongLyricEditScreen {
    companion object {
        @Composable
        fun create(navController: NavHostController, backStackEntry: NavBackStackEntry, applicationContext: Context, id: Any, lifecycleScope: LifecycleCoroutineScope, viewModel: KaraokeViewModel) {

            // just do this to init the database if not already
            viewModel.setSongAdd(applicationContext)

            Column {
                TitleBar("Add", true, navController)
                val (artistText, setArtistText) = remember { mutableStateOf("Artist") }
                val (titleText, setTitleText) = remember { mutableStateOf("Title") }
                val (lyricText, setLyricText) = remember { mutableStateOf("Lyrics") }

                // Update the state variables with the text entered in text boxes
                ArtistTextBox(artistText) { setArtistText(it) }
                TitleTextBox(titleText) { setTitleText(it) }
                LyricTextBox(lyricText) { setLyricText(it) }
                AddButton(onClick = {
                    lifecycleScope.launch(Dispatchers.IO) {
                        viewModel.db.lyricDao().insert(
                            Lyric(
                                songName = titleText,
                                songArtist = artistText,
                                songLyric = lyricText
                            )
                        )
                    }
                    navController.popBackStack()
                })
            }
        }
        @Composable
        fun ArtistTextBox(artist: String, onArtistChange: (String) -> Unit) {
            MyTheme {
                TextField(
                    value = artist,
                    onValueChange = {onArtistChange(it)},
                    modifier = Modifier
                        //.heightIn(max = 600.dp)
                        .padding(16.dp),
                    textStyle = TextStyle(
                        fontSize = MaterialTheme.typography.h6.fontSize
                    ),
                    maxLines = Int.MAX_VALUE,
                    singleLine = false,
                    readOnly = false
                )
            }
        }
        @Composable
        fun TitleTextBox(title: String, onTitleChange: (String) -> Unit) {
            MyTheme {
                TextField(
                    value = title,
                    onValueChange = {onTitleChange(it)},
                    modifier = Modifier
                        //.heightIn(max = 600.dp)
                        .padding(16.dp),
                    textStyle = TextStyle(
                        fontSize = MaterialTheme.typography.h6.fontSize
                    ),
                    maxLines = Int.MAX_VALUE,
                    singleLine = false,
                    readOnly = false
                )
            }
        }
        @Composable
        fun LyricTextBox(lyrics: String, onLyricChange: (String) -> Unit) {
            MyTheme {
                TextField(
                    value = lyrics,
                    onValueChange = {onLyricChange(it)},
                    modifier = Modifier
                        //.heightIn(max = 600.dp)
                        .padding(16.dp),
                    textStyle = TextStyle(
                        fontSize = MaterialTheme.typography.h6.fontSize
                    ),
                    maxLines = Int.MAX_VALUE,
                    singleLine = false,
                    readOnly = false
                )
            }
        }
    }
}
