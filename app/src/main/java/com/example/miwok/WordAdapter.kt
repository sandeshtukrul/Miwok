package com.example.miwok

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class WordAdapter(context: Context, words: List<Word>, private val colorId: Int) :
    ArrayAdapter<Word>(
        context, 0, words
    ) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view =
            convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        val word = getItem(position)!!

        view.findViewById<TextView>(R.id.miwokWord).text = context.getString(word.mMiwok)

        view.findViewById<TextView>(R.id.engWord).text = context.getString(word.mEng)

        val imageView = view.findViewById<ImageView>(R.id.imageid)

        if (word.hasImage()) {
            imageView.setImageResource(word.mImageid!!)
            imageView.visibility = View.VISIBLE
        } else {
            imageView.visibility = View.GONE
        }

        view.findViewById<View>(R.id.container)
            .setBackgroundColor(ContextCompat.getColor(context, colorId))

        return view
    }
}
