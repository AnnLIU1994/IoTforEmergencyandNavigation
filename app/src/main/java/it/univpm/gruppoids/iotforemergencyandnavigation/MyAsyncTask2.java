package it.univpm.gruppoids.iotforemergencyandnavigation;

import java.io.InputStream;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.net.ParseException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


public class MyAsyncTask2 extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        HttpGetTask task = new HttpGetTask();
        task.execute("http://192.168.43.4/server.php");
    }

    private class HttpGetTask extends AsyncTask<String,String,String> {

        @Override
        protected String doInBackground(String... urls) {
            String result = null;
            InputStream is = null;
            StringBuilder sb=null;


            //http post
            try{
                HttpClient httpclient = new DefaultHttpClient();
                HttpGet httpGet = new HttpGet(String.valueOf(urls[0]));
                List<? extends NameValuePair> nameValuePairs = null;
            }catch(Exception e){
                Log.e("log_tag", "Errore nella connessione http"+e.toString());
            }

            //paring data
            String fd_id;
            String fd_name;
            try{
                JSONArray jArray = new JSONArray(result);
                JSONObject json_data=null;

                for(int i=0;i<jArray.length();i++){
                    json_data = jArray.getJSONObject(i);
                    fd_id=json_data.getString("Nome");
                    fd_name=json_data.getString("Cognome");
                }
                System.out.print(jArray);

            }catch(JSONException e1){
                Toast.makeText(getBaseContext(), "No Food Found", Toast.LENGTH_LONG).show();
            }catch (ParseException e1){
                e1.printStackTrace();
            }

            return null;
        }


    }

}