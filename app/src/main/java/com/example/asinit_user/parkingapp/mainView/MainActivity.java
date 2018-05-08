package com.example.asinit_user.parkingapp.mainView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.asinit_user.parkingapp.R;
import com.example.asinit_user.parkingapp.mainView.parkingView.ParkingSlotsFragment;
import com.example.asinit_user.parkingapp.mainView.usersView.UserDetailsFragment;
import com.example.asinit_user.parkingapp.mainView.usersView.UsersListFragment;
import com.example.asinit_user.parkingapp.model.User;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private int pagerPosition;
    private Fragment userFragment;


    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(mSectionsPagerAdapter);
        userFragment = new UsersListFragment();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pagerPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (pagerPosition == 1 && userFragment.toString().equals("UserDetailsFragment")) {
            userFragment = new UsersListFragment();
            mSectionsPagerAdapter.notifyDataSetChanged();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

    public void enterDetailFragment(User user) {
        Timber.d("enterDetailFragment from MainActivity");
        userFragment = UserDetailsFragment.newInstance(user);
        mSectionsPagerAdapter.notifyDataSetChanged();
    }

    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Timber.d("get item method");
            switch (position) {
                case 0:
                    Timber.d("returning parkingfragment");
                    return new ParkingSlotsFragment();
                case 1:
                    Timber.d("returning user Fragment = " + userFragment.toString());
                    return userFragment;
                default:
                    return new ParkingSlotsFragment();
            }
        }

        @Override
        public int getItemPosition(Object object) {
            Timber.d("getitemposition from pageradapter");
            return POSITION_NONE;
        }

        @Override
        public int getCount() {
            return 2;
        }

    }
}
