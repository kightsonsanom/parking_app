package com.example.asinit_user.parkingapp.mainView.parkingView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asinit_user.parkingapp.R;
import com.example.asinit_user.parkingapp.repository.Repository;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;

public class ParkingSlotsFragment extends Fragment {


    @BindView(R.id.free_slots_tv)
    TextView freeSlotsTv;
    Unbinder unbinder;

    @Inject
    ParkingSlotsPresenter parkingSlotsPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.parking_slots_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        freeSlotsTv.setText(Integer.toString(parkingSlotsPresenter.getParkingSlots()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
