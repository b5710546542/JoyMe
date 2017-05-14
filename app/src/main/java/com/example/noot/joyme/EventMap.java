package com.example.noot.joyme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EventMap extends AppCompatActivity {

    Button btnCreateEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_map);
        initInstances();
    }

    private void initInstances() {
        btnCreateEvent = (Button) findViewById(R.id.btnCreateEvent);
        btnCreateEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventMap.this,Event.class));
            }
        });
    }
}
