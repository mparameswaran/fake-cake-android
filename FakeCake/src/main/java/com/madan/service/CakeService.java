package com.madan.service;


import android.os.AsyncTask;
import android.util.Log;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import java.io.IOException;


/**
 * Created by Madan on 11/14/13.
 */
public class CakeService extends AsyncTask {
    @Override
    protected Object doInBackground(Object[] objects) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://10.0.2.2/cake-list");
        try{
            HttpResponse response = httpClient.execute(httpGet);
            Log.i("Response",response.toString());
        }
        catch (ClientProtocolException cpe){
            cpe.printStackTrace();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

        return null;
    }
}
