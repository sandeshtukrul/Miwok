package com.example.miwok

import android.media.MediaPlayer
import android.media.MediaPlayer.OnCompletionListener
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class Numbers : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_view)

        val words = listOf(
            Word(
                R.string.number_one, R.string.miwok_number_one,
                R.drawable.number_one, R.raw.number_one
            ),
            Word(
                R.string.number_two, R.string.miwok_number_two,
                R.drawable.number_two, R.raw.number_two
            ),
            Word(
                R.string.number_three, R.string.miwok_number_three,
                R.drawable.number_three, R.raw.number_three
            ),
            Word(
                R.string.number_four, R.string.miwok_number_four,
                R.drawable.number_four, R.raw.number_four
            ),
            Word(
                R.string.number_five, R.string.miwok_number_five,
                R.drawable.number_five, R.raw.number_five
            ),
            Word(
                R.string.number_six, R.string.miwok_number_six,
                R.drawable.number_six, R.raw.number_six
            ),
            Word(
                R.string.number_seven, R.string.miwok_number_seven,
                R.drawable.number_seven, R.raw.number_seven
            ),
            Word(
                R.string.number_eight, R.string.miwok_number_eight,
                R.drawable.number_eight, R.raw.number_eight
            ),
            Word(
                R.string.number_nine, R.string.miwok_number_nine,
                R.drawable.number_nine, R.raw.number_nine
            ),
            Word(
                R.string.number_ten, R.string.miwok_number_ten,
                R.drawable.number_ten, R.raw.number_ten
            ),
        )

        val adapter = WordAdapter(this, words, R.color.category_numbers)

        findViewById<ListView>(R.id.list).apply {
            this.adapter = adapter
            setOnItemClickListener { _, _, position, _ ->
                mediaPlayer?.release()

                mediaPlayer = MediaPlayer.create(this@Numbers, words[position].mAudio).apply {
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