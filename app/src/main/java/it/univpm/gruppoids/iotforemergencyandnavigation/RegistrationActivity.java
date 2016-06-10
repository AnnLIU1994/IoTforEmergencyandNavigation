package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class RegistrationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN; // Permette la visualizzazione fullscreen
        decorView.setSystemUiVisibility(uiOptions);
    }
}
