package com.example.barry.journal;

import java.io.Serializable;

public class JournalEntry implements Serializable {
    private int id, mood;
    private String title, content, timestamp;

    public JournalEntry(int id, int mood, String title, String content, String timestamp) {
        this.id = id;
        this.mood = mood;
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public int getMood() {
        return mood;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}