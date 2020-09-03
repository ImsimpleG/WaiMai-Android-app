package com.example.imsimplegary.waimaiapp.ClassOrAdapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;


public class TabFragmentPagerAdapter extends FragmentPagerAdapter {

   private List<Fragment> mlist;

   public TabFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
       super(fm);
       this.mlist=list;

   }


   @Override
   public Fragment getItem(int arg0) {
       return mlist.get(arg0);//显示第几个页面

   }

   @Override
   public int getCount() {
       return mlist.size();//有几个页面
   }

   @Override
   public void destroyItem(ViewGroup container, int position, Object object) {

   }
}
