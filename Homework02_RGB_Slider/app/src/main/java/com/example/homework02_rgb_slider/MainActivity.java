package com.example.homework02_rgb_slider;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.AndroidException;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn_j_save_color;
    TextView tv_j_red;
    TextView tv_j_green;
    TextView tv_j_blue;
    TextView tv_j_hex_intro;
    TextView tv_j_hex_value;
    SeekBar sb_j_red;
    SeekBar sb_j_green;
    SeekBar sb_j_blue;
    ListView lv_j_colors;
    ArrayList<ColorInfo> colorList = new ArrayList<>();
    ColorListAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //we have to set background color here because if we do it in the XML
        //I'm not able to update it later.
        //also I need to set the background to white because my phone is in dark mode and it defaults the background to a darker color
        this.findViewById(android.R.id.content).setBackgroundColor(Color.argb(255,255,255,255));

        btn_j_save_color = findViewById(R.id.btn_v_save_color);
        tv_j_red = findViewById(R.id.tv_v_red);
        tv_j_green = findViewById(R.id.tv_v_green);
        tv_j_blue = findViewById(R.id.tv_v_blue);
        tv_j_hex_intro = findViewById(R.id.tv_v_hex_intro);
        tv_j_hex_value = findViewById(R.id.tv_v_hex_value);
        sb_j_red = (SeekBar)findViewById(R.id.sb_v_red);
        sb_j_green = (SeekBar)findViewById(R.id.sb_v_green);
        sb_j_blue = (SeekBar)findViewById(R.id.sb_v_blue);
        lv_j_colors = (ListView)findViewById(R.id.lv_v_colors);


        saveColorButtonEventHandler();
        fillListView();

        lv_j_colors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {//holy crap this works
                ColorInfo selected = (ColorInfo) lv_j_colors.getItemAtPosition(i);
                sb_j_red.setProgress(selected.getRed());
                sb_j_blue.setProgress(selected.getBlue());
                sb_j_green.setProgress(selected.getGreen());
                changeBackgroundAndText();
            }
        });
        sb_j_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                changeBackgroundAndText();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sb_j_green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                changeBackgroundAndText();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sb_j_blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                changeBackgroundAndText();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    public void saveColorButtonEventHandler() {
        btn_j_save_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addColor();
                resetValues();
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void resetValues(){
        sb_j_red.setProgress(255);
        sb_j_blue.setProgress(255);
        sb_j_green.setProgress(255);
    }
    //considering making this 2 functions
    public void changeBackgroundAndText(){
        //consider getting progress of just the changed value and storing the others if this is too slow
        //its also just kind of gross like this
        int r = sb_j_red.getProgress();
        int g = sb_j_green.getProgress();
        int b = sb_j_blue.getProgress();
        tv_j_red.setText("Red: " + r);
        tv_j_green.setText("Green: " + g);
        tv_j_blue.setText("Blue: " + b);
        tv_j_hex_value.setText(convertToHexadecimal(r,g,b));
        this.findViewById(android.R.id.content).setBackgroundColor(Color.argb(255,r,g,b));
        if (r+g+b < (255+255+255)/2 && g < 210){
            changeTextColor(0);//white
        }else{
            changeTextColor(1);//black
        }
    }
    public void changeBackgroundAndText(int r, int g, int b, String hex){
        tv_j_red.setText("Red: " + r);
        tv_j_green.setText("Green: " + g);
        tv_j_blue.setText("Blue: " + b);
        tv_j_hex_value.setText(hex);
        getWindow().getDecorView().setBackgroundColor(Color.argb(255,r,g,b));
        if (r+g+b < (255+255+255)/2 && g < 210){
            changeTextColor(0);//white
        }else{
            changeTextColor(1);//black
        }
    }
    public void fillListView(){
        adapter = new ColorListAdapter(this, colorList);
        //set the listview adapter
        lv_j_colors.setAdapter(adapter);
    }
    public void changeTextColor(int mode){//0 for white text. 1 for black text
        if (mode == 0) {
            tv_j_red.setTextColor(Color.WHITE);
            tv_j_green.setTextColor(Color.WHITE);
            tv_j_blue.setTextColor(Color.WHITE);
            tv_j_hex_value.setTextColor(Color.WHITE);
            tv_j_hex_intro.setTextColor(Color.WHITE);
        }else{
            tv_j_red.setTextColor(Color.BLACK);
            tv_j_green.setTextColor(Color.BLACK);
            tv_j_blue.setTextColor(Color.BLACK);
            tv_j_hex_value.setTextColor(Color.BLACK);
            tv_j_hex_intro.setTextColor(Color.BLACK);
        }

    }
    public void addColor(){
        int r = sb_j_red.getProgress();
        int g = sb_j_green.getProgress();
        int b = sb_j_blue.getProgress();
        String hex = convertToHexadecimal(r,g,b);
        ColorInfo entry = new ColorInfo(r,g,b,hex);
        colorList.add(entry);
    }
    public String convertToHexadecimal(int r, int g, int b){ //checked and working
        char[] letters = new char[] {'A','B','C','D','E','F'};
        String hexadecimal = "";
        int val;

        //red hexadecimal part
        val = r/16;
        if (val < 10){
            hexadecimal += val;
        }else {
            int i = 0;
            while (val != i+10){
                i++;
            }
            hexadecimal += letters[i];
        }
        val = r%16;
        if (val < 10){
            hexadecimal += val;
        }else {
            int i = 0;
            while (val != i+10){
                i++;
            }
            hexadecimal += letters[i];
        }
        //green hexadecimal part
        val = g/16;
        if (val < 10){
            hexadecimal += val;
        }else {
            int i = 0;
            while (val != i+10){
                i++;
            }
            hexadecimal += letters[i];
        }
        val = g%16;
        if (val < 10){
            hexadecimal += val;
        }else {
            int i = 0;
            while (val != i+10){
                i++;
            }
            hexadecimal += letters[i];
        }
        //blue hexadecimal part
        val = b/16;
        if (val < 10){
            hexadecimal += val;
        }else {
            int i = 0;
            while (val != i+10){
                i++;
            }
            hexadecimal += letters[i];
        }
        val = b%16;
        if (val < 10){
            hexadecimal += val;
        }else {
            int i = 0;
            while (val != i+10){
                i++;
            }
            hexadecimal += letters[i];
        }
        return hexadecimal;
    }
}