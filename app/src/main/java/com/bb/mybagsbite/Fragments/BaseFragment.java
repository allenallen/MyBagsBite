package com.bb.mybagsbite.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bb.mybagsbite.Helpers.ViewHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment {
    private static final String CLASS_NAME="class";

    public BaseFragment() {
        // Required empty public constructor
    }

    static BaseFragment newInstance(String className){
        BaseFragment f=new BaseFragment();
        Bundle args=new Bundle();
        args.putString(CLASS_NAME, className);
        f.setArguments(args);
        return(f);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = ViewHelper.getView("fragment_register",inflater,container);
        return v;
    }

}
