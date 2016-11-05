package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class ListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView l;
    String [] place = {"Portineria", "Aula Magna", "Polifunzionale", "Anfiteatro", "Biblioteca", "Centro copie", "Aula Studio"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        l= (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,R.layout.simple_list_item_1 , place);
        l.setAdapter(adapter);
        l.setOnItemClickListener(this);



        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case android.R.id.home: // Id relativo alla freccia in alto a sinistra, per tornare alla schermata precedente
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            TextView temp = (TextView) view;
            Uri.Builder builder = new Uri.Builder();
            builder.scheme("http")
                   .authority("192.168.43.231") // IP Fabio: 192.168.43.4; IP Simone: 192.168.43.231
                   .path("server.php")//va a vedere nella cartella C/xampp/htdocs
                   .appendQueryParameter("name", "Luca")
                   .appendQueryParameter("surname", "Spalazzi")
                   .appendQueryParameter("email", "ls.it")
                   .appendQueryParameter("user", "luca")
                   .appendQueryParameter("pw", "spalazzi");
            String url=builder.build().toString();
            MyAsyncTask task =new MyAsyncTask();
            task.execute(url);
            System.out.println(url);
            Toast.makeText(this,temp.getText()+""+i,Toast.LENGTH_SHORT).show();
    }
}


