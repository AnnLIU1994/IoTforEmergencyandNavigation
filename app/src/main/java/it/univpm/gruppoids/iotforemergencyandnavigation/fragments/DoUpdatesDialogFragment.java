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

public class DoUpdatesDialogFragment extends DialogFragment {

    public interface AlertDialogListener {
        void yesDoUpdtPressed();
        void noDoUpdtPressed();
    }

    private DialogInterface.OnClickListener mOnClickListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.obsolete_data)
                .setMessage(R.string.question_update_data)
                .setPositiveButton(R.string.yes_label, mOnClickListener)
                .setNegativeButton(R.string.no_label, mOnClickListener);
        AlertDialog alertDialog = builder.create();
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
        if (activity instanceof AlertDialogListener) {
            final AlertDialogListener listener = (AlertDialogListener) activity;
            mOnClickListener = new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case Dialog.BUTTON_POSITIVE:
                            listener.yesDoUpdtPressed();
                            break;
                        case Dialog.BUTTON_NEGATIVE:
                            listener.noDoUpdtPressed();
                            break;
                        default:
                            break;
                    }
                }
            };
        }
    }
}