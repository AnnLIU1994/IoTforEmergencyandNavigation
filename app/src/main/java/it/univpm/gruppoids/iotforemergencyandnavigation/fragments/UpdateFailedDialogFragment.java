package it.univpm.gruppoids.iotforemergencyandnavigation.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Button;

import it.univpm.gruppoids.iotforemergencyandnavigation.R;

public class UpdateFailedDialogFragment extends DialogFragment {

    public interface UpdatesFailedDialogListener {
        void cancelPressed();
        void tryAgainPressed();
    }

    private DialogInterface.OnClickListener mOnClickListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.caution)
                .setMessage(R.string.updates_failed_dialog)
                .setPositiveButton(R.string.try_again_label, mOnClickListener)
                .setNegativeButton(R.string.cancel_label, mOnClickListener);
        AlertDialog alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();

        Button buttonPositive = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        buttonPositive.setTextColor(Color.argb(225, 122, 0, 111));

        Button buttonNegative = alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
        buttonNegative.setTextColor(Color.argb(225, 122, 0, 111));
        return alertDialog;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof UpdatesFailedDialogListener) {
            final UpdatesFailedDialogListener listener = (UpdatesFailedDialogListener) activity;
            mOnClickListener = new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case Dialog.BUTTON_POSITIVE:
                            listener.tryAgainPressed();
                            break;
                        case Dialog.BUTTON_NEGATIVE:
                            listener.cancelPressed();
                            break;
                        default:
                            break;
                    }
                }
            };
        }
    }
}
