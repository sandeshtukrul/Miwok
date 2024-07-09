package com.example.miwok.ui

import androidx.compose.runtime.Composable
import com.example.miwok.R
import com.example.miwok.R.string.*
import com.example.miwok.Word
import com.example.miwok.WordItemVariation

@Composable
fun ColorsScreen(){
    val words = listOf(
        Word(
            color_red, miwok_color_red,
            R.drawable.color_red, R.raw.color_red
        ),
        Word(
            color_mustard_yellow, miwok_color_mustard_yellow,
            R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow
        ),
        Word(
            color_dusty_yellow, miwok_color_dusty_yellow,
            R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow
        ),
        Word(
            color_green, miwok_color_green,
            R.drawable.color_green, R.raw.color_green
        ),
        Word(
            color_brown, miwok_color_brown,
            R.drawable.color_brown, R.raw.color_brown
        ),
        Word(
            color_gray, miwok_color_gray,
            R.drawable.color_gray, R.raw.color_gray
        ),
        Word(
            color_black, miwok_color_black,
            R.drawable.color_black, R.raw.color_black
        ),
        Word(
            color_white, miwok_color_white,
            R.drawable.color_white, R.raw.color_white
        )
    )



    WordList(WordItemVariation.Standard(words))
}