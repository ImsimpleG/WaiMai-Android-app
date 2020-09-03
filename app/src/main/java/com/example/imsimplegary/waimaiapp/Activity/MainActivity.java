package com.example.imsimplegary.waimaiapp.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imsimplegary.waimaiapp.Fragment.HomeFragment;
import com.example.imsimplegary.waimaiapp.Fragment.OrderFragment;
import com.example.imsimplegary.waimaiapp.Fragment.UserFragment;
import com.example.imsimplegary.waimaiapp.R;
import com.example.imsimplegary.waimaiapp.ClassOrAdapter.TabFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_item_home,tv_item_more,tv_item_me,tv_item_title;
    private ImageView pic_item_home,pic_item_more,pic_item_me;
    private ViewPager myViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.example.imsimplegary.waimaiapp.Util.Utils.setStatusBar(this, false, false);
        setContentView(R.layout.activity_main);
        InitView();
        //把Fragment添加到List集合里面
        List<Fragment> list=new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new OrderFragment());
        list.add(new UserFragment());
        myViewPager.setAdapter(new TabFragmentPagerAdapter(getSupportFragmentManager(),list));
        myViewPager.setCurrentItem(0);//默认第一个界面
        tv_item_home.setTextColor(Color.parseColor("#ffd161"));
        pic_item_home.setImageResource(R.drawable.c_home);
        tv_item_title.setText("我要点餐");

        // 设置菜单栏的点击事件
        tv_item_home.setOnClickListener(this);
        tv_item_more.setOnClickListener(this);
        tv_item_me.setOnClickListener(this);
        pic_item_home.setOnClickListener(this);
        pic_item_more.setOnClickListener(this);
        pic_item_me.setOnClickListener(this);
        myViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageSelected(int arg0) {
                switch (arg0){
                    case 0:
                        myViewPager.setCurrentItem(0);
                        tv_item_title.setText("我要点餐");
                        tv_item_home.setTextColor(Color.parseColor("#ffd161"));
                        tv_item_more.setTextColor(Color.parseColor("#666666"));
                        tv_item_me.setTextColor(Color.parseColor("#666666"));
                        pic_item_home.setImageResource(R.drawable.c_home);
                        pic_item_more.setImageResource(R.drawable.dingdan);
                        pic_item_me.setImageResource(R.drawable.me);
                        break;
                    case 1:
                        myViewPager.setCurrentItem(1);
                        tv_item_title.setText("我的订单");
                        tv_item_more.setTextColor(Color.parseColor("#ffd161"));
                        tv_item_home.setTextColor(Color.parseColor("#666666"));
                        tv_item_me.setTextColor(Color.parseColor("#666666"));
                        pic_item_home.setImageResource(R.drawable.home);
                        pic_item_more.setImageResource(R.drawable.c_dingdan);
                        pic_item_me.setImageResource(R.drawable.me);
                        break;
                    case 2:
                        myViewPager.setCurrentItem(2);
                        tv_item_title.setText("个人信息");
                        tv_item_me.setTextColor(Color.parseColor("#ffd161"));
                        tv_item_more.setTextColor(Color.parseColor("#666666"));
                        tv_item_home.setTextColor(Color.parseColor("#666666"));
                        pic_item_home.setImageResource(R.drawable.home);
                        pic_item_more.setImageResource(R.drawable.dingdan);
                        pic_item_me.setImageResource(R.drawable.c_me);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }


    /*
     *初始化控件
     */
    private void InitView(){
        tv_item_title = findViewById(R.id.tv_item_title);
        tv_item_home= findViewById(R.id.tv_item_home);
        tv_item_more=  findViewById(R.id.tv_item_more);
        tv_item_me=  findViewById(R.id.tv_item_me);
        pic_item_home = findViewById(R.id.pic_item_home);
        pic_item_more = findViewById(R.id.pic_item_more);
        pic_item_me = findViewById(R.id.pic_item_me);
        myViewPager=  findViewById(R.id.myViewPager);
    }

    /*
     *点击事件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_item_home:
                myViewPager.setCurrentItem(0);
                tv_item_title.setText("我要点餐");
                tv_item_home.setTextColor(Color.parseColor("#ffd161"));
                tv_item_more.setTextColor(Color.parseColor("#666666"));
                tv_item_me.setTextColor(Color.parseColor("#666666"));
                pic_item_home.setImageResource(R.drawable.c_home);
                pic_item_more.setImageResource(R.drawable.dingdan);
                pic_item_me.setImageResource(R.drawable.me);
                break;
            case R.id.tv_item_more:
                myViewPager.setCurrentItem(1);
                tv_item_title.setText("我的订单");
                tv_item_more.setTextColor(Color.parseColor("#ffd161"));
                tv_item_home.setTextColor(Color.parseColor("#666666"));
                tv_item_me.setTextColor(Color.parseColor("#666666"));
                pic_item_home.setImageResource(R.drawable.home);
                pic_item_more.setImageResource(R.drawable.c_dingdan);
                pic_item_me.setImageResource(R.drawable.me);
                break;
            case R.id.tv_item_me:
                myViewPager.setCurrentItem(2);
                tv_item_title.setText("个人信息");
                tv_item_me.setTextColor(Color.parseColor("#ffd161"));
                tv_item_more.setTextColor(Color.parseColor("#666666"));
                tv_item_home.setTextColor(Color.parseColor("#666666"));
                pic_item_home.setImageResource(R.drawable.home);
                pic_item_more.setImageResource(R.drawable.dingdan);
                pic_item_me.setImageResource(R.drawable.c_me);
                break;
            case R.id.pic_item_home:
                myViewPager.setCurrentItem(0);
                tv_item_title.setText("我要点餐");
                tv_item_home.setTextColor(Color.parseColor("#ffd161"));
                tv_item_more.setTextColor(Color.parseColor("#666666"));
                tv_item_me.setTextColor(Color.parseColor("#666666"));
                pic_item_home.setImageResource(R.drawable.c_home);
                pic_item_more.setImageResource(R.drawable.dingdan);
                pic_item_me.setImageResource(R.drawable.me);
                break;
            case R.id.pic_item_more:
                myViewPager.setCurrentItem(1);
                tv_item_title.setText("我的订单");
                tv_item_more.setTextColor(Color.parseColor("#ffd161"));
                tv_item_home.setTextColor(Color.parseColor("#666666"));
                tv_item_me.setTextColor(Color.parseColor("#666666"));
                pic_item_home.setImageResource(R.drawable.home);
                pic_item_more.setImageResource(R.drawable.c_dingdan);
                pic_item_me.setImageResource(R.drawable.me);
                break;
            case R.id.pic_item_me:
                myViewPager.setCurrentItem(2);
                tv_item_title.setText("个人信息");
                tv_item_me.setTextColor(Color.parseColor("#ffd161"));
                tv_item_more.setTextColor(Color.parseColor("#666666"));
                tv_item_home.setTextColor(Color.parseColor("#666666"));
                pic_item_home.setImageResource(R.drawable.home);
                pic_item_more.setImageResource(R.drawable.dingdan);
                pic_item_me.setImageResource(R.drawable.c_me);
                break;
        }
    }

    @Override
    protected void onResume() {
        int id = getIntent().getIntExtra("id", 0);
        if (id == 1) {
            Fragment fragmen = new OrderFragment();
            FragmentManager fmanger = getSupportFragmentManager();
            FragmentTransaction transaction = fmanger.beginTransaction();
            transaction.replace(R.id.myViewPager, fragmen);
            transaction.commit();
            myViewPager.setCurrentItem(1);//
            //帮助跳转到指定子fragment
            Intent i=new Intent();
            i.setClass(MainActivity.this,OrderFragment.class);
            i.putExtra("id",1);
        }
        super.onResume();
    }


}
