package com.example.barry.journal;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        int mood = (int) intent.getSerializableExtra("mood");
        String title = (String) intent.getSerializableExtra("title");
        String content = (String) intent.getSerializableExtra("content");
        String time = (String) intent.getSerializableExtra("timestamp");

        TextView titleView = findViewById(R.id.title);
        TextView contentView = findViewById(R.id.content);
        TextView timestampView = findViewById(R.id.time);
        ImageView moodView = findViewById(R.id.mood);

        titleView.setText(title);
        contentView.setText(content);
        timestampView.setText(time);
        if (mood == 1)
            moodView.setImageResource(R.drawable.emoji1);
        else if (mood == 2)
            moodView.setImageResource(R.drawable.emoji2);
        else if (mood == 3)
            moodView.setImageResource(R.drawable.emoji3);
        else
            moodView.setImageResource(R.drawable.emoji4);
    }
}
