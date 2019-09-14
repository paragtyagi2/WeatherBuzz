package com.example.bad.weather;

import android.os.AsyncTask;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Task3 extends AsyncTask<String,String,String> {

    Day day;

    String[] d={"","","","",""}; //date of the five days
    String[] d1={"","","",""};  //data for day 1
    String[] d2={"","","",""};  //data for day 2
    String[] d3={"","","",""};  //data for day 3
    String[] d4={"","","",""};  //data for day 4
    String[] d5={"","","",""};  //data for day 5
    int[] dd1={1,1};
    int[] dd2={1,1};
    int[] dd3={1,1};
    int[] dd4={1,1};
    int[] dd5={1,1};

    String LOC_URL="http://dataservice.accuweather.com/locations/v1/search?apikey=ADOv2ADqeT3nTlS8UmzAiufG1G0GtpvB&q=%s";
    String DAY_URL="http://dataservice.accuweather.com/forecasts/v1/daily/5day/%s?apikey=ADOv2ADqeT3nTlS8UmzAiufG1G0GtpvB&metric=true";
    String cityCode,action;

    public Task3(Day day) {
        this.day=day;
    }

    @Override
    protected String doInBackground(String... strings) {
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
            action=array1.getJSONObject(0).getString("EnglishName");

            URL url2=new URL(String.format(DAY_URL,cityCode));
            HttpURLConnection connection2=(HttpURLConnection)url2.openConnection();
            BufferedReader reader2=new BufferedReader(new InputStreamReader(connection2.getInputStream()));
            StringBuffer json2=new StringBuffer();
            String tmp2="";
            while ((tmp2=reader2.readLine())!=null){
                json2.append(tmp2).append("\n");
            }
            reader2.close();

            JSONObject object=new JSONObject(json2.toString());
            JSONArray array=object.getJSONArray("DailyForecasts");

            for(int i=0;i<5;i++) {
                JSONObject object1 = array.getJSONObject(i);
                d[i]=object1.getString("Date").substring(0,10);
                int icon1=Integer.parseInt(object1.getJSONObject("Day").getString("Icon"));
                String wt1=object1.getJSONObject("Day").getString("IconPhrase");
                int icon2=Integer.parseInt(object1.getJSONObject("Night").getString("Icon"));
                String wt2=object1.getJSONObject("Night").getString("IconPhrase");
                String max=object1.getJSONObject("Temperature").getJSONObject("Maximum").getString("Value").split("\\.")[0];
                String min=object1.getJSONObject("Temperature").getJSONObject("Minimum").getString("Value").split("\\.")[0];

                if(i==0){
                    d1[0]=wt1;
                    d1[1]=wt2;
                    d1[2]=min;
                    d1[3]=max;

                    dd1[0]=icon1;
                    dd1[1]=icon2;
                }
                if(i==1){
                    d2[0]=wt1;
                    d2[1]=wt2;
                    d2[2]=min;
                    d2[3]=max;

                    dd2[0]=icon1;
                    dd2[1]=icon2;
                }
                if(i==2){
                    d3[0]=wt1;
                    d3[1]=wt2;
                    d3[2]=min;
                    d3[3]=max;

                    dd3[0]=icon1;
                    dd4[1]=icon2;
                }
                if(i==3){
                    d4[0]=wt1;
                    d4[1]=wt2;
                    d4[2]=min;
                    d4[3]=max;

                    dd4[0]=icon1;
                    dd4[1]=icon2;
                }
                if(i==4){
                    d5[0]=wt1;
                    d5[1]=wt2;
                    d5[2]=min;
                    d5[3]=max;

                    dd5[0]=icon1;
                    dd5[1]=icon2;
                }
            }

            return "OK";
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        day.setDate(d,d1,d2,d3,d4,d5,dd1,dd2,dd3,dd4,dd5,action);
    }
}
