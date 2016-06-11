package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ModActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod);
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
