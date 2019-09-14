package com.example.bad.weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Current extends AppCompatActivity {

    IconChoose iconChoose;
    ImageView weather_image;
    ProgressBar p1;
    TextView city_name,state,country,region,temp,degree,weather_text,day_night,date_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current);

        weather_image=(ImageView)findViewById(R.id.weather_icon);
        city_name=(TextView)findViewById(R.id.cityName);
        state=(TextView)findViewById(R.id.state);
        country=(TextView)findViewById(R.id.country);
        region=(TextView)findViewById(R.id.region);
        temp=(TextView)findViewById(R.id.temp);
        degree=(TextView)findViewById(R.id.degree);
        weather_text=(TextView)findViewById(R.id.weather_text);
        day_night=(TextView)findViewById(R.id.day_night);
        date_time=(TextView)findViewById(R.id.date_time);
        p1=(ProgressBar)findViewById(R.id.progressBar);
        degree.setVisibility(View.GONE);

        iconChoose=new IconChoose();

        Intent intent=getIntent();
        String search=intent.getStringExtra("city");

        MyTask myTask=new MyTask(this);
        myTask.execute(search);
    }

    public void startTask(){
        //Toast.makeText(this,"Welcome",Toast.LENGTH_LONG).show();
        p1.setVisibility(View.VISIBLE);
    }
    public void taskFinished(String city_n,String st,String ct,String rn,String tp,String wText,String day_n,String date_t,int pos){
        p1.setVisibility(View.GONE);
        city_name.setText(city_n);
        state.setText(st);
        ct=ct+",";
        country.setText(ct);
        region.setText(rn);
        temp.setText(tp);
        weather_text.setText(wText);
        day_night.setText(day_n);
        date_time.setText(date_t);
        degree.setVisibility(View.VISIBLE);
        iconChoose.selImage(pos,weather_image);
    }

}
