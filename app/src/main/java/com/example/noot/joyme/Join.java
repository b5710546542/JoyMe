package com.example.noot.joyme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Join extends AppCompatActivity {

    TextView ownerJoin, titleJoin, placeJoin, timeJoin, maxmemberJoin;
    ListView listJoin;
    String key;
    int index;
    Button btnJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        key = getIntent().getExtras().getString("EXTRA_ITEM_KEY");
        index = Data.getInstance().getKeyPost().indexOf(key);
        initInstances();
    }

    private void initInstances() {
        ownerJoin = (TextView) findViewById(R.id.ownerView);
        titleJoin = (TextView) findViewById(R.id.titleJoin);
        placeJoin = (TextView) findViewById(R.id.placeJoin);
        timeJoin = (TextView) findViewById(R.id.timeJoin);
        maxmemberJoin = (TextView) findViewById(R.id.maxMemberJoin);
        listJoin = (ListView) findViewById(R.id.listJoin);
        btnJoin = (Button) findViewById(R.id.btnJoin);

        MembertListAdapter membertListAdapter = new MembertListAdapter();
        membertListAdapter.setKeyEvent(index);
        listJoin.setAdapter(membertListAdapter);

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(Join.this,Profile.class));
            }
        });

        setInitInfo();
    }

    private void setInitInfo (){
        int id = Data.getInstance().getKeyPost().indexOf(key);
        Post post = Data.getInstance().getEventPost().get(id);

        ownerJoin.setText("Owner " + post.getAuthor());
        titleJoin.setText("Title " + post.getTitle());
        placeJoin.setText("Place " + post.getPlace());
        timeJoin.setText("Time " + post.getTime());
        maxmemberJoin.setText("Member " + post.getCurrentNumberMember() + "/" + post.getMaxNumberMember());
    }
}
