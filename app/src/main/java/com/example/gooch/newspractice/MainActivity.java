package com.example.gooch.newspractice;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private String[] mStringArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mViewPager = findViewById(R.id.vp_content);
        mTabLayout = findViewById(R.id.tl_title);
        mStringArray = getResources().getStringArray(R.array.tab_titles);
        initTab();
        initViewPager();
    }

    private void initViewPager() {
        Fragment fragment = null;
        final List<Fragment> fragments = new ArrayList<>();
        for (String aMStringArray : mStringArray) {
            fragment = new MainFragment();
            fragments.add(fragment);
        }
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return mStringArray.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mStringArray[position];
            }
        });
    }

    private void initTab() {
        for (String title : mStringArray) {
            TabLayout.Tab tab = mTabLayout.newTab();
            mTabLayout.addTab(tab);
            mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
            mTabLayout.setSelectedTabIndicatorColor(Color.BLUE);
            mTabLayout.setTabGravity(Gravity.CENTER);
            mTabLayout.setTabTextColors(Color.BLACK, Color.RED);
        }
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
