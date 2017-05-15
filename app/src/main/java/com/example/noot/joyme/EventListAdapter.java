package com.example.noot.joyme;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by Noot on 5/14/2017.
 */

public class EventListAdapter extends BaseAdapter {



    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        EventList event;
        if(convertView != null){
            event = (EventList) convertView;
        }else{
            event = new EventList(parent.getContext());
        }
        return event;
    }
}
