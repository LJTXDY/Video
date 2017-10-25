package com.example.lijun.myapplication.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lijun.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiJun on 2017/10/25.
 */

public class AFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager vp;
    View view;
    List<Fragment> fragmentList=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fp_a,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tabLayout= (TabLayout) view.findViewById(R.id.tablayout);
        vp= (ViewPager) view.findViewById(R.id.vp);
        fragmentList.add(new A1Fragment());
        fragmentList.add(new A2Fragment());
        vp.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });
        tabLayout.setupWithViewPager(vp);
        tabLayout.getTabAt(0).setText("精选");
        tabLayout.getTabAt(1).setText("热门");
    }
}
