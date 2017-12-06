package com.example.benmc.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by benmc on 06/11/2017.
 */

public class doBackgroundRegTask extends AsyncTask<String, String, String> {

    Context context;
    public doBackgroundRegTask(Context context){
        this.context=context.getApplicationContext();

    }
    @Override
    protected String doInBackground(String... params) {

        HttpURLConnection conn = null;;
        URL url;
        try {
            String values= URLEncoder.encode(params[1],"UTF-8");
            url=new URL(params[0]);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

            writer.write("email="+params[1]);
            writer.flush();
            writer.append(" "+params[2]);
            writer.flush();
            writer.close();


            InputStream responseStream = new
                    BufferedInputStream(conn.getInputStream());

            BufferedReader responseStreamReader =
                    new BufferedReader(new InputStreamReader(responseStream));
            String line = "";
            StringBuilder stringBuilder = new StringBuilder();

            while ((line = responseStreamReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            responseStream.close();
            responseStreamReader.close();
            String response = stringBuilder.toString();
            responseStream.close();



            String result = response.toString();
            conn.disconnect();
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result){
        System.out.println(result);
        if(result.contains("logged In")) {
            super.onPostExecute(result);
            context.startActivity(new Intent(context, MainActivity.class));
        }
        if(result.contains("Registered"));{
            super.onPostExecute(result);
            context.startActivity(new Intent(context,LoginActivity.class));
        }

    }



}
