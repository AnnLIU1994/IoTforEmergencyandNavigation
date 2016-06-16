package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import it.univpm.gruppoids.iotforemergencyandnavigation.fragments.CheckUpdatesProgressFragment;
import it.univpm.gruppoids.iotforemergencyandnavigation.fragments.ExitDialogFragment;

public class InitPositionActivity extends AppCompatActivity implements ExitDialogFragment.AlertDialogListener, CheckUpdatesProgressFragment.OnProgressDialogListener {

    private static final String TAG = InitPositionActivity.class.getName();

    private static final String EXIT_DIALOG_TAG = "EXIT_DIALOG";

    private static final String CHECK_UPDATES_PROGRESS_TAG = "CHECK_UPDATES_PROGRESS_TAG";


    private Button buttonQr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init_position);

        buttonQr = (Button) this.findViewById(R.id.btnQrCodeScan);
        final Activity activity = this;
        buttonQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrator.setPrompt("...Scanning...");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Log.d(TAG, "Cancelled scan");
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Log.d(TAG, "Scanned");
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                goMod(result.getContents());
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void showExitDialog() {
        ExitDialogFragment alertDialog = new ExitDialogFragment();
        alertDialog.show(getSupportFragmentManager(), EXIT_DIALOG_TAG);
    }

    @Override
    public void onBackPressed() {
        showExitDialog();
    }

    @Override
    public void yesPressed() {
        finish();
    }

    @Override
    public void noPressed() {

    }

    public void showCheckUpdatesProgressFragment() {
        CheckUpdatesProgressFragment alertDialog = new CheckUpdatesProgressFragment();
        alertDialog.show(getSupportFragmentManager(), CHECK_UPDATES_PROGRESS_TAG);
    }

    @Override
    public void taskCancelled() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.guest:
                Intent intent = new Intent(this, GuestActivity.class);
                startActivity(intent);
                break;
            case R.id.updates:
                showCheckUpdatesProgressFragment();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void goManualSel(View view) { // Lancia l'intent verso l'InitPositionActivity
        final Intent intent = new Intent(this, ChoosePlanActivity.class);
        startActivity(intent);
    }

    public void goMenuSel(View view) { // Lancia l'intent verso l'InitPositionActivity
        final Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

    public void goMod(String resultString) {
        Intent intent = new Intent(this, ModActivity.class);
        intent.putExtra("initPos", resultString);
        startActivity(intent);
    }
}
