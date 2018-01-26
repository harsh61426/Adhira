package com.example.lenovo.adhira;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    public static ViewPagerAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public Home homeFragment;
    public UpcomingRaces upcomingRacesFragment;
    public OnlineForums onlineForumsFragment;
    public PerformanceAnalysis performanceAnalysisFragment;
    public VirtualAssistant virtualAssistantFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //setSupportActionBar(toolbar);
        viewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {

        homeFragment=new Home();
        upcomingRacesFragment =new UpcomingRaces();
        onlineForumsFragment =new OnlineForums();
        performanceAnalysisFragment =new PerformanceAnalysis();
        virtualAssistantFragment=new VirtualAssistant();


        adapter = new MainActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(homeFragment, "Home");
        adapter.addFragment(upcomingRacesFragment, "Upcoming Races");
        adapter.addFragment(performanceAnalysisFragment, "Performance Analysis");
        adapter.addFragment(onlineForumsFragment, "Online Forums");
        adapter.addFragment(virtualAssistantFragment, "Virtual Assistant");
        viewPager.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
