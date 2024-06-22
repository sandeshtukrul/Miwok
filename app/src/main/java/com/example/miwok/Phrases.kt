package com.example.miwok

import android.media.MediaPlayer
import android.media.MediaPlayer.OnCompletionListener
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class Phrases : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_view)

        val words = listOf(
            Word(
                mEng = R.string.phrase_where_are_you_going,
                mMiwok = R.string.miwok_phrase_where_are_you_going,
                mAudio = R.raw.phrase_where_are_you_going
            ),
            Word(
                mEng = R.string.phrase_what_is_your_name,
                mMiwok = R.string.miwok_phrase_what_is_your_name,
                mAudio = R.raw.phrase_what_is_your_name
            ),
            Word(
                mEng = R.string.phrase_my_name_is,
                mMiwok = R.string.miwok_phrase_my_name_is, mAudio = R.raw.phrase_my_name_is
            ),
            Word(
                mEng = R.string.phrase_how_are_you_feeling,
                mMiwok = R.string.miwok_phrase_how_are_you_feeling,
                mAudio = R.raw.phrase_how_are_you_feeling
            ),
            Word(
                mEng = R.string.phrase_im_feeling_good,
                mMiwok = R.string.miwok_phrase_im_feeling_good,
                mAudio = R.raw.phrase_im_feeling_good
            ),
            Word(
                mEng = R.string.phrase_are_you_coming,
                mMiwok = R.string.miwok_phrase_are_you_coming, mAudio = R.raw.phrase_are_you_coming
            ),
            Word(
                mEng = R.string.phrase_yes_im_coming,
                mMiwok = R.string.miwok_phrase_yes_im_coming, mAudio = R.raw.phrase_yes_im_coming
            ),
            Word(
                mEng = R.string.phrase_im_coming,
                mMiwok = R.string.miwok_phrase_im_coming, mAudio = R.raw.phrase_im_coming
            ),
            Word(
                mEng = R.string.phrase_lets_go,
                mMiwok = R.string.miwok_phrase_lets_go, mAudio = R.raw.phrase_lets_go
            ),
            Word(
                mEng = R.string.phrase_come_here,
                mMiwok = R.string.miwok_phrase_come_here, mAudio = R.raw.phrase_come_here
            )
        )


        val adapter = WordAdapter(this, words, R.color.category_phrases)


        findViewById<ListView>(R.id.list).apply {
            this.adapter = adapter
            setOnItemClickListener { _, _, position, _ ->
                mediaPlayer?.release()

                mediaPlayer = MediaPlayer.create(this@Phrases, words[position].mAudio).apply {
                    start()
                    setOnCompletionListener { release() }
                }
            }
        }
    }

    override fun onStop() {
        mediaPlayer?.release()
        super.onStop()
    }
}