package com.better.reads.ui.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.better.reads.R;

public class pageDefault extends Fragment {

    public pageDefault() {
        // Required empty public constructor
    }

    public static pageDefault newInstance() {
        pageDefault fragment = new pageDefault();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_page_default, container, false);
    }
}
