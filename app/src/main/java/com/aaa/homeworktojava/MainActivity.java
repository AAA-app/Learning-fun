package com.aaa.homeworktojava;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.aaa.homeworktojava.fragments.FragmentAlgorithms;
import com.aaa.homeworktojava.fragments.FragmentAnimation;
import com.aaa.homeworktojava.fragments.FragmentKotlin;
import com.aaa.homeworktojava.fragments.FragmentJava;
import com.aaa.homeworktojava.fragments.FragmentLogic;
import com.aaa.homeworktojava.fragments.FragmentRadio;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.q42.android.scrollingimageview.ScrollingImageView;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private CollapsingToolbarLayout mToolBar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ScrollingImageView scrollingBackground = (ScrollingImageView)findViewById(R.id.scrolling_background_ship);
        scrollingBackground.start();
        //scrollingBackground.stop();  if i'm vant to stop the animation

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
        adapter.addFragment(new FragmentJava(), "Java");
        adapter.addFragment(new FragmentRadio(), "Radio");
        adapter.addFragment(new FragmentKotlin(), "Kotlin");
        adapter.addFragment(new FragmentAnimation(), "Animation");
        adapter.addFragment(new FragmentLogic(), "Logic");
        adapter.addFragment(new FragmentAlgorithms(), "Algorithms");
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
