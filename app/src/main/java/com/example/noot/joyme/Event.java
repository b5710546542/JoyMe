package com.example.noot.joyme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Event extends AppCompatActivity {

    Button btnUpdate;
    EditText edtTitle, edtPlace, edtTime, edtLimitMember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

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
                String limitMember = edtLimitMember.getText().toString();
                createEvent(title,place,time,limitMember);
                finish();
                startActivity(new Intent(Event.this,Profile.class));
            }
        });
    }

    private void createEvent(String title, String place, String time, String limitMember){

    }
}
