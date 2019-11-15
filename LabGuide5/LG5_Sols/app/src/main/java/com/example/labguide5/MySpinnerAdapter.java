package com.example.labguide5;

import android.content.Context;
import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MySpinnerAdapter  extends ArrayAdapter<City> {
    private Context context;
    private int layoutResourceId;
    private LayoutInflater inflator;

    private boolean flag=false;

    public MySpinnerAdapter(@NonNull Context context, int resource) {
        super(context, resource, CitySys.getSpinnerValues()); //Do not forget to call super class constructor. By the help of it, now adapter know that howmany times getView method will be called.
        this.context = context;
        this.layoutResourceId = resource;
    }

    @Override
    public View getDropDownView(int position,  View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }
    public View getCustomView(int position,  View convertView,  ViewGroup parent) {
        View rowView = convertView;
        if(rowView == null){
            inflator = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflator.inflate(layoutResourceId,parent,false);
        }

        ConstraintLayout itemLayout = rowView.findViewById(R.id.itemLayout);
        TextView tv_main = rowView.findViewById(R.id.tv_main);
        ImageView leftPic = rowView.findViewById(R.id.left_pic);

        if(flag)
            itemLayout.setBackgroundColor(Color.MAGENTA);
        else
            itemLayout.setBackgroundColor(Color.BLUE);

        tv_main.setText(CitySys.getItem(position).getName());
        leftPic.setImageResource(CitySys.getItem(position).getImgId());

        return rowView;
    }

}
