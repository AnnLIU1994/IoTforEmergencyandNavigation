package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ChoosePlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_plan);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String selectedItem = (String) item.getTitle();
        switch (selectedItem) {
            case "Guest":
                Intent intent = new Intent(this, GuestActivity.class);
                startActivity(intent);
                break;
            case "Check updates":
                Toast.makeText(this, "Check updates clicked", Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }

    public void goMap(View view) { // Lancia l'intent verso l'InitPositionActivity
        final Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }

}
