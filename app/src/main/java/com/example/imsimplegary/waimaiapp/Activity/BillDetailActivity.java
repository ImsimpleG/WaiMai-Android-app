package com.example.imsimplegary.waimaiapp.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.SensorEventListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.widget.TextView;

import com.example.imsimplegary.waimaiapp.ClassOrAdapter.Bill;
import com.example.imsimplegary.waimaiapp.ClassOrAdapter.BillListAdapter;
import com.example.imsimplegary.waimaiapp.Fragment.OrderFragment;
import com.example.imsimplegary.waimaiapp.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillDetailActivity extends AppCompatActivity {
    TextView bill_time,bill_food_shippingFee,bill_food_sum,bill_name;
    float shippingFee,productSumPrice;
    String shop_name;
    String str;
    List<Bill> billList;
    ArrayList<String> menuList = new ArrayList<>();
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.example.imsimplegary.waimaiapp.Util.Utils.setStatusBar(this, false, false);
        setContentView(R.layout.activity_bill_detail);
        bill_food_shippingFee = findViewById(R.id.bill_dt_shippingFee);
        bill_food_sum = findViewById(R.id.bill_dt_sum);
        bill_time = findViewById(R.id.bill_time);
        bill_name = findViewById(R.id.bill_DTname);
        Intent intent = getIntent();
        if(intent!=null)
        {
            bitmap=intent.getParcelableExtra("bill_dt_bitmap");
        }
        shop_name = intent.getStringExtra("bill_dt_name");
        shippingFee = intent.getFloatExtra("bill_dt_shippingFee", 0);
        productSumPrice = intent.getFloatExtra("bill_dt_sumPrice", 0);
        bill_food_shippingFee.setText(shippingFee + "");
        bill_food_sum.setText("￥" + productSumPrice);
        bill_name.setText(shop_name);
        billList = new ArrayList<>();
        RecyclerView rv = findViewById(R.id.bill_dt_rl);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new BillListAdapter(billList,this));
        menuList = intent.getStringArrayListExtra("bill_dt_menulist");
        for(int i = 0;i<menuList.size();i+=4){
            Bill bill = new Bill(Integer.parseInt(menuList.get(i)),Integer.parseInt(menuList.get(i+1)),menuList.get(i+2),Float.parseFloat(menuList.get(i+3)));
            billList.add(bill);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd- HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());
        str = formatter.format(curDate);
        bill_time.setText(str);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode== KeyEvent.KEYCODE_BACK){
            Intent sEIntent = new Intent();
            sEIntent.setClass(BillDetailActivity.this, MainActivity.class);
            sEIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            //一定要指定是第几个pager，因为要跳到ThreeFragment，这里填写2
            sEIntent.putExtra("id",1);
            sEIntent.putExtra("order_sumprice",productSumPrice);
            sEIntent.putExtra("order_name",shop_name);
            sEIntent.putExtra("order_time",str);
            sEIntent.putExtra("order_bitmap",bitmap);
            startActivity(sEIntent);
            finish();
        }
        return true;
    }
}
