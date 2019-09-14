package com.example.bad.weather;

import android.content.Intent;
import android.os.Binder;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;

public class Day extends AppCompatActivity {

    ViewPager pager;
    PagerTitleStrip titleStrip;
    String[] dateList={"w","","","d","d"};
    String[] d1={"","","",""};
    String[] d2={"","","",""};
    String[] d3={"","","",""};
    String[] d4={"","","",""};
    String[] d5={"","","",""};
    int[] dd1={1,1};
    int[] dd2={1,1};
    int[] dd3={1,1};
    int[] dd4={1,1};
    int[] dd5={1,1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress);

        Intent intent=getIntent();
        String search=intent.getStringExtra("city");

        Task3 task3=new Task3(this);
        task3.execute(search);
    }
    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
             Fragment fragment=null;
            switch (position){
                case 0:
                    fragment=new Day1();
                    Bundle bundle=new Bundle();
                    bundle.putStringArray("string",d1);
                    bundle.putInt("one",dd1[0]);
                    bundle.putInt("two",dd1[1]);
                    fragment.setArguments(bundle);
                    break;
                case 1:
                    fragment=new Day2();
                    Bundle bundle1=new Bundle();
                    bundle1.putStringArray("string",d2);
                    bundle1.putInt("one",dd2[0]);
                    bundle1.putInt("two",dd2[1]);
                    fragment.setArguments(bundle1);
                    break;
                case 2:
                    fragment=new Day3();
                    Bundle bundle2=new Bundle();
                    bundle2.putStringArray("string",d3);
                    bundle2.putInt("one",dd3[0]);
                    bundle2.putInt("two",dd3[1]);
                    fragment.setArguments(bundle2);
                    break;
                case 3:
                    fragment=new Day4();
                    Bundle bundle3=new Bundle();
                    bundle3.putStringArray("string",d4);
                    bundle3.putInt("one",dd4[0]);
                    bundle3.putInt("two",dd4[1]);
                    fragment.setArguments(bundle3);
                    break;
                case 4:
                    fragment=new Day5();
                    Bundle bundle4=new Bundle();
                    bundle4.putStringArray("string",d5);
                    bundle4.putInt("one",dd5[0]);
                    bundle4.putInt("two",dd5[1]);
                    fragment.setArguments(bundle4);
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return dateList[position];
        }
    }
    public void setDate(String[] date,String[] d1,String[] d2,String[] d3,String[] d4,String[] d5,int[] dd1,int[] dd2,int[] dd3,int[] dd4,int[] dd5,String action){
        this.dateList=date;
        this.d1=d1;
        this.d2=d2;
        this.d3=d3;
        this.d4=d4;
        this.d5=d5;
        this.dd1=dd1;
        this.dd2=dd2;
        this.dd3=dd3;
        this.dd4=dd4;
        this.dd5=dd5;
        getSupportActionBar().setTitle(action);

        setContentView(R.layout.activity_day);
        titleStrip=(PagerTitleStrip)findViewById(R.id.title);
        titleStrip.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);

        pager=(ViewPager)findViewById(R.id.pager);
        pager.setAdapter(new MyAdapter(getSupportFragmentManager()));
    }
}
