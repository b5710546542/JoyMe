package com.example.noot.joyme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Event extends AppCompatActivity {

    private Button btnUpdate;
    private EditText edtTitle, edtPlace, edtTime, edtLimitMember;
    private FirebaseAuth mAuth;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("server/saving-data/events");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mAuth = FirebaseAuth.getInstance();
        initInstances();
    }

    private void initInstances() {
        edtTitle = (EditText) findViewById(R.id.edtTitle);
        edtPlace = (EditText) findViewById(R.id.edtPlace);
        edtTime = (EditText) findViewById(R.id.edtTime);
        edtLimitMember = (EditText) findViewById(R.id.edtLimitMember);

        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = edtTitle.getText().toString();
                String place = edtPlace.getText().toString();
                String time = edtTime.getText().toString();
                String maxMember = edtLimitMember.getText().toString();
                int limit = Integer.parseInt(maxMember);
                createEvent(title,place,time,limit);
                finish();
                startActivity(new Intent(Event.this,Profile.class));
            }
        });
    }

    private void createEvent(String title, String place, String time, int maxMember){
        UserInfo user = mAuth.getCurrentUser();
        DatabaseReference postsRef = ref.child("posts");
        DatabaseReference newPostRef = postsRef.push();
        Post post = new Post(user.getUid(), title, place, time, maxMember);
        newPostRef.setValue(post.getPost(),
                new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                        if(databaseError != null){
                            Toast.makeText(getApplicationContext(),"create event FAIL",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(),"create event SUCCESS!!!",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
