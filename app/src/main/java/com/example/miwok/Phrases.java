package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Phrases extends AppCompatActivity {

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
        words.add(new Word(R.string.phrase_where_are_you_going,
                R.string.miwok_phrase_where_are_you_going, R.raw.phrase_where_are_you_going));
        words.add(new Word(R.string.phrase_what_is_your_name,
                R.string.miwok_phrase_what_is_your_name, R.raw.phrase_what_is_your_name));
        words.add(new Word(R.string.phrase_my_name_is,
                R.string.miwok_phrase_my_name_is, R.raw.phrase_my_name_is));
        words.add(new Word(R.string.phrase_how_are_you_feeling,
                R.string.miwok_phrase_how_are_you_feeling, R.raw.phrase_how_are_you_feeling));
        words.add(new Word(R.string.phrase_im_feeling_good,
                R.string.miwok_phrase_im_feeling_good, R.raw.phrase_im_feeling_good));
        words.add(new Word(R.string.phrase_are_you_coming,
                R.string.miwok_phrase_are_you_coming, R.raw.phrase_are_you_coming));
        words.add(new Word(R.string.phrase_yes_im_coming,
                R.string.miwok_phrase_yes_im_coming, R.raw.phrase_yes_im_coming));
        words.add(new Word(R.string.phrase_im_coming,
                R.string.miwok_phrase_im_coming, R.raw.phrase_im_coming));
        words.add(new Word(R.string.phrase_lets_go,
                R.string.miwok_phrase_lets_go, R.raw.phrase_lets_go));
        words.add(new Word(R.string.phrase_come_here,
                R.string.miwok_phrase_come_here, R.raw.phrase_come_here));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                mediaPlayer = MediaPlayer.create(Phrases.this, word.getAudioid());
                mediaPlayer.start();
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