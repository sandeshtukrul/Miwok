package com.example.miwok;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {

    private int colorid;

    public WordAdapter(Context context, ArrayList<Word> words, int ColorId) {
        super(context, 0, words);
        colorid = ColorId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listview = convertView;
        if (listview == null) {
            listview = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word word = getItem(position);

        TextView textView = listview.findViewById(R.id.miwokWord);
        textView.setText(word.getMiwok());

        TextView textView1 = listview.findViewById(R.id.engWord);
        textView1.setText(word.getEnglish());

        ImageView imageView = listview.findViewById(R.id.imageid);
        if (word.hasImage()){
            imageView.setImageResource(word.getImageid());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        View container = listview.findViewById(R.id.container);
        int color = ContextCompat.getColor(getContext(), colorid);
        container.setBackgroundColor(color);

        return listview;
    }
}
