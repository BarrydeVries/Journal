package com.example.barry.journal;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    EntryAdapter adapter;
    EntryDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        db = EntryDatabase.getInstance(getApplicationContext());
        adapter = new EntryAdapter(this, db.selectAll());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = findViewById(R.id.listView);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);

            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursorToJournal = (Cursor) parent.getItemAtPosition(position);
                long _id = cursorToJournal.getInt(cursorToJournal.getColumnIndex("_id"));
                db.deleteEntry(_id);
                updateData();
                return true;
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        updateData();
    }

    private void updateData(){
        Cursor newCursor =  db.selectAll();
        adapter.swapCursor(newCursor);
    }

    public void create_button_clicked(View v){
        Intent intent = new Intent(MainActivity.this, InputActivity.class);
        startActivity(intent);
    }
}
