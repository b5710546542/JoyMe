package com.example.noot.joyme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Profile extends AppCompatActivity {

    private Button btnEvent;
    private TextView textUsername, textFriend;
    private FirebaseAuth mAuth;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("server/saving-data/events/posts");

    private ListView listView;
    private EventListAdapter eventListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mAuth = FirebaseAuth.getInstance();
        initInstances();
    }

    private void initInstances() {
        btnEvent = (Button) findViewById(R.id.btnEvent);
        textUsername = (TextView) findViewById(R.id.textUsername);
        textFriend = (TextView) findViewById(R.id.textFriend);

        listView = (ListView) findViewById(R.id.listView);
        eventListAdapter = new EventListAdapter();
        listView.setAdapter(eventListAdapter);

        updateUser();

        btnEvent.setOnClickListener(listener);
//        listView.setOnClickListener(listener);


        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                Post newPost = dataSnapshot.getValue(Post.class);
                System.out.println("Author: " + newPost.getAuthor());
                System.out.println("Title: " + newPost.getTitle());
                System.out.println("Place: " + newPost.getPlace());
                System.out.println("Time: " + newPost.getTime());
                System.out.println("Previous Post ID: " + prevChildKey);
                Toast.makeText(getApplicationContext(),"ADD",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {
                Toast.makeText(getApplicationContext(),"Change",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Toast.makeText(getApplicationContext(),"Remove",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {
                Post newPost = dataSnapshot.getValue(Post.class);
                System.out.println("Author: " + newPost.getAuthor());
                System.out.println("Title: " + newPost.getTitle());
                System.out.println("Place: " + newPost.getPlace());
                System.out.println("Time: " + newPost.getTime());
                System.out.println("Previous Post ID: " + prevChildKey);
                Toast.makeText(getApplicationContext(),"Move",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });


    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnEvent:
                    startActivity(new Intent(Profile.this,EventMap.class));
                    break;
                case R.id.listView:
                    Toast.makeText(getApplicationContext(),listView.getSelectedItemId()+"",
                            Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    private void updateUser(){
        FirebaseUser user = mAuth.getCurrentUser();
        textUsername.setText(user.getEmail());
        textFriend.setText("1 Friend");
    }

}
