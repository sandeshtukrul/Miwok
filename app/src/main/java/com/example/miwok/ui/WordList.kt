package com.example.miwok.ui

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.miwok.R
import com.example.miwok.Word
import com.example.miwok.WordItemVariation

@Composable
fun WordList(item: WordItemVariation) {

    var currentPlayingWord by remember { mutableStateOf<Word?>(null) }
    val mediaPlayer = remember { mutableStateOf<MediaPlayer?>(null) }
    val context = LocalContext.current


    //Dispose of the MediaPlayer when the composable leaves the composition
    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer.value?.release()
        }
    }


    LazyColumn(modifier = Modifier.padding(8.dp)) {

        // Different UI according to the type of item.
        when (item) {
            is WordItemVariation.Standard -> {

                // UI for standard item
                items(item.words) { word ->
                    StandardCard(word) { clickedWord ->
                        handleAudio(clickedWord, context, currentPlayingWord, mediaPlayer) {
                            // Play the audio for the clicked word
                            currentPlayingWord = it
                        }
                    }
                }

            }


            is WordItemVariation.NoImage -> {

                // UI for special item
                items(item.words) { word ->
                    NoImageCard(word) { clickedWord ->
                        handleAudio(clickedWord, context, currentPlayingWord, mediaPlayer) {
                            // Play the audio for the clicked word
                            currentPlayingWord = it
                        }
                    }
                }

            }

        }
    }
}


@Composable
fun StandardCard(word: Word, onItemClick: (Word) -> Unit) {
    BaseCard(word, onItemClick) {
        Image(
            painter = painterResource(word.imageId!!),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp) // Set image size
        )
    }
}


@Composable
fun NoImageCard(word: Word, onItemClick: (Word) -> Unit) {
    BaseCard(word, onItemClick)
}


@Composable
fun BaseCard(
    word: Word,
    onItemClick: (Word) -> Unit,
    imageContent: @Composable (() -> Unit)? = null,
) {
    Box(modifier = Modifier.padding(4.dp).clickable { onItemClick(word) }
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorScheme.surfaceVariant,
            )
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().height(80.dp).padding(horizontal = 8.dp)
            ) {
                imageContent?.invoke()

                Column(
                    modifier = Modifier.weight(1f).padding(start = 8.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(word.miwokTextId),
                        color = colorScheme.onSurfaceVariant,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = stringResource(word.engTextId))
                }

                Icon(
                    painter = painterResource(R.drawable.play),
                    contentDescription = "Play",
                    tint = colorScheme.primary
                )
            }

        }
    }
}


fun handleAudio(
    clickedWord: Word,
    context: Context,
    currentPlayingWord: Word?,
    mediaPlayer: MutableState<MediaPlayer?>,
    onWordChanged: (Word?) -> Unit,
) {

    mediaPlayer.value?.release()

    if (currentPlayingWord == clickedWord) {
        onWordChanged(null)
        return
    }

    MediaPlayer.create(context, clickedWord.audioId).apply {
        mediaPlayer.value = this
        onWordChanged(clickedWord)

        setOnCompletionListener {
            release()
            onWordChanged(null) // Reset the currentPlayingWord when the audio playback completes
            mediaPlayer.value = null
        }
        start()
    }
}

