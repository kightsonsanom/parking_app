package com.example.asinit_user.parkingapp.mainView.usersView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.asinit_user.parkingapp.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;
import timber.log.Timber;

public class UsersListFragment extends Fragment {


    @Inject
    UsersListPresenter usersListPresenter;
    @BindView(R.id.users_list_view)
    ListView usersListView;
    Unbinder unbinder;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    private ArrayAdapter<String> itemsAdapter;

    private int tabPosition;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.users_list_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);


        initTabLayout();



        return view;

    }

    private void initTabLayout() {

        tabLayout.addTab(tabLayout.newTab().setText("Zarejestrowani"));
        tabLayout.addTab(tabLayout.newTab().setText("Oczekujący"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Timber.d("tab position = " + tab.getPosition());
                switch (tab.getPosition()) {
                    case 0:
                        itemsAdapter.clear();
                        itemsAdapter.addAll(usersListPresenter.getRegisteredUserNames());
                        usersListView.setAdapter(itemsAdapter);
                        setOnListClick();
                        break;

                    case 1:
                        itemsAdapter.clear();
                        itemsAdapter.addAll(usersListPresenter.getUnregisteredUserNames());
                        usersListView.setAdapter(itemsAdapter);
                        setOnListClick();
                        break;
                    default:
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        itemsAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1);
        if (savedInstanceState != null) {
            tabPosition = savedInstanceState.getInt("tabPosition");
        } else {
            tabPosition = 0;
        }

        if (tabPosition == 0){
            itemsAdapter.addAll(usersListPresenter.getRegisteredUserNames());
        } else {
            itemsAdapter.addAll(usersListPresenter.getUnregisteredUserNames());
        }


        usersListView.setAdapter(itemsAdapter);

        setOnListClick();




    }

    private void setOnListClick() {
        usersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Timber.d("clicked on " + position + " item");
                usersListPresenter.getUserDetailFragment(getActivity(), position);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public String toString() {
        return "UsersListFragment";
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("tabPosition", tabLayout.getSelectedTabPosition());
        super.onSaveInstanceState(outState);
    }
}
