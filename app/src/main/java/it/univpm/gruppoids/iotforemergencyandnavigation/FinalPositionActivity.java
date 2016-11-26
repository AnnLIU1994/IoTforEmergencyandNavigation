package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class FinalPositionActivity extends AppCompatActivity {

    String initPos;
    int initFloor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_position);

        final Intent inputIntent = getIntent();
        if (inputIntent != null) {
            initPos = inputIntent.getStringExtra("initPosNav");
            initFloor = inputIntent.getIntExtra("initFloor", 0);
            Toast.makeText(getApplicationContext(), "The initial position is " + initPos + " at " + initFloor + " floor.", Toast.LENGTH_SHORT).show();
            //TODO inserire la posizione passata dal qrCode nella formula di Dikstra
        }

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
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
                FinalPositionActivity.this.finish();
                break;
            case android.R.id.home: // Id relativo alla freccia in alto a sinistra, per tornare alla schermata precedente
                NavUtils.navigateUpFromSameTask(this);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    public void goFinalManualSel(View view) { // Lancia l'intent verso l'InitPositionActivity
        final Intent intent = new Intent(this, ChooseFinalPlanActivity.class);
        intent.putExtra("initPosManual", initPos);
        intent.putExtra("initFloor", initFloor);
        startActivity(intent);
    }

    public void goFinalMenuSel(View view) { // Lancia l'intent verso l'InitPositionActivity
        final Intent intent = new Intent(this, ListFinalActivity.class);
        intent.putExtra("initPosMenu", initPos);
        intent.putExtra("initFloor", initFloor);
        startActivity(intent);
    }

}
