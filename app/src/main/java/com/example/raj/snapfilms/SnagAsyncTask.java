package com.example.raj.snapfilms;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import com.example.raj.snapfilms.models.Films;
import com.example.raj.snapfilms.models.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by q5K66HNS on 7/17/2018.
 */

public class SnagAsyncTask extends AsyncTask<Void,Void,Films> {

    int status;
    private Activity activity;
SnagAsyncTask(Activity activity){
    this.activity = activity;
}
    private static final String snagUrl = "http://www.snagfilms.com/apis/films.json?limit=10";
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected Films doInBackground(Void... voids) {
        Films films = null;
        try {
            URL url = new URL(snagUrl);
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(3000);
                 status = httpURLConnection.getResponseCode();
                Log.d("responseCode", String.valueOf(status));
                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String data = "";
                 StringBuilder stringBuilder = new StringBuilder();
                while ((data = bufferedReader.readLine()) != null){
                    stringBuilder.append(data).append("\n");
                }
                JSONObject jsonObject = new JSONObject(stringBuilder.toString());
                films = Response.getAllFilms(jsonObject);

                Log.d("responsee", stringBuilder.toString());
            } catch (IOException e) {
                e.printStackTrace();
                Log.d("responseCode", String.valueOf(status));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return films;
    }

    @Override
    protected void onPostExecute(Films films) {
        super.onPostExecute(films);

        if(activity instanceof MainActivity){
            ((MainActivity) activity).showAllDetails(films);
        }
        Log.d("1234", films.toString());
    }
}
