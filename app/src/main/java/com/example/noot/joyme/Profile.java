package com.example.noot.joyme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile extends AppCompatActivity {

    private Button btnEvent;
    private TextView textUsername, textFriend;
    private FirebaseAuth mAuth;
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

        btnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this,EventMap.class));
            }
        });
    }

    private void updateUser(){
        FirebaseUser user = mAuth.getCurrentUser();
        textUsername.setText(user.getEmail());
        textFriend.setText("1 Friend");
    }
}
