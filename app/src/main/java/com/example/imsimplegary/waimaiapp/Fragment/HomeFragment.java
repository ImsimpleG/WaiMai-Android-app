package com.example.imsimplegary.waimaiapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.imsimplegary.waimaiapp.ClassOrAdapter.ShopListAdapter;
import com.example.imsimplegary.waimaiapp.ClassOrAdapter.Shop;
import com.example.imsimplegary.waimaiapp.R;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private View view;
    public RecyclerView recyclerView;
    private List<Shop> shopList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_home, container, false);
        initRecyclerView();
        initShops();
        return view;
    }

    private void initRecyclerView() {
        recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new ShopListAdapter(shopList));
    }

    private void initShops(){
        for(int i = 0; i < 8; i++){
            Shop kfc = new Shop(R.drawable.kfc,"肯德基宅慢送","月售645","￥20起送  ","3.3km","配送约32分钟  ",9);
            shopList.add(kfc);
            Shop mcd = new Shop(R.drawable.mcd,"银拱门","月售415","￥25起送  ","2.7km","配送约27分钟  ",8);
            shopList.add(mcd);
        }
    }




}
