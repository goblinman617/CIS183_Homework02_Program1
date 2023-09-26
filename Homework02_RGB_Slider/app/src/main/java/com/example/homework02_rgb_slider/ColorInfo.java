package com.example.homework02_rgb_slider;

public class ColorInfo {
    int red;
    int green;
    int blue;
    String hexadecimal;

    public ColorInfo(){

    }
    public ColorInfo(int r, int g, int b, String hexadecimal){
        red = r;
        green = g;
        blue = b;
        this.hexadecimal = hexadecimal;
    }

    //getters and setters
    public int getRed() {
        return red;
    }
    public void setRed(int red) {
        this.red = red;
    }
    public int getGreen() {
        return green;
    }
    public void setGreen(int green) {
        this.green = green;
    }
    public int getBlue() {
        return blue;
    }
    public void setBlue(int blue) {
        this.blue = blue;
    }
    public String getHexadecimal() {
        return hexadecimal;
    }
    public void setHexadecimal(String hexadecimal) {
        this.hexadecimal = hexadecimal;
    }
}
