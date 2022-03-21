package com.example.firstohm_yu.newproject;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

import java.util.Map;

public class MainFragment extends Fragment implements View.OnClickListener{
    private OnListFragmentInteractionListener mListener;
    private View view;
    public MainFragment() {
        // Required empty public constructor
    }

    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Map<String, Object> item);

    }
    @Override
    public void onClick(View v) {

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //if(eventAdapter!=null)  eventAdapter.notifyDataSetChanged();
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                                       + " must implement OnListFragmentInteractionListener");
        }
    }

}
