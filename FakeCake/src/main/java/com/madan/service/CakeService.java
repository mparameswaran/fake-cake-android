package com.madan.service;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import com.madan.fakecake.MainActivity;
import com.madan.fakecake.R;

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

    private MainActivity activity;
    private static ProgressDialog progressDialog;
    private int statusCode;

    public CakeService(MainActivity mainActivity) {

        this.activity = mainActivity;
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle(getActivity().getString(R.string.loading));
        progressDialog.setMessage(getActivity().getString(R.string.fetching_cupcakes));
    }

    @Override
    protected String doInBackground(String... strings) {
       HttpClient httpClient = new DefaultHttpClient();
       HttpGet httpGet = new HttpGet(strings[0]);
        try{
            HttpResponse response = httpClient.execute(httpGet);
            InputStream inputStream = response.getEntity().getContent();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String bufferedStringChunk = null;
            while ((bufferedStringChunk = bufferedReader.readLine())!=null){
                stringBuilder.append(bufferedStringChunk);
            }
            setStatusCode(response.getStatusLine().getStatusCode());
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
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        progressDialog.dismiss();
        getActivity().showList(getStatusCode(), s);
    }

    public MainActivity getActivity() {
        return activity;
    }

    public void setActivity(MainActivity activity) {
        this.activity = activity;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
