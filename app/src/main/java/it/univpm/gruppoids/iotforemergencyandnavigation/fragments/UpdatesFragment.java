package it.univpm.gruppoids.iotforemergencyandnavigation.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import it.univpm.gruppoids.iotforemergencyandnavigation.R;

public class UpdatesFragment extends Fragment {

    // TODO dialog fragment, progress fragment

    public static final String TAG = UpdatesFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_updates, container, false);
    }

}
