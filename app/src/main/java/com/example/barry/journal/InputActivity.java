package com.example.barry.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {
int mood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        mood = 0;
    }

    public void mood_button_1(View V) {
        mood = 1;
    }
    public void mood_button_2(View V) {
        mood = 2;
    }
    public void mood_button_3(View V) {
        mood = 3;
    }
    public void mood_button_4(View V) {
        mood = 4;
    }

    public void confirm_button_clicked(View v) {
        EditText title = findViewById(R.id.title);
        EditText description = findViewById(R.id.description);

        JournalEntry entry = new JournalEntry(mood, title.getText().toString(), description.getText().toString());
        EntryDatabase database = EntryDatabase.getInstance(this);
        database.insert(entry);

        Intent intent = new Intent(InputActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
