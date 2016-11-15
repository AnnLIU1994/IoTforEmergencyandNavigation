package it.univpm.gruppoids.iotforemergencyandnavigation;

        import java.io.BufferedReader;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.util.ArrayList;

        import org.apache.http.HttpEntity;
        import org.apache.http.HttpResponse;
        import org.apache.http.NameValuePair;
        import org.apache.http.client.HttpClient;
        import org.apache.http.client.entity.UrlEncodedFormEntity;
        import org.apache.http.client.methods.HttpPost;
        import org.apache.http.impl.client.DefaultHttpClient;
        import org.apache.http.message.BasicNameValuePair;
        import org.apache.http.protocol.HTTP;
        import org.apache.http.util.EntityUtils;
        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import android.app.Activity;
        import android.app.ListActivity;
        import android.net.ParseException;
        import android.os.Bundle;
        import android.os.StrictMode;
        import android.support.v7.app.ActionBar;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.ListView;
        import android.widget.TextView;
        import android.widget.Toast;

public class SelectDB extends AppCompatActivity { /*qualcuno qui ha esteso ad una
ListActivity ma io preferisco gestirmi da me la risposta*/
    JSONArray jArray;
    String result = null;
    InputStream is = null;
    StringBuilder sb=null;
    ListView l;
    String [] place = {"Portineria", "Aula Magna", "Polifunzionale", "Anfiteatro", "Biblioteca", "Centro copie", "Aula Studio"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_php);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        final TextView textviewDariRicevuti = (TextView) findViewById(R.id.datiRicevuti);
        Button buttonInviaDati = (Button) findViewById(R.id.buttonInviaDati);
        buttonInviaDati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//invio richiesta
                textviewDariRicevuti.setText(inviaDati());
            }
        });
    }
    public String inviaDati(){
        String result="";
        String stringaFinale="";
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//Sotto scrivo come si chiama il campo che invio(azione1) e il suo valore (1)
        nameValuePairs.add(new BasicNameValuePair("Stock_name","azione1"));
/*queste due righe di codice che vedete qui sotto sono un piccolo trucchetto per ovviare
 (solo per il momento
 all'eccezione “NetworkOnMainThreadException", questa eccezione è importantissima in quanto
 ci dice che siccome stiamo effettuando una connessione nel thread principale avremo dei
problemi in quanto tutto ciò che riguarda le connessioni o tutto ciò che comporta il
superamento del limite di tempo massimo tra richiesta/risposta superiore a 5secondi la nostra
applicazione Android la metterà in pausa appunto perchè stiamo programmando per uno smartphone
 e non possiamo attendere processi che impegnino per troppo tempo la nostra app. Ricordatevi
 una volta testato tutto, create nella classe i thread e gestite tutto dal thread.*/
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
//http post
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://192.168.43.4/server.php");
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
            result = EntityUtils.toString(entity, HTTP.UTF_8);
        }
        catch(Exception e){
            Log.e("log_tag", "Error in http connection"+e.toString());
        }
//convert response to string
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
            sb = new StringBuilder();
            sb.append(reader.readLine() + "\n");
            String line=null;
            while ((line = reader.readLine()) != null)
            { sb.append(line + "\n");
            }
            is.close();
            result=sb.toString();
        }
        catch(Exception e){
            Log.e("log_tag", "Error converting result "+e.toString());
        }
//paring data

        try{
            jArray = new JSONArray(result);
/*Quando vi dicevo di non inserire commenti nella pagina php era perchè l'app si
 bloccava proprio su questa
riga, in quanto "result" NON comprendeva caratteri json e il parsing non poteva
essere effettuato */
            JSONObject json;
            System.out.println(jArray);
            for(int i=0;i<jArray.length();i++){
                json = jArray.getJSONObject(i);
                Log.i("TEST","Nome: "+json.getString("Nome")+
                        ", Cognome: "+json.getString("Cognome")+
                        ", Email: "+json.getString("Email")+
                        ", Username: "+json.getString("Username")+
                        ", Password: "+json.getString("Password")
                );
                stringaFinale = stringaFinale + json.getString("Nome")+ " "+ json.getString("Cognome")+
                        " "+ json.getString("Email")+
                        " "+ json.getString("Username")+" "+ json.getString("Password")+"\n\n";
            }
        } catch(JSONException e1){
            Toast.makeText(getBaseContext(), "Utente non trovato" ,Toast.LENGTH_LONG).show();
        } catch (ParseException e1) { e1.printStackTrace();
        }


        return stringaFinale;
    }
}



