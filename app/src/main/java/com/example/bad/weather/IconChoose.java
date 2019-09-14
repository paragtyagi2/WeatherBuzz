package com.example.bad.weather;

import android.widget.ImageView;
import android.widget.TextView;

public class IconChoose {
    public void selImage(int pos, ImageView imageView){
        switch (pos){
            case 1:
                imageView.setImageResource(R.drawable.a1);
                //textView.setText("Sunny");
                break;
            case 2:
                imageView.setImageResource(R.drawable.a2);
                //textView.setText("Mostly Sunny");
                break;
            case 3:
                imageView.setImageResource(R.drawable.a3);
                //textView.setText("Partly Sunny");
                break;
            case 4:
                imageView.setImageResource(R.drawable.a4);
                //textView.setText("Intermittent Clouds");
                break;
            case 5:
                imageView.setImageResource(R.drawable.a5);
                //textView.setText("Hazy Sunshine");
                break;
            case 6:
                imageView.setImageResource(R.drawable.a6);
                //textView.setText("Mostly Cloudy");
                break;
            case 7:
                imageView.setImageResource(R.drawable.a7);
                //textView.setText("Cloudy");
                break;
            case 8:
                imageView.setImageResource(R.drawable.a8);
                //textView.setText("Dreary (Overcast)");
                break;
            case 11:
                imageView.setImageResource(R.drawable.a11);
                //textView.setText("Fog");
                break;
            case 12:
                imageView.setImageResource(R.drawable.a12);
                //textView.setText("Showers");
                break;
            case 13:
                imageView.setImageResource(R.drawable.a13);
                //textView.setText("Mostly Cloudy / Showers");
                break;
            case 14:
                imageView.setImageResource(R.drawable.a14);
                //textView.setText("Partly Sunny / Showers");
                break;
            case 15:
                imageView.setImageResource(R.drawable.a15);
                //textView.setText("Thunderstorms");
                break;
            case 16:
                imageView.setImageResource(R.drawable.a16);
                //textView.setText("Mostly Cloudy / ThunderStorms");
                break;
            case 17:
                imageView.setImageResource(R.drawable.a17);
                //textView.setText("Partly Sunny / Thunderstorms");
                break;
            case 18:
                imageView.setImageResource(R.drawable.a18);
                //textView.setText("Rain");
                break;
            case 19:
                imageView.setImageResource(R.drawable.a19);
                //textView.setText("Flurries");
                break;
            case 20:
                imageView.setImageResource(R.drawable.a20);
                //textView.setText("Mostly Cloudy / Flurries");
                break;
            case 21:
                imageView.setImageResource(R.drawable.a21);
                //textView.setText("Partly Sunny / Flurries");
                break;
            case 22:
                imageView.setImageResource(R.drawable.a22);
                //textView.setText("Snow");
                break;
            case 23:
                imageView.setImageResource(R.drawable.a23);
                //textView.setText("Mostly Cloudy / Snow");
                break;
            case 24:
                imageView.setImageResource(R.drawable.a24);
                //textView.setText("Ice");
                break;
            case 25:
                imageView.setImageResource(R.drawable.a25);
                //textView.setText("Sleet");
                break;
            case 26:
                imageView.setImageResource(R.drawable.a26);
                //textView.setText("Freezing Rain");
                break;
            case 29:
                imageView.setImageResource(R.drawable.a29);
                //textView.setText("Rain and Snow");
                break;
            case 30:
                imageView.setImageResource(R.drawable.a30);
                //textView.setText("Hot");
                break;
            case 31:
                imageView.setImageResource(R.drawable.a31);
                //textView.setText("Cold");
                break;
            case 32:
                imageView.setImageResource(R.drawable.a32);
                //textView.setText("Windy");
                break;
            case 33:
                imageView.setImageResource(R.drawable.a33);
                //textView.setText("Clear");
                break;
            case 34:
                imageView.setImageResource(R.drawable.a34);
                //textView.setText("Mostly Clear");
                break;
            case 35:
                imageView.setImageResource(R.drawable.a35);
                //textView.setText("Partly Cloudy");
                break;
            case 36:
                imageView.setImageResource(R.drawable.a36);
                //textView.setText("Intermittent Clouds");
                break;
            case 37:
                imageView.setImageResource(R.drawable.a37);
                //textView.setText("Hazy Moonlight");
                break;
            case 38:
                imageView.setImageResource(R.drawable.a38);
                //textView.setText("Mostly Cloudy");
                break;
            case 39:
                imageView.setImageResource(R.drawable.a39);
                //textView.setText("Partly Cloudy / Showers");
                break;
            case 40:
                imageView.setImageResource(R.drawable.a40);
                //textView.setText("Mostly Cloudy / Showers");
                break;
            case 41:
                imageView.setImageResource(R.drawable.a41);
                //textView.setText("Partly Cloudy / Thunderstorms");
                break;
            case 42:
                imageView.setImageResource(R.drawable.a42);
                //textView.setText("Mostly Cloudy / Thunderstorms");
                break;
            case 43:
                imageView.setImageResource(R.drawable.a43);
                //textView.setText("Mostly Cloudy / Flurries");
                break;
            case 44:
                imageView.setImageResource(R.drawable.a44);
                //textView.setText("Mostly Cloudy / Snow");
                break;
            default:
                imageView.setImageResource(R.mipmap.ic_launcher);
                //textView.setText(".......");
                break;
        }
    }
}
