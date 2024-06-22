package com.example.miwok

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.colors).setOnClickListener {
            startActivity(Intent(this, Colors::class.java))
        }

        findViewById<TextView>(R.id.numbers).setOnClickListener {
            startActivity(Intent(this, Numbers::class.java))
        }

        findViewById<TextView>(R.id.phrases).setOnClickListener {
            startActivity(Intent(this, Phrases::class.java))
        }

        findViewById<TextView>(R.id.family).setOnClickListener {
            startActivity(Intent(this, Family::class.java))
        }
    }
}


