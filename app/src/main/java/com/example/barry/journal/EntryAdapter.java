package com.example.barry.journal;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

public class EntryAdapter extends ResourceCursorAdapter {
    public EntryAdapter(Context context, Cursor cursor) {
        super(context, R.layout.entry_row, cursor);
    }

    public void bindView(View view, Context context, Cursor cursor) {

        // get appropiate content
        int mood = cursor.getInt(cursor.getColumnIndex("mood"));
        String content = cursor.getString(cursor.getColumnIndex("content"));
        String title = cursor.getString(cursor.getColumnIndex("title"));
        String time = cursor.getString(cursor.getColumnIndex("timestamp"));
        TextView contentView = view.findViewById(R.id.content);
        TextView titleView = view.findViewById(R.id.title);
        TextView timeView = view.findViewById(R.id.time);
        ImageView moodView = (ImageView) view.findViewById(R.id.mood);

        // set content to view
        contentView.setText(content);
        titleView.setText(title);
        timeView.setText(time);

        if (mood == 1)
            moodView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.emoji1));
        else if (mood == 2)
            moodView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.emoji2));
        else if (mood == 3)
            moodView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.emoji3));
        else
            moodView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.emoji4));

    }
}
