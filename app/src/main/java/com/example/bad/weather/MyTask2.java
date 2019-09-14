package com.example.bad.weather;

import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyTask2 extends AsyncTask<String,String,String> {

    String LOC_URL="http://dataservice.accuweather.com/locations/v1/search?apikey=1sLYmNSbiisg9Wr11BRGMGJMCsy4gLcy&q=%s";
    String HOUR_URL="http://dataservice.accuweather.com/forecasts/v1/hourly/12hour/%s?apikey=1sLYmNSbiisg9Wr11BRGMGJMCsy4gLcy";
    Hourly hourly;
    String[] wText={"","","","","","","","","","","",""},prep={"","","","","","","","","","","",""},DN={"","","","","","","","","","","",""},DT={"","","","","","","","","","","",""},temp={"","","","","","","","","","","",""};
    int[] icon={1,1,1,1,1,1,1,1,1,1,1,1};
    String cityCode;
    String action;

    public MyTask2(Hourly hourly){
        this.hourly=hourly;
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

            URL url2=new URL(String.format(HOUR_URL,cityCode));
            HttpURLConnection connection2=(HttpURLConnection)url2.openConnection();
            BufferedReader reader2=new BufferedReader(new InputStreamReader(connection2.getInputStream()));
            StringBuffer json2=new StringBuffer();
            String tmp2="";
            while ((tmp2=reader2.readLine())!=null){
                json2.append(tmp2).append("\n");
            }
            reader2.close();

            JSONArray array2 = new JSONArray(json2.toString());

            for(int i=0;i<12;i++){
                wText[i]=array2.getJSONObject(i).getString("IconPhrase");
                prep[i]=array2.getJSONObject(i).getString("PrecipitationProbability");
                String day=array2.getJSONObject(i).getString("IsDaylight");
                if(day=="false")
                    DN[i]="No";
                else
                    DN[i]="Yes";

                //2017-07-04T04:00:00+05:30

                String date=array2.getJSONObject(i).getString("DateTime");

                String da=date.substring(0,10);
                String ti=date.substring(11,16);

                DT[i]=da+"   "+ti;
                int t=Integer.parseInt(array2.getJSONObject(i).getJSONObject("Temperature").getString("Value").split("\\.")[0]);
                t=(int)((t-32)/1.8);

                temp[i]=String.valueOf(t);
                icon[i]=Integer.parseInt(array2.getJSONObject(i).getString("WeatherIcon"));
            }

            return "OK";
        }
        catch (Exception e){
            e.printStackTrace();
            return "NO";
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String strings) {
        if (strings=="OK")
            hourly.setData(wText,prep,DN,DT,temp,icon,action);
        else
            Toast.makeText(hourly,"Error",Toast.LENGTH_LONG).show();
        super.onPostExecute(strings);
    }
}
