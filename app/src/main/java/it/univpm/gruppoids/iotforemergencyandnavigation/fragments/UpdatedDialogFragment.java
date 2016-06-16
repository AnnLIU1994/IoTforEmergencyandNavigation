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

public class UpdatedDialogFragment extends DialogFragment {

    public interface AlertDialogListener {
        void okPressed();
    }

    private DialogInterface.OnClickListener mOnClickListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.updated)
                .setPositiveButton(R.string.ok_label, mOnClickListener);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        Button buttonPositive = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        buttonPositive.setTextColor(Color.argb(225, 122, 0, 111));
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
                            listener.okPressed();
                            break;
                        default:
                            break;
                    }
                }
            };
        }
    }
}
