package com.example.master_piece.models;

import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

public class Post {
    private String documentId;
    private String title;
    private String contents;
    @ServerTimestamp
    private Date date;


    public Post() {
    }

    public Post(String documentId, String title, String contents) {
        this.documentId = documentId;
        this.title = title;
        this.contents = contents;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "Post{" +
                "documentId='" + documentId + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", date=" + date +
                '}';
    }
}
