package com.example.bad.weather;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Hourly extends AppCompatActivity {

    ListView hourList;
    String[] wText,prep,DN,DT,temp;
    int[] icon;
    String action;
    ProgressBar progressBar;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly);

        Intent intent=getIntent();
        String search=intent.getStringExtra("city");

        progressBar=(ProgressBar)findViewById(R.id.progressBar1);
        progressBar.setVisibility(View.VISIBLE);

        actionBar=getSupportActionBar();

        MyTask2 myTask2=new MyTask2(this);
        myTask2.execute(search);

    }
    public void setData(String[] wText,String[] prep,String[] DN,String[] DT,String[] temp,int[] icon,String action){
        this.wText=wText;
        this.prep=prep;
        this.DN=DN;
        this.DT=DT;
        this.temp=temp;
        this.icon=icon;
        this.action=action;

        progressBar.setVisibility(View.GONE);

        actionBar.setTitle(action);
        hourList=(ListView)findViewById(R.id.hourList);
        hourList.setAdapter(new myAdapter1(this,wText,prep,DN,DT,temp,icon));

    }
}


class myAdapter1 extends BaseAdapter{

    class data{

        String WT;
        String PP;
        int IC;
        String DT;
        String DN;
        String TP;

        data(String WT,String PP,int IC,String DT,String DN,String TP){
            this.WT=WT;
            this.PP=PP;
            this.IC=IC;
            this.DN=DN;
            this.DT=DT;
            this.TP=TP;
        }
    }

    ArrayList<data> arrayList;
    Context context;
    IconChoose iconChoose;

    public myAdapter1(Context context,String[] WText,String[] Prep,String[] Dnight,String[] Dtime,String[] Temp,int[] Icon){
        arrayList=new ArrayList<data>();
        this.context=context;
        iconChoose=new IconChoose();
        for(int i=0;i<12;i++){
            data d=new data(WText[i],Prep[i],Icon[i],Dtime[i],Dnight[i],Temp[i]);
            arrayList.add(d);
        }
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1=inflater.inflate(R.layout.single_row,viewGroup,false);

        TextView wt=(TextView)view1.findViewById(R.id.singleWText);
        TextView pp=(TextView)view1.findViewById(R.id.singlePrecp);
        TextView dn=(TextView)view1.findViewById(R.id.singleDN);
        TextView dt=(TextView)view1.findViewById(R.id.singleDT);
        TextView tp=(TextView)view1.findViewById(R.id.singleTemt);
        ImageView ic=(ImageView)view1.findViewById(R.id.singleImage);

        data tem=arrayList.get(i);

        wt.setText(tem.WT);
        pp.setText("Precipitation:"+tem.PP);
        dn.setText("Day Light:"+tem.DN);
        dt.setText(tem.DT);
        tp.setText(tem.TP);
        iconChoose.selImage(tem.IC,ic);

        return view1;
    }
}