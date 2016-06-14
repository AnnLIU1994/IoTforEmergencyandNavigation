package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ChoosePlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_plan);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.guest:
                Intent intent = new Intent(this, GuestActivity.class);
                startActivity(intent);
                break;
            case R.id.updates:
                Toast.makeText(this, "Check updates clicked", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home: // Id relativo alla freccia in alto a sinistra, per tornare alla schermata precedente
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private int getFloorSelected(View button) {
        switch (button.getId()) {
            case R.id.btn145:
                return 145;
            case R.id.btn150:
                return 150;
            case R.id.btn155:
                return 155;
            default:
                return 0;
        }
    }

    public void goMap(View view) { // Lancia l'intent verso l'InitPositionActivity
        final Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra("floor", getFloorSelected(view));
        startActivity(intent);
    }

}
