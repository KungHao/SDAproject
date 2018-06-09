package com.example.kunghao.sdaprojecttest;


import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Tab1.OnFragmentInteractionListener,Tab2.OnFragmentInteractionListener,Tab3.OnFragmentInteractionListener{

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Views();
        configViewPager();
    }

    private void Views() {
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
    }

    private void configViewPager() {
        List<String> titles = new ArrayList<>();
        titles.add("餐廳資訊");
        titles.add("訂餐");
        titles.add("修改");

        //加入分頁
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(2)));


        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new Tab1());
        fragments.add(new Tab2());
        fragments.add(new Tab3());

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(adapter);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
