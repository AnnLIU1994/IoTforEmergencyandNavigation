package it.univpm.gruppoids.iotforemergencyandnavigation;


import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
/**
 * Created by FABIO on 16/12/2015.
 */
class MyAsyncTask extends AsyncTask<String, Void, Void> {

    @Override
    protected Void doInBackground(String... urls) {
        // TODO Auto-generated method stub
        StringBuilder builder = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(String.valueOf(urls[0]));
        try {
            HttpResponse response = client.execute(httpGet);
        } catch(Exception e) {
            Log.e("log_tag", "Error in http connection " + e.toString());
        }
        return null;
    }


}

