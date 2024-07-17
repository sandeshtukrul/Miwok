package com.tukrulsandesh.miwok

data class Word(
    val engTextId: Int,
    val miwokTextId: Int,
    val imageId: Int? = null,
    val audioId: Int,
)


sealed class WordItemVariation {
    data class Standard(val words: List<Word>) : WordItemVariation()
    data class NoImage(val words: List<Word>) : WordItemVariation()
}