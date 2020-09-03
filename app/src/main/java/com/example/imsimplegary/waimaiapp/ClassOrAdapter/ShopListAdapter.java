package com.example.imsimplegary.waimaiapp.ClassOrAdapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imsimplegary.waimaiapp.Activity.MenuActivity;
import com.example.imsimplegary.waimaiapp.R;

import java.util.List;

/**
 * Created by IMSIMPLEGARY on 2018/10/25.
 */


public class ShopListAdapter extends RecyclerView.Adapter {
    private List<Shop> shopList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView shop_pic;
        TextView shop_name,shop_money,shop_sale,shop_distance,shop_minute,shop_shippingFee;
        View shopView;

        public ViewHolder(View itemView) {
            super(itemView);
            shopView = itemView;
            shop_pic = itemView.findViewById(R.id.shop_pic);
            shop_name = itemView.findViewById(R.id.shop_name);
            shop_sale = itemView.findViewById(R.id.shop_sale);
            shop_money = itemView.findViewById(R.id.shop_money);
            shop_distance = itemView.findViewById(R.id.shop_distance);
            shop_minute = itemView.findViewById(R.id.shop_minute);
            shop_shippingFee = itemView.findViewById(R.id.shop_shippingFee);
        }
    }

    public ShopListAdapter(List<Shop> shopList) {
        this.shopList = shopList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(parent.getContext(),R.layout.item_shoplist,null);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Shop shop = shopList.get(position);
        ((ViewHolder)holder).shop_pic.setImageResource(shop.getShop_pic());
        ((ViewHolder)holder).shop_name.setText(shop.getShop_name());
        ((ViewHolder)holder).shop_sale.setText(shop.getShop_sale());
        ((ViewHolder)holder).shop_money.setText(shop.getShop_money());
        ((ViewHolder)holder).shop_distance.setText(shop.getShop_distance());
        ((ViewHolder)holder).shop_minute.setText(shop.getShop_minute());
        ((ViewHolder)holder).shop_shippingFee.setText("配送费 ￥"+shop.getShop_shippingFee());
        ((ViewHolder)holder).shopView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),MenuActivity.class);
                intent.putExtra("shop_name", shop.shop_name);
                intent.putExtra("shop_minute", shop.shop_minute);
                intent.putExtra("shop_money", shop.shop_money);
                intent.putExtra("shop_pic", shop.shop_pic);
                ((ViewHolder)holder).shop_pic.setDrawingCacheEnabled(Boolean.TRUE);
                intent.putExtra("BITMAP",((ViewHolder)holder).shop_pic.getDrawingCache());
                intent.putExtra("position",position);
                intent.putExtra("shippingFee",shop.getShop_shippingFee());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return shopList.size();
    }

}