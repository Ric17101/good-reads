package com.better.reads.ui.main.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.better.reads.R;

public class page1 extends Fragment {

    public page1() {
        // Required empty public constructor
    }

    public static page1 newInstance() {
        page1 fragment = new page1();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_page1, container, false);
    }
}
