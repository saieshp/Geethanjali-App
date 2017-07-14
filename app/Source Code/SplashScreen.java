package com.gctc.saiesh.geethanjali;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Chandu on 25-07-2016.
 */
public class SplashScreen extends Activity
{
    int delay = 1500;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //Back Animation
        overridePendingTransition (R.anim.open_next, R.anim.close_main);

        requestWindowFeature(Window.FEATURE_NO_TITLE);// hide statusbar of Android
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.spasc);


        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent i=new Intent(SplashScreen.this, hmo.class);
                startActivity(i);
                finish();
            }
        },delay);

    }
}
