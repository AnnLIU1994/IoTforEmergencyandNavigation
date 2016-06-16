package it.univpm.gruppoids.iotforemergencyandnavigation.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;

import it.univpm.gruppoids.iotforemergencyandnavigation.R;

public class CheckUpdatesProgressFragment extends DialogFragment {

    public interface OnProgressDialogListener {

        void taskCancelled();
    }

    private DialogInterface.OnKeyListener mOnKeyListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof TerminateNavigationDialogFragment.AlertDialogListener) {
            final OnProgressDialogListener listener = (OnProgressDialogListener) activity;
            mOnKeyListener = new DialogInterface.OnKeyListener() {
                @Override
                public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        listener.taskCancelled();
                        dialog.dismiss();
                        return true;
                    }
                    return false;
                }
            };
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage(getString(R.string.check_updates));
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setOnKeyListener(mOnKeyListener);
        return progressDialog;
    }
}