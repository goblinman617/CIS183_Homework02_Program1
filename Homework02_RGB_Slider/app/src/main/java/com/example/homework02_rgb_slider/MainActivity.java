package com.example.homework02_rgb_slider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_j_save_color = findViewById(R.id.btn_v_save_color);
        tv_j_red = findViewById(R.id.tv_v_red);
        tv_j_green = findViewById(R.id.tv_v_green);
        tv_j_blue = findViewById(R.id.tv_v_blue);
        tv_j_hex_intro = findViewById(R.id.tv_v_hex_intro);
        tv_j_hex_value = findViewById(R.id.tv_v_hex_value);
        sb_j_red = (SeekBar)findViewById(R.id.sb_v_red);
        sb_j_green = (SeekBar)findViewById(R.id.sb_v_green);
        sb_j_blue = (SeekBar)findViewById(R.id.sb_v_blue);

        saveColorButtonEventHandler();

        sb_j_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

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

            }
        });
    }
}