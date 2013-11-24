package com.madan.fakecake;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.widget.ImageView;

import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;

/**
 * Created by Madan on 11/20/13.
 */
public class ProductDetail extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        Intent intent = getIntent();
        SpannableString s = new SpannableString(intent.getStringExtra("name"));
        s.setSpan(new TypefaceSpan(this, "moms_typewriter.ttf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        ActionBar actionBar = getActionBar();
        actionBar.setTitle(s);
        String baseUrl = getString(R.string.base_url);
        UrlImageViewHelper.setUrlDrawable((ImageView)findViewById(R.id.product_image), baseUrl+intent.getStringExtra("image"));
    }
}
