package com.example.bad.weather;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;

public class MyTask extends AsyncTask<String,String,String[]> {

    String LOC_URL="http://dataservice.accuweather.com/locations/v1/search?apikey=hkpFifmmq9qboaJ7w0sPr1hlGAtyaq1K&q=%s";
    String CURR_URL="http://dataservice.accuweather.com/currentconditions/v1/%s?apikey=hkpFifmmq9qboaJ7w0sPr1hlGAtyaq1K";
    String cityCode,cityName,state,country,region,temp,wText,day_n,date_t,check1,icon;

    Current current;

    public MyTask(Current current){
        this.current=current;
    }

    @Override
    protected String[] doInBackground(String... strings) {
        try {
            URL url1 = new URL(String.format(LOC_URL, strings[0]));
            HttpURLConnection connection1=(HttpURLConnection)url1.openConnection();
            BufferedReader reader1=new BufferedReader(new InputStreamReader(connection1.getInputStream()));
            StringBuffer json1=new StringBuffer();
            String tmp1="";
            while ((tmp1=reader1.readLine())!=null){
                json1.append(tmp1).append("\n");
            }
            reader1.close();

            JSONArray array1=new JSONArray(json1.toString());

            cityCode=array1.getJSONObject(0).getString("Key");
            cityName=array1.getJSONObject(0).getString("EnglishName");
            country=array1.getJSONObject(0).getJSONObject("Country").getString("EnglishName");
            region=array1.getJSONObject(0).getJSONObject("Region").getString("EnglishName");
            state=array1.getJSONObject(0).getJSONObject("AdministrativeArea").getString("EnglishName");

            URL url2=new URL(String.format(CURR_URL,cityCode));
            HttpURLConnection connection2=(HttpURLConnection)url2.openConnection();
            BufferedReader reader2=new BufferedReader(new InputStreamReader(connection2.getInputStream()));
            StringBuffer json2=new StringBuffer();
            String tmp2="";
            while ((tmp2=reader2.readLine())!=null){
                json2.append(tmp2).append("\n");
            }
            reader2.close();

            if(connection2.getResponseCode()==200) {

                JSONArray array2 = new JSONArray(json2.toString());

                wText = array2.getJSONObject(0).getString("WeatherText");
                icon = array2.getJSONObject(0).getString("WeatherIcon");
                temp = array2.getJSONObject(0).getJSONObject("Temperature").getJSONObject("Metric").getString("Value");
                check1 = array2.getJSONObject(0).getString("IsDayTime");
                if (check1 == "false") {
                    day_n = "Night";
                } else {
                    day_n = "Day";
                }
                date_t = DateFormat.getDateTimeInstance().format(new Date());

                String[] sp=temp.split("\\.");
                temp=sp[0];

                String[] Data={cityName,state,country,region,temp,wText,day_n,date_t,icon};

                return Data;
            }
            else
                return null;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPreExecute() {
        current.startTask();
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s[]) {
        current.taskFinished(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],Integer.parseInt(s[8]));

        super.onPostExecute(s);
    }
}
