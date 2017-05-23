package com.example.noot.joyme;

import android.content.Context;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import java.util.ArrayList;


public class Data {

    private static Data instance;
    private ArrayList<Post> eventPost = new ArrayList<Post>();
    private ArrayList<String> keyPost = new ArrayList<String>();

    //user info
    private User user;
//    private ArrayList<String> eventlist = new ArrayList<String>();
//    private ArrayList<String> friendlist = new ArrayList<String>();

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("server/saving-data/events/posts");

    public static Data getInstance() {
        if (instance == null)
            instance = new Data();
        return instance;
    }

    private Context mContext;

    private Data() {
        mContext = Contextor.getInstance().getContext();
    }

    public void insertPost(Post post) {
        eventPost.add(post);
    }

    public ArrayList<Post> getEventPost() {
        return eventPost;
    }

    public void setEventPost(ArrayList<Post> eventPost) {
        this.eventPost = eventPost;
    }

    public void insertKeyPost(String key) {
        keyPost.add(key);
    }

    public ArrayList<String> getKeyPost() {
        return keyPost;
    }

    public void setKeyPost(ArrayList<String> keyPost) {
        this.keyPost = keyPost;
    }

//    public ArrayList<String> getEventlist() {
//        return eventlist;
//    }
//
//    public void setEventlist(ArrayList<String> eventlist) {
//        this.eventlist = eventlist;
//    }
//
//    public ArrayList<String> getFriendlist() {
//        return friendlist;
//    }
//
//    public void setFriendlist(ArrayList<String> friendlist) {
//        this.friendlist = friendlist;
//    }
//
//
//    public void insertEventPost(String event) {
//        eventlist.add(event);
//    }
//
//    public void insertFriendPost(String friend) {
//        friendlist.add(friend);
//    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void replaceData(int i, Post post) {
        eventPost.set(i, post);
    }

    public void setUpUser(User user) {
        this.user = user;
//        this.eventlist = user.getEventList();
//        this.friendlist = user.getFriendList();
    }

    public void updateUser(DataSnapshot dataSnapshot) {
        this.user = dataSnapshot.getValue(User.class);
//        eventlist = newUser.getEventList();
//        friendlist = newUser.getFriendList();
    }

    public void updateData(DataSnapshot dataSnapshot) {
        Post newPost = dataSnapshot.getValue(Post.class);
        // update key and item
        if (!keyPost.contains(dataSnapshot.getKey())) {
            insertPost(newPost);
            insertKeyPost(dataSnapshot.getKey());
        } else {
            int index = keyPost.indexOf(dataSnapshot.getKey());
            replaceData(index, newPost);
        }
    }

    public void removeData(DataSnapshot dataSnapshot) {
        int index = keyPost.indexOf(dataSnapshot.getKey());
        keyPost.remove(index);
        eventPost.remove(index);
    }

}
