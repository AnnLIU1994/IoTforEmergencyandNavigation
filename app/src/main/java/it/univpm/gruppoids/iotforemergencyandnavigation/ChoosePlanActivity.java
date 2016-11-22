package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import it.univpm.gruppoids.iotforemergencyandnavigation.model.content.DAO;
import it.univpm.gruppoids.iotforemergencyandnavigation.model.content.IoTDB;
import it.univpm.gruppoids.iotforemergencyandnavigation.model.content.cursor.IoTCursorFactory;


public class ChoosePlanActivity extends AppCompatActivity {

    TextView text;
    //Nodes[] nodes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_plan);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        text = (TextView) findViewById(R.id.test);

        DAO dao = DAO.get(this);
        dao.open();
        Cursor cursor = dao.simpleQuery(null, null);
        //nodes = Nodes.createNodesObj();
        cursor.moveToFirst();
        text.setText(cursor.getString(1));
        dao.close();

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
        intent.putExtra("initFloor", getFloorSelected(view));
        startActivity(intent);
    }
}