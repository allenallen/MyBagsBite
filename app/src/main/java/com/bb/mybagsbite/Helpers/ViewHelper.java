package com.bb.mybagsbite.Helpers;

import android.app.Activity;
import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bb.mybagsbite.R;

/**
 * Created by eaarcenal on 10/7/16.
 */

public class ViewHelper {

    private static String VIEW_CLASS;
    private static AppCompatActivity app;

    public ViewHelper(String className,AppCompatActivity app){
        this.app = app;
        VIEW_CLASS = className;
    }

    public static View getView(String layout,LayoutInflater inflater, ViewGroup parent){

        int id = app.getResources().getIdentifier(layout,"id",app.getPackageName());

        View view = inflater.inflate(id,parent,false);

        return view;
    }


}
