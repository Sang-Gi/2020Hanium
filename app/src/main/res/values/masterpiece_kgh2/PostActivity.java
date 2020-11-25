package com.cookandroid.masterpiece_kgh2;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class PostActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mTitle, mContents;
    private FirebaseFirestore mStore = FirebaseFirestore.getInstance();
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        mTitle = findViewById(R.id.post_title_edit);
        mContents = findViewById(R.id.post_title_contents);

        findViewById(R.id.post_save_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(mAuth.getCurrentUser() != null) {
            String postID = mStore.collection(FirebaseID.post).document().getId();// 게시글 안 겹치게
            Map<String, Object> data = new HashMap<>( );
            data.put(FirebaseID.documentID, mAuth.getCurrentUser().getUid());
            data.put(FirebaseID.title, mTitle.getText().toString());
            data.put(FirebaseID.contents, mContents.getText().toString());
            data.put(FirebaseID.timestamp, FieldValue.serverTimestamp());
            mStore.collection(FirebaseID.post).document(postID).set(data, SetOptions.merge());
            finish();
        }
    }
}
