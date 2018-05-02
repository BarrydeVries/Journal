package com.example.barry.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }

    public void confirm_button_clicked(View v) {
        Intent intent = new Intent(InputActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
