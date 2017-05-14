package com.example.noot.joyme;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Noot on 5/15/2017.
 */

public class Post {

    private String author;
    private String title;
    private String place;
    private String time;
    private int maxNumberMember;
    private int currentNumberMember;
    private Map<String, Object> postUpdate = new HashMap<String, Object>();;

    public Post(String author, String title, String place, String time, int maxNumberMember) {
        postUpdate.put("author",author);
        postUpdate.put("title",title);
        postUpdate.put("place",place);
        postUpdate.put("time",time);
        postUpdate.put("maxNumberMember",maxNumberMember);
        currentNumberMember = 1;
        addMember(author);
    }

    public Map<String, Object> getPost(){
        return postUpdate;
    }

    private void addMember(String user){
        if (currentNumberMember <= maxNumberMember){
            String checkmember = currentNumberMember+ "";
            postUpdate.put(checkmember,user);
            currentNumberMember += 1;
        }
    }

}