package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import it.univpm.gruppoids.iotforemergencyandnavigation.fragments.TerminateEmergencyDialogFragment;

public class EmergencyActivity extends AppCompatActivity implements TerminateEmergencyDialogFragment.AlertDialogListener {

    private static final String TERMINATE_EMERG_DIALOG_TAG = "TERMINATE_EMERG_DIALOG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        final Intent inputIntent = getIntent();
        if (inputIntent != null) {
            String initPos = inputIntent.getStringExtra("initPosEm");
            Toast.makeText(getApplicationContext(), "The initial position is " + initPos, Toast.LENGTH_SHORT).show();
            //TODO inserire la posizione passata dal qrCode nella formula di Dikstra
        }

        final Button updateButton = (Button) findViewById(R.id.updatePos);
        if (updateButton != null) {
            updateButton.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    Toast.makeText(getApplicationContext(), "Position is updated", Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
        }
    }

    @Override
    public void yesPressed() {
        goInitPos();
    }

    @Override
    public void noPressed() {

    }

    private void goInitPos() {
        Intent intent = new Intent(this, InitPositionActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        EmergencyActivity.this.finish();
    }

    public void showTerminateEmergDialog(View view) {
        TerminateEmergencyDialogFragment alertDialog = new TerminateEmergencyDialogFragment();
        alertDialog.show(getSupportFragmentManager(), TERMINATE_EMERG_DIALOG_TAG);
    }
}
