package com.aaa.homeworktojava;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.aaa.homeworktojava.adapter.RvAdapter;
import com.aaa.homeworktojava.data.DataClass;
import com.aaa.homeworktojava.fragments.FragmentOne;
import com.aaa.homeworktojava.fragments.FragmentThree;
import com.aaa.homeworktojava.fragments.FragmentTwo;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.aaa.homeworktojava.R.drawable.car2;
import static com.aaa.homeworktojava.R.drawable.music1;


public class MainActivity extends AppCompatActivity {
    private CollapsingToolbarLayout mToolBar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ImageView toolImg;


    DatabaseReference mRef;
    RecyclerView recyclerView;
    ArrayList<DataClass> listData;
    RvAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        ActionBar actionBar = getSupportActionBar();
//        assert actionBar != null;
//        actionBar.hide();

        // first get our views
        mToolBar = findViewById(R.id.toolBar);
        mTabLayout = findViewById(R.id.tabLayout);
        mViewPager = findViewById(R.id.viewPager);

        toolImg = findViewById(R.id.image_tv_toolbar);
        if (toolImg != null ) {
            toolImg.setImageResource(R.drawable.girls6);
        }


        mToolBar.setTitle("Java Tutorial");
        setupViewPager(mViewPager);
        mTabLayout.setupWithViewPager(mViewPager);



    }

    // nov create a function
    private void setupViewPager(ViewPager viewPager) {

        viewPagerAdapter adapter = new viewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentOne(), "Cars");
        adapter.addFragment(new FragmentTwo(), "Music");
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
