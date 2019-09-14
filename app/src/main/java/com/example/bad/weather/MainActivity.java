package com.example.bad.weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText city;
    Button current,hourly,day;
    String cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city=(EditText) findViewById(R.id.city);

        current=(Button)findViewById(R.id.current);
        hourly=(Button)findViewById(R.id.hourly);
        day=(Button)findViewById(R.id.day);

        current.setOnClickListener(this);
        hourly.setOnClickListener(this);
        day.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        cityName=city.getText().toString();

        switch (view.getId()){
            case R.id.current:
                Intent currentIntent=new Intent(MainActivity.this,Current.class);
                currentIntent.putExtra("city",cityName);
                startActivity(currentIntent);
                break;
            case R.id.hourly:
                Intent hourly=new Intent(MainActivity.this,Hourly.class);
                hourly.putExtra("city",cityName);
                startActivity(hourly);
                break;
            case R.id.day:
                Intent day=new Intent(MainActivity.this,Day.class);
                day.putExtra("city",cityName);
                startActivity(day);
                break;
        }
    }
}
