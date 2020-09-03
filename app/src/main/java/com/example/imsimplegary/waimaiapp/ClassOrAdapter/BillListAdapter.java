package com.example.imsimplegary.waimaiapp.ClassOrAdapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imsimplegary.waimaiapp.R;

import java.util.List;

/**
 * Created by IMSIMPLEGARY on 2018/12/31.
 */

public class BillListAdapter extends RecyclerView.Adapter {

    private List<Bill> billList;
    private Activity activity;
    public BillListAdapter(List<Bill> billList, Activity activity) {
        this.billList = billList;
        this.activity = activity;
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView bill_pic;
        TextView bill_food_name,bill_ordernum,bill_food_price;
        public ViewHolder(View itemView,int viewType) {
            super(itemView);
            bill_pic = itemView.findViewById(R.id.bill_pic);
            bill_food_name = itemView.findViewById(R.id.bill_food_name);
            bill_ordernum = itemView.findViewById(R.id.bill_ordernum);
            bill_food_price = itemView.findViewById(R.id.bill_food_price);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        view = View.inflate(parent.getContext(),R.layout.item_bill_food_information,null);
        ViewHolder holder = new ViewHolder(view,viewType);
        //防止RecyclerView条目发生错乱，需要设置不复用ViewHolder
        holder.setIsRecyclable(false);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        Bill bill = billList.get(position);
        ((ViewHolder) holder).bill_pic.setImageResource(bill.getBill_pic());
        ((ViewHolder) holder).bill_food_name.setText(bill.getBill_food_name());
        ((ViewHolder) holder).bill_food_price.setText("￥" + bill.getBill_food_price());
        ((ViewHolder) holder).bill_ordernum.setText(bill.getBill_ordernum() + "");


    }

    @Override
    public int getItemCount() {
        return billList.size();
    }
}
