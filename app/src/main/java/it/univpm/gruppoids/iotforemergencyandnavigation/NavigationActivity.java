package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import it.univpm.gruppoids.iotforemergencyandnavigation.fragments.TerminateNavigationDialogFragment;

public class NavigationActivity extends AppCompatActivity implements TerminateNavigationDialogFragment.AlertDialogListener {

    private static final String TERMINATE_NAV_DIALOG_TAG = "TERMINATE_NAV_DIALOG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        final Button updateButton = (Button) findViewById(R.id.updatePos);
        updateButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(getApplicationContext(), "Position is updated", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void goInitPos() {
        Intent intent = new Intent(this, InitPositionActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    public void showTerminateNavDialog(View view) {
        TerminateNavigationDialogFragment alertDialog = new TerminateNavigationDialogFragment();
        alertDialog.show(getSupportFragmentManager(), TERMINATE_NAV_DIALOG_TAG);
    }

    @Override
    public void yesPressed() {
        goInitPos();
    }

    @Override
    public void noPressed() {

    }
}
