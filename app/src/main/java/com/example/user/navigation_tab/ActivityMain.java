package com.example.user.navigation_tab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.user.navigation_tab.framework.ActivityInitialize;
import com.example.user.navigation_tab.tabs.SlidingTabLayout;


public class ActivityMain extends AppCompatActivity implements ActivityInitialize {

    private Toolbar mToolbar;
    private ViewPager mPager;
    private SlidingTabLayout mSlidingTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.activity_main_app_bar);

        initialize();
    }

    @Override
    public void initialize() {
        /** */
        mToolbar = (Toolbar) findViewById(R.id.tb_app_bar);
        setSupportActionBar(mToolbar);

        /** */
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        /** */
        FragNaviDrawer fragNaviDrawer = (FragNaviDrawer) getSupportFragmentManager().findFragmentById(R.id.frag_navi_container);
        fragNaviDrawer.setUp(R.id.frag_navi_container, (DrawerLayout) findViewById(R.id.dl_drawer_layout), mToolbar);

        mPager = (ViewPager) findViewById(R.id.vp_pager);
        mPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.st_tabs_main);
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.colorAccent));
        mSlidingTabLayout.setViewPager(mPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        String tab[] = {"123", "234", "345", "456", "567", "678", "789", "890", "901", "102"};

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return FragmentBlank.newInstance("", "");
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tab[position];
        }

        @Override
        public int getCount() {
            return tab.length;
        }
    }
}
