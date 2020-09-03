package com.example.imsimplegary.waimaiapp.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imsimplegary.waimaiapp.ClassOrAdapter.Bill;
import com.example.imsimplegary.waimaiapp.ClassOrAdapter.BillListAdapter;
import com.example.imsimplegary.waimaiapp.ClassOrAdapter.Product;
import com.example.imsimplegary.waimaiapp.ClassOrAdapter.ProductListAdapter;
import com.example.imsimplegary.waimaiapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by IMSIMPLEGARY on 2018/12/30.
 */

public class BillActivity  extends AppCompatActivity {
    TextView bill_productSumPrice,bill_food_shippingFee,bill_food_sum,arrival_time,bill_name,bill_gopay;
    float shippingFee,productSumPrice;
    String shop_name;
    List<Bill> billList;
    ArrayList<String> menuList = new ArrayList<>();
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.example.imsimplegary.waimaiapp.Util.Utils.setStatusBar(this, false, false);
        setContentView(R.layout.activity_bill);
        bill_productSumPrice = findViewById(R.id.bill_productSumPrice);
        bill_food_shippingFee = findViewById(R.id.bill_food_shippingFee);
        bill_food_sum = findViewById(R.id.bill_food_sum);
        arrival_time = findViewById(R.id.arrival_time);
        bill_name = findViewById(R.id.bill_name);
        bill_gopay = findViewById(R.id.tv_goPay);
        Intent intent = getIntent();
        if(intent!=null)
        {
            bitmap=intent.getParcelableExtra("bill_bitmap");
        }
        shop_name = intent.getStringExtra("bill_shop_name");
        shippingFee = intent.getFloatExtra("bill_shippingFee",0);
        productSumPrice = intent.getFloatExtra("bill_SumPrice",0);
        bill_food_shippingFee.setText(shippingFee+"");
        bill_productSumPrice.setText("合计 ￥"+(productSumPrice+shippingFee));
        bill_food_sum.setText("￥"+productSumPrice);
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.HOUR, ca.get(Calendar.HOUR) + 1);
        show();
        arrival_time.setText("大约"+formatDate(ca.getTime())+"到达");
        bill_name.setText(shop_name);
        billList = new ArrayList<>();
        RecyclerView rv = findViewById(R.id.bill_rl);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new BillListAdapter(billList,this));
            menuList = intent.getStringArrayListExtra("menuList");
                for (int i = 0; i < menuList.size(); i += 4) {
                    Bill bill = new Bill(Integer.parseInt(menuList.get(i)), Integer.parseInt(menuList.get(i + 1)), menuList.get(i + 2), Float.parseFloat(menuList.get(i + 3)));
                    billList.add(bill);
            }



        bill_gopay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(BillActivity.this,PayActivity.class);
                intent1.putExtra("pay_shop_name",shop_name);
                intent1.putExtra("pay_SumPrice",(productSumPrice+shippingFee));
                intent1.putExtra("pay_shippingFee",shippingFee);
                intent1.putExtra("pay_bitmap",bitmap);
                intent1.putStringArrayListExtra("pay_menulist",menuList);
                startActivity(intent1);
            }
        });
    }




    private static String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        return dateFormat.format(date);
    }


    private static void show() {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.HOUR, ca.get(Calendar.HOUR) + 1);
    }


}