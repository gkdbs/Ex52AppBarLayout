package com.milkywaylhy.ex52appbarlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;

    ViewPager pager;
    MyTabAdapter tabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialToolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout= findViewById(R.id.layout_tab);
        //탭버튼(Tab객체) 생성 밑 붙이기
//        TabLayout.Tab tab= tabLayout.newTab();
//        tab.setTag("tab1"); //식별자 - id같은 역할
//        tab.setText("TAB1");
//        tabLayout.addTab(tab);
//
//        TabLayout.Tab tab2= tabLayout.newTab().setTag("tab2").setText("TAB2");
//        tabLayout.addTab(tab2);
//
//        tabLayout.addTab(tabLayout.newTab().setTag("tab3").setText("TAB3"));
//        tabLayout.addTab(tabLayout.newTab().setTag("tab3").setText("TAB3"));
//        tabLayout.addTab(tabLayout.newTab().setTag("tab3").setText("TAB3"));
//        tabLayout.addTab(tabLayout.newTab().setTag("tab3").setText("TAB3"));
//        tabLayout.addTab(tabLayout.newTab().setTag("tab3").setText("TAB3"));
//        tabLayout.addTab(tabLayout.newTab().setTag("tab3").setText("TAB3"));

        //뷰페이저와 TabLayout 을 연동하기
        //연동을 하면 자동으로 뷰페이저의 페이지 개수만큼

        pager= findViewById(R.id.pager);
        tabAdapter= new MyTabAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        pager.setAdapter(tabAdapter);

        //뷰페이저와 TabLayout 을 연동하기
        tabLayout.setupWithViewPager(pager);




        //탭버튼 선택 리스너
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                if(tab.getTag().toString().equals("tab1")){
//                    pager.setCurrentItem(0);
//                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        super.onActivityReenter(resultCode, data);

        Toast.makeText(this, "액티비티가 결과를 받았다", Toast.LENGTH_SHORT).show();
    }
}