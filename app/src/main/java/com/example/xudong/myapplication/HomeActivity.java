package com.example.xudong.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.xudong.myapplication.base.BaseActivity;
import com.example.xudong.myapplication.event.ThemeChangedEvent;
import com.example.xudong.myapplication.fragment.BusFragment;
import com.example.xudong.myapplication.utils.DoubleClickExit;
import com.example.xudong.myapplication.utils.RxDrawer;
import com.example.xudong.myapplication.utils.SimpleSubscriber;
import com.thefinestartist.Base;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by xudong on 2017/1/10.
 */

public class HomeActivity extends BaseActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private NavigationView navigationView;
    private FragmentManager fragmentManager;
    private String currentFragmentTag;

    private static final String FRAGMENT_TAG_BUS = "bus";
    private static final String FRAGMENT_TAG_WEATHER = "weeather";
    private static final String FRAGMENT_TAG_GANK = "gank";
    private static final String FRAGMENT_TAG_READING = "reading";


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected int getMenuId() {
        return 0;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

        fragmentManager = getSupportFragmentManager();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        initNavigationViewHeader();
        initFragment(savedInstanceState);

    }

    private void initFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            switchContent(FRAGMENT_TAG_WEATHER);
        } else {
            currentFragmentTag = savedInstanceState.getString(AppGlobal.CURRENT_INDEX);
            switchContent(currentFragmentTag);
        }
    }



    @Override
    protected void loadData() {
//        outState.putString(AppGlobal.CURRENT_INDEX, currentFragmentTag);
    }

    public void initDrawer(Toolbar toolbar) {
        if (toolbar != null) {
            mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close) {
                @Override
                public void onDrawerOpened(View drawerView) {
                    super.onDrawerOpened(drawerView);
                }

                @Override
                public void onDrawerClosed(View drawerView) {
                    super.onDrawerClosed(drawerView);
                }
            };
            mDrawerToggle.syncState();
            mDrawerLayout.addDrawerListener(mDrawerToggle);
        }
    }
    private void initNavigationViewHeader() {
        navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.inflateHeaderView(R.layout.drawer_header);
        navigationView.setNavigationItemSelectedListener(new NavigationItemSelected());
    }


    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString(AppGlobal.CURRENT_INDEX, currentFragmentTag);
    }



    class NavigationItemSelected implements NavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(final MenuItem menuItem) {
            RxDrawer.close(mDrawerLayout).observeOn(AndroidSchedulers.mainThread()).subscribe(
                    new SimpleSubscriber<Void>() {
                        @Override
                        public void onNext(Void aVoid) {
                            switch (menuItem.getItemId()) {
                                case R.id.navigation_item_1:
                                    menuItem.setChecked(true);
                                    switchContent(FRAGMENT_TAG_BUS);
                                    break;
                                case R.id.navigation_item_2:
                                    menuItem.setChecked(true);
                                    switchContent(FRAGMENT_TAG_WEATHER);
                                    break;
                                case R.id.navigation_item_3:
                                    menuItem.setChecked(true);
                                    switchContent(FRAGMENT_TAG_GANK);
                                    break;
                                case R.id.navigation_item_4:
                                    menuItem.setChecked(true);
                                    switchContent(FRAGMENT_TAG_READING);
                                    break;
                                case R.id.navigation_item_settings:
                                    startActivity(new Intent(HomeActivity.this, SettingActivity.class));
                                    break;
                                case R.id.navigation_item_about:
                                    startActivity(new Intent(HomeActivity.this, AboutActivity.class));
                                    break;
                            }
                        }
                    });
            return false;
        }
    }

    public void switchContent(String name) {
        if (currentFragmentTag != null && currentFragmentTag.equals(name))
            return;

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        Fragment currentFragment = fragmentManager.findFragmentByTag(currentFragmentTag);
        if (currentFragment != null) {
            ft.hide(currentFragment);
        }

        Fragment foundFragment = fragmentManager.findFragmentByTag(name);

        if (foundFragment == null) {
            switch (name) {
                case FRAGMENT_TAG_BUS:
                    foundFragment = new BusFragment();
                   // foundFragment = new BusFragment();
                    break;
                case FRAGMENT_TAG_WEATHER:
                    //foundFragment = new WeatherFragment();
                    break;
                case FRAGMENT_TAG_GANK:
                    //foundFragment = new GirlsFragment();
                    break;
                case FRAGMENT_TAG_READING:
                    //foundFragment = new ReadingFragment();
                    break;
            }
        }

        if (foundFragment == null) {

        } else if (foundFragment.isAdded()) {
            ft.show(foundFragment);
        } else {
            ft.add(R.id.contentLayout, foundFragment, name);
        }
        ft.commit();
        currentFragmentTag = name;
        invalidateOptionsMenu();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onThemeChanged(ThemeChangedEvent event) {
        this.recreate();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onDestroy() {
        if (EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().unregister(this);
     //   TTSManager.destroy();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
//        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
//            mDrawerLayout.closeDrawer(GravityCompat.START);
//        } else {
//            if (!DoubleClickExit.check()) {
//                Snackbar.make(HomeActivity.this.getWindow().getDecorView().findViewById(android.R.id.content), "再按一次退出 App!", Snackbar.LENGTH_SHORT).show();
//            } else {
//                super.onBackPressed();
//            }
//        }
    }


}


