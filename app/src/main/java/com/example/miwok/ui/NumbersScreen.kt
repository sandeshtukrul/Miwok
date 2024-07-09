package com.example.miwok.ui

import androidx.compose.runtime.Composable
import com.example.miwok.R
import com.example.miwok.R.string.*
import com.example.miwok.Word
import com.example.miwok.WordItemVariation


@Composable
fun NumberScreen(){

    val words = listOf(
        Word(
            number_one, miwok_number_one,
            R.drawable.number_one, R.raw.number_one
        ),
        Word(
            number_two, miwok_number_two,
            R.drawable.number_two, R.raw.number_two
        ),
        Word(
            number_three, miwok_number_three,
            R.drawable.number_three, R.raw.number_three
        ),
        Word(
            number_four, miwok_number_four,
            R.drawable.number_four, R.raw.number_four
        ),
        Word(
            number_five, miwok_number_five,
            R.drawable.number_five, R.raw.number_five
        ),
        Word(
            number_six, miwok_number_six,
            R.drawable.number_six, R.raw.number_six
        ),
        Word(
            number_seven, miwok_number_seven,
            R.drawable.number_seven, R.raw.number_seven
        ),
        Word(
            number_eight, miwok_number_eight,
            R.drawable.number_eight, R.raw.number_eight
        ),
        Word(
            number_nine, miwok_number_nine,
            R.drawable.number_nine, R.raw.number_nine
        ),
        Word(
            number_ten, miwok_number_ten,
            R.drawable.number_ten, R.raw.number_ten
        ),
    )

    WordList(WordItemVariation.Standard(words))
}