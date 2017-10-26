package com.example.lijun.myapplication.fragment.base;


import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;




/**
 * date: Created on 16/5/24.
 */
public abstract class BaseLoadFragment extends UmengFragment implements SwipeRefreshLayout.OnRefreshListener {
    private PublicLoadLayout mRootLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootLayout = PublicLoadLayout.createPage(getContext(), getContentResId(), this);
        return mRootLayout;
    }

    public void goneLoading(){
        mRootLayout.goneLoading();
    }

    public void showNoData(){
        mRootLayout.showNoData();
    }

    public void showNetError(){
        mRootLayout.showNetError();
    }

    public void showLoading(){
        try {
            mRootLayout.showLoading();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    protected <VG extends View> VG getViewById(int resId){
        return (VG) mRootLayout.findViewById(resId);
    }

    protected abstract int getContentResId();
}
