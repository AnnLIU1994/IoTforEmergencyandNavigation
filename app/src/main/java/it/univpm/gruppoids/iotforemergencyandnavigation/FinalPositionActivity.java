package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class FinalPositionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_position);
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
