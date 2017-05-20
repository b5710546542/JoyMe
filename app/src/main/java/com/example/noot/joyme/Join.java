package com.example.noot.joyme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Join extends AppCompatActivity {

    TextView ownerJoin, titleJoin, placeJoin, timeJoin, maxmemberJoin;
    ListView listJoin;
    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        key = getIntent().getExtras().getString("EXTRA_ITEM_KEY");
        initInstances();
    }

    private void initInstances() {
        ownerJoin = (TextView) findViewById(R.id.ownerView);
        titleJoin = (TextView) findViewById(R.id.titleJoin);
        placeJoin = (TextView) findViewById(R.id.placeJoin);
        timeJoin = (TextView) findViewById(R.id.timeJoin);
        maxmemberJoin = (TextView) findViewById(R.id.maxMemberJoin);
        listJoin = (ListView) findViewById(R.id.listJoin);

        setInitInfo();
    }

    private void setInitInfo (){
        int id = Data.getInstance().getKeyPost().indexOf(key);
        Post post = Data.getInstance().getEventPost().get(id);

        ownerJoin.setText(post.getAuthor());
        titleJoin.setText(post.getTitle());
        placeJoin.setText(post.getPlace());
        timeJoin.setText(post.getTime());
    }
}
