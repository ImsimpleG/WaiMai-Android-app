package com.example.imsimplegary.waimaiapp.Fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imsimplegary.waimaiapp.ClassOrAdapter.Order;
import com.example.imsimplegary.waimaiapp.ClassOrAdapter.OrderListAdapter;
import com.example.imsimplegary.waimaiapp.ClassOrAdapter.ShopListAdapter;
import com.example.imsimplegary.waimaiapp.R;

import java.util.ArrayList;
import java.util.List;


public class OrderFragment extends Fragment {
    private View view;
    private ViewPager myViewPager;
    RecyclerView recyclerView;
    String shop_name,order_time;
    Bitmap bitmap;
    float order_sumPrice;
    List<Order> orderList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_order,container,false);
        myViewPager = view.findViewById(R.id.myViewPager);
        Intent intent = getActivity().getIntent();
        if(intent!=null)
        {
            bitmap=intent.getParcelableExtra("order_bitmap");
        }
        shop_name = intent.getStringExtra("order_name");
        order_time = intent.getStringExtra("order_time");
        order_sumPrice = intent.getFloatExtra("order_sumprice",0);
        initRecyclerView();
        initOrder();
        return view;
    }

    private void initOrder() {
        for (int i = 0; i < 1; i++) {
            Order order = new Order(bitmap, order_time, shop_name, order_sumPrice);
            orderList.add(order);
        }
    }

    private void initRecyclerView() {
        recyclerView = view.findViewById(R.id.order_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new OrderListAdapter(orderList));
    }


//    @Override
    public void onResume() {
        int id = getActivity().getIntent().getIntExtra("id", 0);
        if(id==2){
            myViewPager.setCurrentItem(1);
        }
        super.onResume();
    }
}
