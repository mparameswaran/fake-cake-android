package com.madan.fakecake;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Menu;

/**
 * Created by Madan on 11/24/13.
 */
public class CupcakeBuilder extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cupcake_builder);
        SpannableString s = new SpannableString(getString(R.string.cupcake_builder));
        s.setSpan(new TypefaceSpan(this, "moms_typewriter.ttf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        ActionBar actionBar = getActionBar();
        actionBar.setTitle(s);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.cupcake_builder, menu);
        return true;
    }
}
