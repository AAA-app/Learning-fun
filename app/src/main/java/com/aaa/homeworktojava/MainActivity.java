package com.aaa.homeworktojava;


import android.os.Bundle;
import android.widget.Toolbar;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.aaa.homeworktojava.fragments.FragmentOne;
import com.aaa.homeworktojava.fragments.FragmentThree;
import com.aaa.homeworktojava.fragments.FragmentTwo;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private Toolbar mToolBar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();

        // first get our views
        mToolBar = findViewById(R.id.toolBar);
        mTabLayout = findViewById(R.id.tabLayout);
        mViewPager = findViewById(R.id.viewPager);

        mToolBar.setTitle("Java Tutorial");
        setupViewPager(mViewPager);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    // nov create a function
    private void setupViewPager(ViewPager viewPager) {

        viewPagerAdapter adapter = new viewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentOne(), "Music");
        adapter.addFragment(new FragmentTwo(), "Cars");
        adapter.addFragment(new FragmentThree(), "Girls");
        viewPager.setAdapter(adapter);


    }

    //create an adapter class
    class viewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public viewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        private void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @NonNull
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
