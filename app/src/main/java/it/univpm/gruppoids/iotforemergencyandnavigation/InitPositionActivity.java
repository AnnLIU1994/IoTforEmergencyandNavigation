package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class InitPositionActivity extends AppCompatActivity {

    private static final String TAG = InitPositionActivity.class.getName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init_position);
    }

    public void goManualSel(View view) { // Lancia l'intent verso l'InitPositionActivity
        final Intent intent = new Intent(this, ChoosePlanActivity.class);
        startActivity(intent);
    }

    public void goMenuSel(View view) { // Lancia l'intent verso l'InitPositionActivity
        final Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

    public void goQrScan(View view) { // Lancia l'intent verso l'InitPositionActivity
        final Intent intent = new Intent(this, QrActivity.class);
        startActivity(intent);
    }
}
