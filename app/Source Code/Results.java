package com.gctc.saiesh.geethanjali;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Results extends Fragment
{


    private String[] academics =
            {
                    //1st year Autonomous AR16
                    "First Year Results (REGULAR)",

                    //1st year Autonomous AR16
                    "First Year Results (SUPPLY)",

                    //1st year JNTUH R09/13/15
                    "First Year Results (SUPPLY)",
                    "First Year Results (SUPPLY)",
                    "First Year Results (SUPPLY)",

                    //2nd year JNTUH R09/13/15
                    "Second Year Results (REGULAR)",

                    //2nd year JNTUH R09/13/15
                    "Second Year Results (SUPPLY)",
                    "Second Year Results (SUPPLY)",
                    "Second Year Results (SUPPLY)",

                    //3rd year JNTUH R09/13
                    "Third Year Results (REGULAR)",

                    //3rd year JNTUH R09/13
                    "Third Year Results (SUPPLY)",
                    "Third Year Results (SUPPLY)",

                    //4th year JNTUH R09/13
                    "Fourth Year Results (REGULAR)",

                    //4th year supply R09/13
                    "Fourth Year Results (SUPPLY)",
                    "Fourth Year Results (SUPPLY)",
        };

    private String[] regulations =
            {
                    //1st year regular
                    "Autonomous AR-16",

                    //1st year supply
                    "Autonomous AR-16",

                    //1st year supply
                    "JNTUH R09",
                    "JNTUH R13",
                    "JNTUH R15",

                    //2nd year regular
                    "JNTUH R15",

                    //2nd year supply
                    "JNTUH R09",
                    "JNTUH R13",
                    "JNTUH R15",

                    //3rd year regular
                    "JNTUH R13",

                    //3rd year supply
                    "JNTUH R09",
                    "JNTUH R13",

                    //4th year regular
                    "JNTUH R13",

                    //4thyear supply
                    "JNTUH R09",
                    "JNTUH R13"
            };

    int[] images = new int[]
            {
                    R.drawable.r11,
                    R.drawable.r11,
                    R.drawable.r11,
                    R.drawable.r11,
                    R.drawable.r11,
                    R.drawable.r22,
                    R.drawable.r22,
                    R.drawable.r22,
                    R.drawable.r22,
                    R.drawable.r33,
                    R.drawable.r33,
                    R.drawable.r33,
                    R.drawable.r44,
                    R.drawable.r44,
                    R.drawable.r44
            };


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<15;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("txt", "Year : " + academics[i]);
            hm.put("cur","Regulation : " + regulations[i]);
            hm.put("flag", Integer.toString(images[i]) );
            aList.add(hm);
        }
        String[] from = { "flag","txt","cur" };

        int[] to = { R.id.flag,R.id.txt,R.id.cur};

        View v = inflater.inflate(R.layout.rla, container,false);
        ListView list = (ListView)v.findViewById(R.id.listView1);
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.rll, from, to);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {
                // TODO Auto-generated method stub

                if(position == 0)
                {
                    Intent myIntent = new Intent(arg1.getContext(), fyrau.class);
                    startActivityForResult(myIntent,0);

                }

                if(position == 1)
                {
                    Intent myIntent = new Intent(arg1.getContext(), ars.class);
                    startActivityForResult(myIntent,1);


                }

                if (position == 2)
                {
                    Intent myIntent = new Intent(arg1.getContext(), fyjsr.class);
                    startActivityForResult(myIntent, 2);
                    //overridePendingTransition (R.anim.open_next, R.anim.close_main);

                }

                if (position == 3)
                {
                    Intent myIntent = new Intent(arg1.getContext(), fyjsr.class);
                    startActivityForResult(myIntent, 3);
                    //overridePendingTransition (R.anim.open_next, R.anim.close_main);

                }

                if (position == 4)
                {
                    Intent myIntent = new Intent(arg1.getContext(), fyjsr.class);
                    startActivityForResult(myIntent, 4);
                    //overridePendingTransition (R.anim.open_next, R.anim.close_main);

                }

                if (position == 5)
                {
                    Intent myIntent = new Intent(arg1.getContext(), syjr.class);
                    startActivityForResult(myIntent, 5);
                    //overridePendingTransition (R.anim.open_next, R.anim.close_main);

                }

                if (position == 6)
                {
                    Intent myIntent = new Intent(arg1.getContext(), syjs.class);
                    startActivityForResult(myIntent, 6);
                    //overridePendingTransition (R.anim.open_next, R.anim.close_main);

                }

                if (position == 7)
                {
                    Intent myIntent = new Intent(arg1.getContext(), syjs.class);
                    startActivityForResult(myIntent, 7);
                    //overridePendingTransition (R.anim.open_next, R.anim.close_main);

                }

                if (position == 8)
                {
                    Intent myIntent = new Intent(arg1.getContext(), syjs.class);
                    startActivityForResult(myIntent, 8);
                    //overridePendingTransition (R.anim.open_next, R.anim.close_main);

                }

                if (position == 9)
                {
                    Intent myIntent = new Intent(arg1.getContext(), tyjr.class);
                    startActivityForResult(myIntent, 9);
                    //overridePendingTransition (R.anim.open_next, R.anim.close_main);

                }

                if (position == 10)
                {
                    Intent myIntent = new Intent(arg1.getContext(), tyjs.class);
                    startActivityForResult(myIntent, 10);
                    //overridePendingTransition (R.anim.open_next, R.anim.close_main);

                }

                if (position == 11)
                {
                    Intent myIntent = new Intent(arg1.getContext(), tyjs.class);
                    startActivityForResult(myIntent, 11);
                    //overridePendingTransition (R.anim.open_next, R.anim.close_main);

                }

                if (position == 12)
                {
                    Intent myIntent = new Intent(arg1.getContext(), foyjr.class);
                    startActivityForResult(myIntent, 12);
                    //overridePendingTransition (R.anim.open_next, R.anim.close_main);

                }

                if (position == 13)
                {
                    Intent myIntent = new Intent(arg1.getContext(), foyjs.class);
                    startActivityForResult(myIntent, 13);
                    //overridePendingTransition (R.anim.open_next, R.anim.close_main);

                }

                if (position == 14)
                {
                    Intent myIntent = new Intent(arg1.getContext(), foyjs.class);
                    startActivityForResult(myIntent, 14);
                    //overridePendingTransition (R.anim.open_next, R.anim.close_main);

                }

//                String category = academics[position];
//                //You could lookup by position, but "name" is more general
//
//                if (category.equalsIgnoreCase("one"))
//                {
//                    Intent intent = new Intent(ge, fyjsr.class);
//                    startActivity(intent);
//                }


            }
        });
        return v;
    }

}
