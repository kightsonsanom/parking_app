package pl.adbacademy.parkingapp.mainView.usersView;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import pl.adbacademy.parkingapp.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;

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


    public static UsersListFragment newInstance(int initialTabPosition) {
        Bundle args = new Bundle();
        args.putInt("tabPosition", initialTabPosition);
        UsersListFragment fragment = new UsersListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreateView(inflater, container, savedInstanceState);
        tabPosition = getArguments().getInt("tabPosition");
        View view = inflater.inflate(R.layout.users_list_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);

        initTabLayout();

        return view;

    }

    private void initTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setText(R.string.registered_users));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.waiting_for_registration));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        tabPosition = 0;
                        itemsAdapter.clear();
                        itemsAdapter.addAll(usersListPresenter.getRegisteredUserNames());
                        usersListView.setAdapter(itemsAdapter);
                        setOnListClick();
                        break;

                    case 1:
                        tabPosition = 1;
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

        itemsAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                textView.setTextColor(Color.parseColor(getString(R.string.user_color)));
                return textView;
            }
        };

        TabLayout.Tab tab = tabLayout.getTabAt(tabPosition);
        tab.select();

        if (tabPosition == 0){
            itemsAdapter.addAll(usersListPresenter.getRegisteredUserNames());
        } else {
            itemsAdapter.clear();
            itemsAdapter.addAll(usersListPresenter.getUnregisteredUserNames());
        }
        usersListView.setAdapter(itemsAdapter);
        setOnListClick();
    }

    private void setOnListClick() {
        usersListView.setOnItemClickListener((parent, view, position, id) -> usersListPresenter.getUserDetailFragment(getActivity(), position, tabPosition));
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

}
