package com.example.firstohm_yu.newproject;

import android.app.Activity;
import android.content.Context;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;
public class MyAdapter extends ArrayAdapter<Object> {
    private final boolean[] mCheckedState;
    private final Context mContext;

    public MyAdapter(Context context, int resource, int textViewResourceId, List<Object> objects) {
        super(context, resource, textViewResourceId, objects);
        mCheckedState = new boolean[objects.size()];
        mContext = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // simplified to just a Checkbox
        // ViewHolder and OnCheckedChangeListener stuff left out
        CheckBox result = (CheckBox)convertView;
        if (result == null) {
            result = new CheckBox(mContext);
        }
        result.setChecked(mCheckedState[position]);
        return result;
    }
}