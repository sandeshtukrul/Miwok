package com.tukrulsandesh.miwok.ui

import androidx.compose.runtime.Composable
import com.tukrulsandesh.miwok.R
import com.tukrulsandesh.miwok.R.string.*
import com.tukrulsandesh.miwok.Word
import com.tukrulsandesh.miwok.WordItemVariation

@Composable
fun FamilyScreen() {
    val words = listOf(
        Word(
            family_father, miwok_family_father,
            R.drawable.family_father, R.raw.family_father
        ),
        Word(
            family_mother, miwok_family_mother,
            R.drawable.family_mother, R.raw.family_mother
        ),
        Word(
            family_son, miwok_family_son,
            R.drawable.family_son, R.raw.family_son
        ),
        Word(
            family_daughter, miwok_family_daughter,
            R.drawable.family_daughter, R.raw.family_daughter
        ),
        Word(
            family_older_brother, miwok_family_older_brother,
            R.drawable.family_older_brother, R.raw.family_older_brother
        ),
        Word(
            family_younger_brother, miwok_family_younger_brother,
            R.drawable.family_younger_brother, R.raw.family_younger_brother
        ),
        Word(
            family_older_sister, miwok_family_older_sister,
            R.drawable.family_older_sister, R.raw.family_older_sister
        ),
        Word(
            family_younger_sister, miwok_family_younger_sister,
            R.drawable.family_younger_sister, R.raw.family_younger_sister
        ),
        Word(
            family_grandmother, miwok_family_grandmother,
            R.drawable.family_grandmother, R.raw.family_grandmother
        ),
        Word(
            family_grandfather, miwok_family_grandfather,
            R.drawable.family_grandfather, R.raw.family_grandfather
        )
    )


    WordList(WordItemVariation.Standard(words))
}