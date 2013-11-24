package com.madan.service;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;


/**
 * Created by Madan on 11/14/13.
 */
public class CakeService extends AsyncTask<String, Void, String>{



    @Override
    protected String doInBackground(String... strings) {
       HttpClient httpClient = new DefaultHttpClient();
       HttpGet httpGet = new HttpGet(strings[0]);
        try{
            HttpResponse response = httpClient.execute(httpGet);
            Log.i("Response Sinatra", response.toString());
            System.out.println(response);
            InputStream inputStream = response.getEntity().getContent();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String bufferedStringChunk = null;
            while ((bufferedStringChunk = bufferedReader.readLine())!=null){
                stringBuilder.append(bufferedStringChunk);
            }

            return stringBuilder.toString();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return "";
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
