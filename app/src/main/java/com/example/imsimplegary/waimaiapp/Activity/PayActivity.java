package com.example.imsimplegary.waimaiapp.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.imsimplegary.waimaiapp.R;

import java.util.ArrayList;

public class PayActivity extends AppCompatActivity {
    String pay_shop_name;
    float pay_SumPrice,pay_shippingFee;
    TextView tv_pay_time,tv_pay_price,tv_pay_name,tv_paySumPrice;
    RelativeLayout finish_pay;
    private CountDownTimer mTimer;
    private long timeStamp = 3600000;
    Bitmap bitmap;
    ArrayList<String> menuList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.example.imsimplegary.waimaiapp.Util.Utils.setStatusBar(this, false, false);
        setContentView(R.layout.activity_pay);
        tv_pay_name = findViewById(R.id.tv_pay_name);
        tv_pay_time = findViewById(R.id.tv_pay_time);
        tv_pay_price = findViewById(R.id.tv_pay_price);
        tv_paySumPrice = findViewById(R.id.tv_paySumPrice);
        finish_pay = findViewById(R.id.finish_pay);
        Intent intent = getIntent();
        if(intent!=null)
        {
            bitmap=intent.getParcelableExtra("pay_bitmap");
        }
        pay_shop_name = intent.getStringExtra("pay_shop_name");
        pay_SumPrice = intent.getFloatExtra("pay_SumPrice",0);
        pay_shippingFee = intent.getFloatExtra("pay_shippingFee",0);
        menuList = intent.getStringArrayListExtra("pay_menulist");
        tv_pay_name.setText(pay_shop_name);
        tv_paySumPrice.setText("确认支付￥"+pay_SumPrice);
        tv_pay_price.setText("￥"+pay_SumPrice);
        initView();
        finish_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(PayActivity.this, BillDetailActivity.class);
                intent1.putExtra("bill_dt_name",pay_shop_name);
                intent1.putExtra("bill_dt_sumPrice",pay_SumPrice);
                intent1.putExtra("bill_dt_shippingFee",pay_shippingFee);
                intent1.putExtra("bill_dt_bitmap",bitmap);
                intent1.putStringArrayListExtra("bill_dt_menulist",menuList);
                startActivity(intent1);
            }
        });
    }
    private void initView() {
        mTimer = new CountDownTimer(timeStamp,1000) {
            @Override
            public void onTick(long l) {
                long minute = l/(1000*60);
                long payminute = minute/4;
                long second = (l-minute*(1000*60))/(1000);
                tv_pay_time.setText("剩余支付时间"+payminute+":"+second);
            }

            @Override
            public void onFinish() {

            }
        };
        mTimer.start();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
    }

}
