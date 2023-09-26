package com.example.homework02_rgb_slider;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorListAdapter extends BaseAdapter {
    Context context;
    ArrayList<ColorInfo> colorList;
    public ColorListAdapter(Context context, ArrayList<ColorInfo> colorList){
        this.context = context;
        this.colorList = colorList;
        //pass info from MainActivity.java
    }

    @Override
    public int getCount() {
        return colorList.size();
    }

    @Override
    public Object getItem(int i) {
        return colorList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.custom_cell, null);
        }
        //find gui elements
        TextView preRed = view.findViewById(R.id.tv_v_cell_red_pre);
        TextView red = view.findViewById(R.id.tv_v_cell_red);
        TextView preGreen = view.findViewById(R.id.tv_v_cell_green_pre);
        TextView green = view.findViewById(R.id.tv_v_cell_green);
        TextView preBlue = view.findViewById(R.id.tv_v_cell_blue_pre);
        TextView blue = view.findViewById(R.id.tv_v_cell_blue);
        TextView preHex = view.findViewById(R.id.tv_v_cell_hex_pre);
        TextView hex = view.findViewById(R.id.tv_v_cell_hexadecimal);

        //set the gui for the cell.
        ColorInfo entry = colorList.get(i);

        red.setText(entry.getRed()+"");
        green.setText(entry.getGreen()+"");
        blue.setText(entry.getBlue()+"");
        hex.setText(entry.getHexadecimal());
        view.setBackgroundColor(Color.argb(255,entry.getRed(),entry.getGreen(),entry.getBlue()));
        if (entry.getRed()+entry.getGreen()+entry.getBlue() < (255+255+255)/2 && entry.getGreen() < 210){
            //white text
            preRed.setTextColor(Color.WHITE);
            red.setTextColor(Color.WHITE);
            preGreen.setTextColor(Color.WHITE);
            green.setTextColor(Color.WHITE);
            preBlue.setTextColor(Color.WHITE);
            blue.setTextColor(Color.WHITE);
            preHex.setTextColor(Color.WHITE);
            hex.setTextColor(Color.WHITE);
        }else{
            //black text
        }
        return view;
    }
}
