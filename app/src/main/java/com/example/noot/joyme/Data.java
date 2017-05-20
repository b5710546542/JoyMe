package com.example.noot.joyme;

import android.content.Context;

import com.google.firebase.database.DatabaseReference;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import java.util.ArrayList;


public class Data {

    private static Data instance;
    private ArrayList<Post> eventPost = new ArrayList<Post>();
    private ArrayList<String> keyPost = new ArrayList<String>();

    public static Data getInstance() {
        if (instance == null)
            instance = new Data();
        return instance;
    }

    private Context mContext;

    private Data() {
        mContext = Contextor.getInstance().getContext();
    }

    public void insertPost(Post post){
        eventPost.add(post);
    }

    public ArrayList<Post> getEventPost() {
        return eventPost;
    }

    public void setEventPost(ArrayList<Post> eventPost) {
        this.eventPost = eventPost;
    }

    public void insertKeyPost(String key){
        keyPost.add(key);
    }

    public ArrayList<String> getKeyPost() {
        return keyPost;
    }

    public void setKeyPost(ArrayList<String> keyPost) {
        this.keyPost = keyPost;
    }

}
