package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import it.univpm.gruppoids.iotforemergencyandnavigation.fragments.ManualFragment;

public class InitPositionActivity extends AppCompatActivity {

    private static final String TAG = InitPositionActivity.class.getName();

    Button btnManSel = (Button) findViewById(R.id.btnManSel);
    Button btnMenSel = (Button) findViewById(R.id.btnMenSel);
    Button qrCodeScan = (Button) findViewById(R.id.btnQrCodeScan);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init_position);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void showFragment(final Button button) {
        final android.support.v4.app.Fragment nextFragment;
        final String buttonString = (String) button.getText();
        switch (buttonString) {
            case "btnManSel":
                /*nextFragment = new ManualFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main, nextFragment)
                        .commit();*/
                Toast.makeText(this, "manSel", Toast.LENGTH_SHORT).show();
                break;
            case "btnMenSel":
                /*nextFragment =
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main, nextFragment)
                        .commit();*/
                Toast.makeText(this, "menSel", Toast.LENGTH_SHORT).show();
                break;
            case "btnQrCodeScan":
                /*nextFragment =
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main, nextFragment)
                        .commit();*/
                Toast.makeText(this, "qrCode", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //android.support.v4.app.Fragment nextFragment;

    /*public void showManSel() {
        nextFragment = new ManualFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.init_position, nextFragment)
                .commit();
    }*/

}
