package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class FinalPositionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_position);
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

    public void goManualSel(View view) { // Lancia l'intent verso l'InitPositionActivity
        final Intent intent = new Intent(this, ChoosePlanActivity.class);
        startActivity(intent);
    }

    public void goMenuSel(View view) { // Lancia l'intent verso l'InitPositionActivity
        final Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

}
