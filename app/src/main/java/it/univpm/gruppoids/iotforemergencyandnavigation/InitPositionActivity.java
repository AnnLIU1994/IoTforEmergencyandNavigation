package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import it.univpm.gruppoids.iotforemergencyandnavigation.fragments.CheckUpdatesProgressFragment;
import it.univpm.gruppoids.iotforemergencyandnavigation.fragments.DoUpdatesDialogFragment;
import it.univpm.gruppoids.iotforemergencyandnavigation.fragments.ExitDialogFragment;
import it.univpm.gruppoids.iotforemergencyandnavigation.fragments.UpdatedDialogFragment;
import it.univpm.gruppoids.iotforemergencyandnavigation.fragments.UpdateFailedDialogFragment;
import it.univpm.gruppoids.iotforemergencyandnavigation.fragments.UpdatingDialogFragment;
import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;

public class InitPositionActivity extends AppCompatActivity
        implements ExitDialogFragment.AlertDialogListener, CheckUpdatesProgressFragment.OnProgressDialogListener,
        UpdatedDialogFragment.AlertDialogListener, DoUpdatesDialogFragment.AlertDialogListener, UpdatingDialogFragment.UpdatingDialogListener, UpdateFailedDialogFragment.UpdatesFailedDialogListener {

    private static final String TAG = InitPositionActivity.class.getName();

    private static final String EXIT_DIALOG_TAG = "EXIT_DIALOG";

    private static final String CHECK_UPDATES_PROGRESS_TAG = "CHECK_UPDATES_PROGRESS";

    private static final String UPDATED_DIALOG_TAG = "UPDATED_DIALOG";

    private static final String DO_UPDATES_DIALOG_TAG = "DO_UPDATES_DIALOG";

    private static final String UPDATING_DIALOG_TAG = "UPDATING_DIALOG";

    private static final String UPDATE_FAILED_DIALOG_TAG = "UPDATE_FAILED_DIALOG";

    private static final int SI_UPDATES_WHAT = 1;
    private static final int NO_UPDATES_WHAT = 2;
    private static final long WAIT_INTERVAL = 3000L;

    private long mStartTime;

    private CheckUpdatesProgressFragment progressCheckDialog;


    private Button buttonQr;

    protected DbAdapter dbAdapter;

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

        SQLiteStudioService.instance().start(this);
        dbAdapter = new DbAdapter(this);
        dbAdapter.open();
        Cursor nodes = dbAdapter.fetchNodes();
        dbAdapter.close();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Log.d(TAG, "Cancelled scan");
                Toast.makeText(this, "Scan cancelled", Toast.LENGTH_LONG).show();
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
        ExitDialogFragment alertExitDialog = new ExitDialogFragment();
        alertExitDialog.show(getSupportFragmentManager(), EXIT_DIALOG_TAG);
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
        mStartTime = SystemClock.uptimeMillis();
        progressCheckDialog = new CheckUpdatesProgressFragment();
        progressCheckDialog.show(getSupportFragmentManager(), CHECK_UPDATES_PROGRESS_TAG);
        // TODO impostare l'invio del messaggio dopo aver controllato la presenza degli aggiornamenti
        final Message goMainMessage = mHandler.obtainMessage(NO_UPDATES_WHAT);
        mHandler.sendMessageAtTime(goMainMessage, mStartTime + WAIT_INTERVAL);

    }

    @Override
    public void taskCancelled() {
        // TODO fare in modo che il DoUpdatesDialogFragment non venga visualizzato all'uscita dal progress dialog
    }

    private Handler mHandler = new Handler() { // Permette la gestione dell'activity

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case NO_UPDATES_WHAT:
                    long elapsedTime = SystemClock.uptimeMillis() - mStartTime;
                    if (elapsedTime >= WAIT_INTERVAL) { // && !mIsDone TODO Aggiungere mIsDone per controllare la presenza di aggiornamenti
                        //mIsDone = true;
                        showDoUpdatesDialogFragment();
                        progressCheckDialog.dismiss();
                    }
                    break;
            }
        }
    };

    public void showUpdatedDialogFragment() { // TODO visualizzare quando l'app è aggiornata
        UpdatedDialogFragment alertUpdatedDialog = new UpdatedDialogFragment();
        alertUpdatedDialog.show(getSupportFragmentManager(), UPDATED_DIALOG_TAG);
    }

    @Override
    public void okPressed() {

    }

    public void showDoUpdatesDialogFragment() {
        DoUpdatesDialogFragment alertDoUpdatesDialog = new DoUpdatesDialogFragment();
        alertDoUpdatesDialog.show(getSupportFragmentManager(), DO_UPDATES_DIALOG_TAG);
    }

    @Override
    public void yesDoUpdtPressed() {
        showUpdatingDialogFragment();
    }

    @Override
    public void noDoUpdtPressed() {

    }

    public void showUpdatingDialogFragment() {
        UpdatingDialogFragment alertUpdatingDialog = new UpdatingDialogFragment();
        alertUpdatingDialog.show(getSupportFragmentManager(), UPDATING_DIALOG_TAG);
    }

    @Override
    public void cancelUpdatingPressed() {
        showUpdateFailedDialogFragment();
    }

    public void showUpdateFailedDialogFragment() {
        UpdateFailedDialogFragment alertUpdateFailedDialog = new UpdateFailedDialogFragment();
        alertUpdateFailedDialog.show(getSupportFragmentManager(), UPDATE_FAILED_DIALOG_TAG);
    }

    @Override
    public void cancelPressed() {

    }

    @Override
    public void tryAgainPressed() {
        showUpdatingDialogFragment();
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SQLiteStudioService.instance().stop();
    }
}