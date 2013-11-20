package com.madan.fakecake;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.madan.mapping.CupcakeMapping;
import com.madan.model.Cupcake;
import com.madan.service.CakeService;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends Activity {
    List<Cupcake> cupcakes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        SpannableString s = new SpannableString(getString(R.string.cupcake_header));
        s.setSpan(new TypefaceSpan(this, "moms_typewriter.ttf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        ActionBar actionBar = getActionBar();
        actionBar.setTitle(s);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Loading...", Toast.LENGTH_LONG).show();

        CakeService service = new CakeService();
        String jsonResponse = null;

        try {
            jsonResponse = service.execute(getString(R.string.base_url)+"/cake-list").get().toString();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            cupcakes = CupcakeMapping.parse(jsonResponse);
            if (savedInstanceState == null) {
                getFragmentManager().beginTransaction()
                        .add(R.id.container, new PlaceholderFragment(cupcakes))
                        .commit();
            }


        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        
        private List<Cupcake> cupcakes;
        public PlaceholderFragment() {
        }

        public PlaceholderFragment(List<Cupcake> cupcakes) {
            this.cupcakes = cupcakes;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            CupcakeAdapter cupcakeAdapter = new CupcakeAdapter(this.getActivity(), R.layout.cupcake_list_item, cupcakes);
            ListView listView = (ListView) rootView.findViewById(R.id.listview);
            listView.setAdapter(cupcakeAdapter);
            return rootView;
        }
    }

}
