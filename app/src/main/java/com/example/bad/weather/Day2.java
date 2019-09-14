package com.example.bad.weather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Day2 extends Fragment {

    String[] data={"4","e","2","4"};
    int[] images={16,1};
    IconChoose iconChoose;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        iconChoose=new IconChoose();

        View view=inflater.inflate(R.layout.day1,container,false);
        TextView wt1=(TextView)view.findViewById(R.id.d1w1);
        TextView wt2=(TextView)view.findViewById(R.id.d1w2);
        TextView min=(TextView)view.findViewById(R.id.d1mit);
        TextView max=(TextView)view.findViewById(R.id.d1mat);

        ImageView i1=(ImageView)view.findViewById(R.id.d1image1);
        ImageView i2=(ImageView)view.findViewById(R.id.d1image2);
        Bundle bundle=getArguments();
        if(bundle!=null){
            data=bundle.getStringArray("string");
            iconChoose.selImage(bundle.getInt("one"),i1);
            iconChoose.selImage(bundle.getInt("two"),i2);
            Log.e("mad","Hello "+bundle.getInt("one"));
        }
        wt1.setText(data[0]);
        wt2.setText(data[1]);
        min.setText(data[2]);
        max.setText(data[3]);

        return view;
    }
}
