package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ModActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod);
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

    public void goEmerg(View view) {
        Intent intent = new Intent(this, EmergencyActivity.class);
        startActivity(intent);
    }

    public void goFinalPos(View view) {
        Intent intent = new Intent(this, FinalPositionActivity.class);
        startActivity(intent);
    }
}
