package com.example.miwok

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class Colors : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_view)

        val words = listOf(
            Word(
                R.string.color_red, R.string.miwok_color_red,
                R.drawable.color_red, R.raw.color_red
            ),
            Word(
                R.string.color_mustard_yellow, R.string.miwok_color_mustard_yellow,
                R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow
            ),
            Word(
                R.string.color_dusty_yellow, R.string.miwok_color_dusty_yellow,
                R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow
            ),
            Word(
                R.string.color_green, R.string.miwok_color_green,
                R.drawable.color_green, R.raw.color_green
            ),
            Word(
                R.string.color_brown, R.string.miwok_color_brown,
                R.drawable.color_brown, R.raw.color_brown
            ),
            Word(
                R.string.color_gray, R.string.miwok_color_gray,
                R.drawable.color_gray, R.raw.color_gray
            ),
            Word(
                R.string.color_black, R.string.miwok_color_black,
                R.drawable.color_black, R.raw.color_black
            ),
            Word(
                R.string.color_white, R.string.miwok_color_white,
                R.drawable.color_white, R.raw.color_white
            )
        )


        val adapter = WordAdapter(this, words, R.color.category_colors)

        findViewById<ListView>(R.id.list).apply {
            this.adapter = adapter
            setOnItemClickListener { _, _, position, _ ->
                mediaPlayer?.release()

                mediaPlayer = MediaPlayer.create(this@Colors, words[position].mAudio).apply {
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