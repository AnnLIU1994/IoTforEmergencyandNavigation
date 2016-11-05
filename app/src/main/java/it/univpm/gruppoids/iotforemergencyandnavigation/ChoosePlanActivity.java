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


public class ChoosePlanActivity extends AppCompatActivity {

    protected DbAdapter dbAdapter;
    TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_plan);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        dbAdapter = new DbAdapter(this);
        dbAdapter.open();
        Cursor node_cursor = dbAdapter.fetchNodes();
        Cursor user_cursor = dbAdapter.fetchUser();
        Cursor edges_cursor = dbAdapter.fetchEdges();
        //dbAdapter.insertNode("q13ri2", (short)10, (short)12, (short)140, 1.8f, (byte)1, (byte)0);

        test = (TextView) findViewById(R.id.textView);
        test.setText("Node row = " + Integer.toString(node_cursor.getCount()) + " User row = " + Integer.toString(user_cursor.getCount()) + " Edges row = " + Integer.toString(edges_cursor.getCount()));
        dbAdapter.close();

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