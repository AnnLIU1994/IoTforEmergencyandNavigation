package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;

public class SplashActivity extends Activity {

    private static final String TAG_LOG = SplashActivity.class.getName();

    private static final long MIN_WAIT_INTERVAL = 1500L;
    private static final long MAX_WAIT_INTERVAL = 3000L;
    private static final int OK_REG_WHAT = 1;
    private static final int NO_REG_WHAT = 2;

    private long mStartTime; // Definisce il tempo di apertura dell'applicazione in millisecondi
    private boolean mIsDone; // Utilizzato per sapere se il caricamento è stato effettuato

    private Handler mHandler = new Handler() { // Permette la gestione dell'activity

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case OK_REG_WHAT:
                    long elapsedTime = SystemClock.uptimeMillis() - mStartTime;
                    if (elapsedTime >= MIN_WAIT_INTERVAL && !mIsDone) {
                        mIsDone = true;
                        goInitPos();
                    }
                    break;
                /*case NO_REG_WHAT:
                    // TODO inserire condizione per passare alla registration activity
                    goRegistration();
                    break;*/
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN; // Permette la visualizzazione fullscreen
        decorView.setSystemUiVisibility(uiOptions);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mStartTime = SystemClock.uptimeMillis();
        final Message goMainMessage = mHandler.obtainMessage(OK_REG_WHAT);
        // Invia il messaggio OK_REG_WHAT quando sono passati MAX_WAIT_INTERVAL millisecondi
        mHandler.sendMessageAtTime(goMainMessage, mStartTime + MAX_WAIT_INTERVAL);
    }

    /*@Override
    protected void onRestart() {
        super.onRestart();
        goInitPos(); // Al restart non viene visualizzata la SplashActivity
    }*/

    private void goInitPos() { // Lancia l'intent verso l'InitPositionActivity
        final Intent intent = new Intent(this, InitPositionActivity.class);
        startActivity(intent);
        finish();
    }

    /*public void goRegistration() { // Lancia l'intent verso la RegistrationActivity
        final Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
        finish();
    }*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null); // Serve per bloccare la visualizzazione della InitPositionActivity una volta chiusa la splash
    }
}
