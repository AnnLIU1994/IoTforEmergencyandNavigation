package it.univpm.gruppoids.iotforemergencyandnavigation.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import it.univpm.gruppoids.iotforemergencyandnavigation.R;

public class TerminateNavigationDialogFragment extends DialogFragment {

    public interface AlertDialogListener {
        void yesPressed();
        void noPressed();
    }

    private DialogInterface.OnClickListener mOnClickListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.are_sure)
                .setMessage(R.string.terminate_nav_dialog)
                .setPositiveButton(R.string.yes_label, mOnClickListener)
                .setNegativeButton(R.string.no_label, mOnClickListener);
        return builder.create();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof AlertDialogListener) {
            final AlertDialogListener listener = (AlertDialogListener) activity;
            mOnClickListener = new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case Dialog.BUTTON_POSITIVE:
                            listener.yesPressed();
                            break;
                        case Dialog.BUTTON_NEGATIVE:
                            listener.noPressed();
                            break;
                        default:
                            break;
                    }
                }
            };
        }
    }
}

