package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ModActivity extends AppCompatActivity {

    String initPos;
    int initFloor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        final Intent inputIntent = getIntent();
        if (inputIntent != null) {
            initPos = inputIntent.getStringExtra("initPos");
            initFloor = inputIntent.getIntExtra("initFloor", 0);
            Toast.makeText(getApplicationContext(), "The initial position is " + initPos, Toast.LENGTH_SHORT).show();
            //TODO inserire la posizione passata dal qrCode nella formula di Dikstra
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.firstPage:
                Intent intent = new Intent(this, InitPositionActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                ModActivity.this.finish();
                break;
            case android.R.id.home: // Id relativo alla freccia in alto a sinistra, per tornare alla schermata precedente
                finish();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    public void goEmerg(View view) {
        Intent intent = new Intent(this, EmergencyActivity.class);
        intent.putExtra("initPosEm", initPos);
        startActivity(intent);
    }

    public void goFinalPos(View view) {
        Intent intent = new Intent(this, FinalPositionActivity.class);
        intent.putExtra("initPosNav", initPos);
        intent.putExtra("initFloor", initFloor);
        startActivity(intent);
    }
}
