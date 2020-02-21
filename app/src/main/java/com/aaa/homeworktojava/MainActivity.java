package com.aaa.homeworktojava;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.aaa.homeworktojava.fragments.FragmentGirls;
import com.aaa.homeworktojava.fragments.FragmentCars;
import com.aaa.homeworktojava.fragments.FragmentRadio;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private CollapsingToolbarLayout mToolBar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    public static ImageView mImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // first get our views
        mToolBar = findViewById(R.id.toolBar);
        mTabLayout = findViewById(R.id.tabLayout);
        mViewPager = findViewById(R.id.viewPager);

        mImageView =  findViewById(R.id.image_tv_toolbar);

        mToolBar.setTitle("Java Tutorial");
        setupViewPager(mViewPager);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    // nov create a function
    private void setupViewPager(ViewPager viewPager) {
        viewPagerAdapter adapter = new viewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentGirls(), "Girls");
        adapter.addFragment(new FragmentRadio(), "Radio");
        adapter.addFragment(new FragmentCars(), "Cars");
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
