package com.example.imsimplegary.waimaiapp.ClassOrAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imsimplegary.waimaiapp.R;

import java.util.List;

/**
 * Created by IMSIMPLEGARY on 2019/1/2.
 */

public class OrderListAdapter extends RecyclerView.Adapter {
    private List<Order> orderList;

    public OrderListAdapter(List<Order> orderList) {
        this.orderList = orderList;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView order_pic;
        TextView order_shop_name,order_time,order_sumPrice;
        public ViewHolder(View itemView) {
            super(itemView);
            order_pic = itemView.findViewById(R.id.order_shop_pic);
            order_shop_name = itemView.findViewById(R.id.order_shop_name);
            order_time = itemView.findViewById(R.id.order_time);
            order_sumPrice = itemView.findViewById(R.id.order_sum_price);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(),R.layout.item_orderlist,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Order order = orderList.get(position);
        ((ViewHolder)holder).order_pic.setImageBitmap(order.getOrder_pic());
        ((ViewHolder)holder).order_shop_name.setText(order.getOrder_shop_name());
        ((ViewHolder)holder).order_time.setText(order.getOrder_time());
        ((ViewHolder)holder).order_sumPrice.setText(order.getOrder_sumPrice()+"");
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }
}
