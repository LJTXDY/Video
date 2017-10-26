package com.example.lijun.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lijun.myapplication.R;
import com.example.lijun.myapplication.bean.Login;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LiJun on 2017/10/25.
 */

public class VideoAdapter extends BaseAdapter {
    Context context;
    Login bean;
    DisplayImageOptions options;
    ArrayList<HashMap<String,Object>> arrayList;

    public VideoAdapter(Context context, Login bean,ArrayList<HashMap<String,Object>> arrayList){
        this.context=context;
        this.bean=bean;
        this.arrayList=arrayList;

        options=new DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.mipmap.ic_launcher)//url为空显示该图片，自己放在drawable里面的
                .showImageOnFail(R.mipmap.ic_launcher)//加载图片出现问题，会显示该图片
                .cacheInMemory()//缓存用
                .cacheOnDisc()//缓存用
                .displayer(new RoundedBitmapDisplayer(10))//图片圆角显示，值为整数
                .build();
        ImageLoaderConfiguration config=new ImageLoaderConfiguration.Builder(context)
                .memoryCacheExtraOptions(480,800)//缓存在内存的图片的宽和高
                .memoryCache(new WeakMemoryCache())
                .memoryCacheSize(2*1024*1024)//缓存到内存的最大数据
                .discCacheSize(50*1024*1024)//缓存到文件的最大数据
                .diskCacheFileCount(1000)//文件数量
                .defaultDisplayImageOptions(options) //上面的options对象，一些属性配置
                .build();
        ImageLoader.getInstance().init(config);//初始化

    }
    @Override
    public int getCount() {
        return bean.getResult().getList().size();
    }

    @Override
    public Object getItem(int position) {
        return bean.getResult().getList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        convertView=View.inflate(context,R.layout.adapter_vd,null);
        holder=new ViewHolder();
        holder.ivd= (ImageView) convertView.findViewById(R.id.ivd);
        holder.iv= (ImageView) convertView.findViewById(R.id.iv);
        holder.tv1= (TextView) convertView.findViewById(R.id.tv1);
        holder.tv2= (TextView) convertView.findViewById(R.id.tv2);
        //根据对象属性得到变化  刷新UI
//        if (bean.getResult().getList().get(position).equals(null)){
//
//        }
        ImageLoader.getInstance().displayImage(bean.getResult().getList().get(position)
                .getData().getPic(),holder.ivd,options);
        ImageLoader.getInstance().displayImage(bean.getResult().getList().get(position)
                .getUser().getUser_data().getAvatar(),holder.iv,options);
        holder.tv1.setText(bean.getResult().getList().get(position).getUser().getUser_data().getUser_name());
        holder.tv2.setText(bean.getResult().getList().get(position).getUser().getUser_data().getSign());

        return convertView;
    }

    class ViewHolder{
        ImageView ivd,iv;
        TextView tv1,tv2;
    }
    //保留数据  原操作记录
    public  void updateAdapter(Login bean){
        this.bean=bean;
        notifyDataSetChanged();
    }
}





























