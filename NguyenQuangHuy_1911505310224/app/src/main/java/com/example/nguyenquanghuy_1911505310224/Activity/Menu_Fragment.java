package com.example.nguyenquanghuy_1911505310224.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nguyenquanghuy_1911505310224.Adapter.MainViewPagerAdapter;
import com.example.nguyenquanghuy_1911505310224.Fragment.Fragment_Home;
import com.example.nguyenquanghuy_1911505310224.Fragment.Fragment_User;
import com.example.nguyenquanghuy_1911505310224.R;

public class Menu_Fragment extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_fragment);
        AnhXa();
        init();
    }

    private void init() {
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addFragment(new Fragment_Home(),"Trang chủ");
        mainViewPagerAdapter.addFragment(new Fragment_User(),"Cá nhân");
        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
        tabLayout.getTabAt(1).setIcon(R.drawable.profile);
    }

    private void AnhXa() {
        tabLayout = findViewById(R.id.myTabLayout);
        viewPager = findViewById(R.id.myViewPage);
    }
}