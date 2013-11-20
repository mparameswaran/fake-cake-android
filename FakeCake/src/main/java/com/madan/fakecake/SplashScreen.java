package com.madan.fakecake;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import android.os.Handler;
import android.widget.TextView;

import java.util.logging.LogRecord;

/**
 * Created by Madan on 11/20/13.
 */
public class SplashScreen extends Activity {

    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TextView splashTitle = (TextView)this.findViewById(R.id.splash_title);
        Typeface typewriter = Typeface.createFromAsset(getResources().getAssets(), "fonts/moms_typewriter.ttf");
        splashTitle.setTypeface(typewriter);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
