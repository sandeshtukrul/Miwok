package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Family extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releseMedia();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(R.string.family_father, R.string.miwok_family_father,
                R.drawable.family_father, R.raw.family_father));
        words.add(new Word(R.string.family_mother, R.string.miwok_family_mother,
                R.drawable.family_mother, R.raw.family_mother));
        words.add(new Word(R.string.family_son, R.string.miwok_family_son,
                R.drawable.family_son, R.raw.family_son));
        words.add(new Word(R.string.family_daughter, R.string.miwok_family_daughter,
                R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word(R.string.family_older_brother, R.string.miwok_family_older_brother,
                R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Word(R.string.family_younger_brother, R.string.miwok_family_younger_brother,
                R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word(R.string.family_older_sister, R.string.miwok_family_older_sister,
                R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Word(R.string.family_younger_sister, R.string.miwok_family_younger_sister,
                R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new Word(R.string.family_grandmother, R.string.miwok_family_grandmother,
                R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Word(R.string.family_grandfather, R.string.miwok_family_grandfather,
                R.drawable.family_grandfather, R.raw.family_grandfather));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releseMedia();
                Word word = words.get(position);
                mediaPlayer = MediaPlayer.create(Family.this, word.getAudioid());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(completionListener);
            }
        });
    }

    private void releseMedia(){
        if (mediaPlayer != null){
            mediaPlayer.release();
        } else {
            mediaPlayer = null;
        }
    }

    @Override
    protected void onStop() {
        releseMedia();
        super.onStop();
    }
}