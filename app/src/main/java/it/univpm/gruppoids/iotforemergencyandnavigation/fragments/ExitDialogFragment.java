package it.univpm.gruppoids.iotforemergencyandnavigation.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import it.univpm.gruppoids.iotforemergencyandnavigation.R;

public class ExitDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.exit_dialog)
                .setPositiveButton(R.string.yes_label, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //esci dall'app
                    }
                })
                .setNegativeButton(R.string.no_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //cancella il dialog
                    }
                });
        return builder.create();
    }
}
