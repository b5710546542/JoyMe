package com.example.noot.joyme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Join extends AppCompatActivity {

    TextView ownerJoin, titleJoin, placeJoin, timeJoin, maxmemberJoin;
    ListView listJoin;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        initInstances();
    }

    private void initInstances() {
        ownerJoin = (TextView) findViewById(R.id.ownerView);
        titleJoin = (TextView) findViewById(R.id.titleJoin);
        placeJoin = (TextView) findViewById(R.id.placeJoin);
        timeJoin = (TextView) findViewById(R.id.timeJoin);
        maxmemberJoin = (TextView) findViewById(R.id.maxMemberJoin);
        listJoin = (ListView) findViewById(R.id.listJoin);
    }
}
