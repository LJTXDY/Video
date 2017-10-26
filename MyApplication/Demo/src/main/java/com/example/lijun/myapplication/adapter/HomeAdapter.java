package com.example.lijun.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lijun.myapplication.R;
import com.example.lijun.myapplication.bean.Login;
import com.example.lijun.myapplication.manager.ImageOption;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiJun on 2017/10/26.
 */

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater inflater;
    private List<Login.ResultBean.ListBean> beanList;

    public HomeAdapter(Context mContext){
        inflater=LayoutInflater.from(mContext);
        beanList=new ArrayList<>();

    }
    public void addData(List<Login.ResultBean.ListBean> beanList){
        this.beanList.addAll(beanList);
        notifyDataSetChanged();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.adapter_vd,null);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ImageLoader.getInstance().displayImage(
                beanList.get(position).getData().getPic(),
                ((MyViewHolder)holder).iv1, ImageOption.defaultOptions
        );
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv1,iv2;
        private TextView tv1,tv2;
        public MyViewHolder(View itemView){
            super(itemView);
            iv1= (ImageView) itemView.findViewById(R.id.ivd);
            iv2=(ImageView) itemView.findViewById(R.id.iv);
            tv1= (TextView) itemView.findViewById(R.id.tv1);
            tv2= (TextView) itemView.findViewById(R.id.tv2);


        }
    }























}
