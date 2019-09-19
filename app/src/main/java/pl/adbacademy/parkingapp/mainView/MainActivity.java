package pl.adbacademy.parkingapp.mainView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import pl.adbacademy.parkingapp.R;
import pl.adbacademy.parkingapp.login.LoginActivity;
import pl.adbacademy.parkingapp.mainView.parkingView.ParkingSlotsFragment;
import pl.adbacademy.parkingapp.mainView.usersView.UserDetailsFragment;
import pl.adbacademy.parkingapp.mainView.usersView.UsersListFragment;
import pl.adbacademy.parkingapp.model.User;
import pl.adbacademy.parkingapp.repository.Repository;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.view_pager)
    ViewPager viewPager;


    private final String USER_DETAILS_FRAGMENT = "UserDetailsFragment";
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private int pagerPosition;
    private Fragment userFragment;
    private String userFragmentString;
    private int userListTabPosition = 0;


    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Inject
    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(mSectionsPagerAdapter);
        userFragment = UsersListFragment.newInstance(userListTabPosition);

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
        if (pagerPosition == 1 && userFragmentString.equals(USER_DETAILS_FRAGMENT)) {
            userFragment = UsersListFragment.newInstance(userListTabPosition);
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

        if (id == R.id.logout) {
            repository.clear();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);

            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }


    public void enterDetailFragment(User user, int userListTabPosition) {
        this.userListTabPosition = userListTabPosition;
        userFragment = UserDetailsFragment.newInstance(user);
        userFragmentString = USER_DETAILS_FRAGMENT;
        mSectionsPagerAdapter.notifyDataSetChanged();
    }

    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new ParkingSlotsFragment();
                case 1:
                    return userFragment;
                default:
                    return new ParkingSlotsFragment();
            }
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public int getCount() {
            return 2;
        }

    }
}
