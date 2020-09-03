package com.example.imsimplegary.waimaiapp.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.imsimplegary.waimaiapp.R;
import com.example.imsimplegary.waimaiapp.View.paintView;


public class UserFragment extends Fragment {
    private View view;
    RelativeLayout v_bg;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_user,container,false);
        v_bg = view.findViewById(R.id.v_bg);
        v_bg.addView(new paintView(this.getContext()));
        return view;
    }
}
