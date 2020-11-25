package com.example.master_piece;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseFirestore mStore = FirebaseFirestore.getInstance();
    private EditText mEmailText, mPwText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mEmailText = findViewById(R.id.sign_Email);
        mPwText = findViewById(R.id.sign_Pw);

        findViewById(R.id.sign_Sign_up).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        mAuth.createUserWithEmailAndPassword(mEmailText.getText().toString(), mPwText.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            if (user != null) {
                                Map<String, Object> userMap = new HashMap<>();
                                userMap.put(FirebaseID.documentID, user.getUid());
                                userMap.put(FirebaseID.email, mEmailText.getText().toString());
                                userMap.put(FirebaseID.password, mPwText.getText().toString());
                                mStore.collection(FirebaseID.user).document(user.getUid()).set(userMap, SetOptions.merge());
                                finish();
                            }
                        } else {
                            Toast.makeText(SignupActivity.this, "Sign up Error.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }
}
