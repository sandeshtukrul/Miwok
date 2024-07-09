package com.example.miwok.ui

import androidx.compose.runtime.Composable
import com.example.miwok.R
import com.example.miwok.R.string.*
import com.example.miwok.Word
import com.example.miwok.WordItemVariation

@Composable
fun PhrasesScreen(){
    val words = listOf(
        Word(
            engTextId = phrase_where_are_you_going,
            miwokTextId = miwok_phrase_where_are_you_going,
            audioId = R.raw.phrase_where_are_you_going
        ),
        Word(
            engTextId = phrase_what_is_your_name,
            miwokTextId = miwok_phrase_what_is_your_name,
            audioId = R.raw.phrase_what_is_your_name
        ),
        Word(
            engTextId = phrase_my_name_is,
            miwokTextId = miwok_phrase_my_name_is, audioId = R.raw.phrase_my_name_is
        ),
        Word(
            engTextId = phrase_how_are_you_feeling,
            miwokTextId = miwok_phrase_how_are_you_feeling,
            audioId = R.raw.phrase_how_are_you_feeling
        ),
        Word(
            engTextId = phrase_im_feeling_good,
            miwokTextId = miwok_phrase_im_feeling_good,
            audioId = R.raw.phrase_im_feeling_good
        ),
        Word(
            engTextId = phrase_are_you_coming,
            miwokTextId = miwok_phrase_are_you_coming, audioId = R.raw.phrase_are_you_coming
        ),
        Word(
            engTextId = phrase_yes_im_coming,
            miwokTextId = miwok_phrase_yes_im_coming, audioId = R.raw.phrase_yes_im_coming
        ),
        Word(
            engTextId = phrase_im_coming,
            miwokTextId = miwok_phrase_im_coming, audioId = R.raw.phrase_im_coming
        ),
        Word(
            engTextId = phrase_lets_go,
            miwokTextId = miwok_phrase_lets_go, audioId = R.raw.phrase_lets_go
        ),
        Word(
            engTextId = phrase_come_here,
            miwokTextId = miwok_phrase_come_here, audioId = R.raw.phrase_come_here
        )
    )


    WordList(WordItemVariation.NoImage(words))
}