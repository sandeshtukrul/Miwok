package com.example.miwok

import android.media.MediaPlayer
import android.media.MediaPlayer.OnCompletionListener
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class Family : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_view)

        val words = listOf(
            Word(
                R.string.family_father, R.string.miwok_family_father,
                R.drawable.family_father, R.raw.family_father
            ),
            Word(
                R.string.family_mother, R.string.miwok_family_mother,
                R.drawable.family_mother, R.raw.family_mother
            ),
            Word(
                R.string.family_son, R.string.miwok_family_son,
                R.drawable.family_son, R.raw.family_son
            ),
            Word(
                R.string.family_daughter, R.string.miwok_family_daughter,
                R.drawable.family_daughter, R.raw.family_daughter
            ),
            Word(
                R.string.family_older_brother, R.string.miwok_family_older_brother,
                R.drawable.family_older_brother, R.raw.family_older_brother
            ),
            Word(
                R.string.family_younger_brother, R.string.miwok_family_younger_brother,
                R.drawable.family_younger_brother, R.raw.family_younger_brother
            ),
            Word(
                R.string.family_older_sister, R.string.miwok_family_older_sister,
                R.drawable.family_older_sister, R.raw.family_older_sister
            ),
            Word(
                R.string.family_younger_sister, R.string.miwok_family_younger_sister,
                R.drawable.family_younger_sister, R.raw.family_younger_sister
            ),
            Word(
                R.string.family_grandmother, R.string.miwok_family_grandmother,
                R.drawable.family_grandmother, R.raw.family_grandmother
            ),
            Word(
                R.string.family_grandfather, R.string.miwok_family_grandfather,
                R.drawable.family_grandfather, R.raw.family_grandfather
            )
        )

        val adapter = WordAdapter(this, words, R.color.category_family)

        findViewById<ListView>(R.id.list).apply {
            this.adapter = adapter
            setOnItemClickListener { _, _, position, _ ->
                mediaPlayer?.release()

                mediaPlayer = MediaPlayer.create(this@Family, words[position].mAudio).apply {
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