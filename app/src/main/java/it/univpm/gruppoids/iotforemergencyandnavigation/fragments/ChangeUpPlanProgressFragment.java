package it.univpm.gruppoids.iotforemergencyandnavigation.fragments;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import it.univpm.gruppoids.iotforemergencyandnavigation.NavigationActivity;
import it.univpm.gruppoids.iotforemergencyandnavigation.R;

/**
 * Created by hew dv67090el on 01/09/2016.
 */
public class ChangeUpPlanProgressFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        String difference = NavigationActivity.differencePlan();
        boolean isUp = NavigationActivity.isGoUp();
        if (isUp) {
            if (difference.equals("2"))
                progressDialog.setMessage(getString(R.string.changePlanGoUp) + " " + difference + " " + getString(R.string.changePlanFloors));
            else
                progressDialog.setMessage(getString(R.string.changePlanGoUp) + " " + difference + " " + getString(R.string.changePlanFloor));
        } else {
            if (difference.equals("2"))
                progressDialog.setMessage(getString(R.string.changePlanGoDown) + " " + difference + " " + getString(R.string.changePlanFloors));
            else
                progressDialog.setMessage(getString(R.string.changePlanGoDown) + " " + difference + " " + getString(R.string.changePlanFloor));
        }

        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }
}
