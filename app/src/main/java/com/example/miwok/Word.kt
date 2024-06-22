package com.example.miwok

data class Word(
    val mEng: Int,
    val mMiwok: Int,
    val mImageid: Int? = NO_IMAGE_PROVIDED,
    val mAudio: Int,
) {
    fun hasImage(): Boolean {
        return mImageid != NO_IMAGE_PROVIDED
    }

    companion object {
        private const val NO_IMAGE_PROVIDED = -1
    }
}
