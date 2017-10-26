package com.yuyoubang.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;


import com.yuyoubang.R;
import com.yuyoubang.fragment.AFragment;
import com.yuyoubang.fragment.BFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivitys extends AppCompatActivity {

    ViewPager vp;
    ImageView iv1,iv2,iv3;
    //导入的fragment包需统一
    List<Fragment> fragmentList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mais);
        initView();
    }
    private void initView(){
        vp= (ViewPager) findViewById(R.id.viewpager);
        iv1= (ImageView) findViewById(R.id.v1);
        iv2= (ImageView) findViewById(R.id.v2);
        iv3= (ImageView) findViewById(R.id.v3);

        fragmentList.add(new AFragment());
        fragmentList.add(new BFragment());
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });


    }
}























