package com.example.imsimplegary.waimaiapp.Activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.imsimplegary.waimaiapp.ClassOrAdapter.Product;
import com.example.imsimplegary.waimaiapp.ClassOrAdapter.ProductListAdapter;
import com.example.imsimplegary.waimaiapp.R;
import com.example.imsimplegary.waimaiapp.databinding.ActivityMenuBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MenuActivity extends AppCompatActivity {
        private CollapsingToolbarLayoutState state = CollapsingToolbarLayoutState.EXPANDED;
        private ActivityMenuBinding bindingView;
        private int height;
        private boolean hasMeasured = false;
        private enum CollapsingToolbarLayoutState {
            EXPANDED,
            COLLAPSED,
            INTERNEDIATE
        }
        String shop_name,shop_minute,shop_money,shop_pic;
        TextView tv_shop_name,tv_time,tv_money,header_buy,header_assess,header_shoper,tv_productSumPrice,tv_shippingFee,tv_goCheck;
        ImageView iv_logo,iv_bg,iv_shifu;
    int position,imagePath[];
    List<Product> productList;
    String tag[],name[],content[],sale[],zan[];
    float price[],shippingFee;
    float productSumPrice = 0;
    float ordernum = 0;
    int unionId = 0;
    Bitmap bitmap;

    private List<Product> menuList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.example.imsimplegary.waimaiapp.Util.Utils.setStatusBar(this, false, false);
        bindingView = DataBindingUtil.setContentView(this, R.layout.activity_menu);
        height = bindingView.ivBackground.getHeight();
        initView();
        setAppBarListener();
        GetIntent();
        bindingView.headerBuy.setVisibility(View.GONE);
        bindingView.headerShoper.setVisibility(View.GONE);
        bindingView.headerAssess.setVisibility(View.GONE);
        productList = new ArrayList<>();
        RecyclerView rv = findViewById(R.id.rv_product);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new ProductListAdapter(productList,this));
        initProductList();
        setBottomView(0);
    }
    public void initProductList(){
        if(position % 2 == 0){
            tag = new String[]{"系列A","系列B","系列C","系列D"};
            imagePath = new int[]{R.drawable.kfc_food1,R.drawable.kfc_food2,R.drawable.kfc,R.drawable.kfc_food1};
            name = new String[]{"食物1","食物2","食物3","食物4"};
            content = new String[]{"食物详情1","食物详情2","食物详情3","食物详情4"};
            sale = new String[]{"月售12","月售21","月售13","月售31"};
            zan = new String[]{"赞2","赞5","赞8","赞11"};
            price = new float[]{1,2,3,4};
        }else{
            tag = new String[]{"A系列","B系列","C系列","D系列"};
            imagePath = new int[]{R.drawable.mcd_food1,R.drawable.mcd_food2,R.drawable.mcd,R.drawable.mcd_food1};
            name = new String[]{"1食物","2食物","3食物","4食物"};
            content = new String[]{"1食物详情","2食物详情","3食物详情","4食物详情"};
            sale = new String[]{"月售34","月售43","月售45","月售54"};
            zan = new String[]{"赞3","赞6","赞9","赞12"};
            price = new float[]{5,6,7,8};
        }
        for (int i = 0; i < imagePath.length; i++){
            Product product = new Product(tag[i],true);
            productList.add(product);
            for (int j = 0;j < 5;j++,unionId++){
                product = new Product(imagePath[i],name[i],content[i],sale[i],zan[i],price[i],
                        0,false);
                product.setId(unionId);
                productList.add(product);
            }
        }
    }
    public void setBottomView(float orderProductPrice){
        tv_shippingFee.setText("另需配送费"+shippingFee+"");
        productSumPrice = productSumPrice+orderProductPrice;
        tv_productSumPrice.setText("￥"+productSumPrice);
    }
    public void setOrderView(Product product){
        try{
            menuList.get(product.getId()).setOrderNum(product.getOrderNum());
        }catch (IndexOutOfBoundsException ex){
            menuList.add(product);
        }
    }

    public void delOrderView(Product product){
        for(int i = 0;i<menuList.size();i++){
            Product item = menuList.get(i);
            if(item.getId() == product.getId()){
                item.setOrderNum(product.getOrderNum());
                if(item.getOrderNum()==0){
                    menuList.remove(i);
                }
            }
        }
    }

    public List<Product> getList(){
        return menuList;
    }

    private void GetIntent() {
        Intent intent = getIntent();
        shop_name = intent.getStringExtra("shop_name");
        shop_minute = intent.getStringExtra("shop_minute");
        shop_money = intent.getStringExtra("shop_money");
        shop_pic = intent.getStringExtra("shop_pic");
        position = intent.getIntExtra("position",0);
        shippingFee = intent.getFloatExtra("shippingFee",0);
        tv_shop_name.setText(shop_name);
        tv_money.setText(shop_money);
        tv_time.setText(shop_minute);
        if (intent != null && intent.getParcelableExtra("BITMAP") != null) {
            bitmap= (Bitmap) getIntent().getParcelableExtra("BITMAP");
            iv_logo.setImageBitmap(bitmap);
            iv_bg.setImageBitmap(bitmap);
        }
        iv_bg.setColorFilter(R.color.dark);
    }


    private void initView() {
        iv_shifu = findViewById(R.id.iv_shifu);
        tv_productSumPrice = findViewById(R.id.tv_productSumPrice);
        tv_shippingFee = findViewById(R.id.tv_shippingFee);
        tv_goCheck = findViewById(R.id.tv_goCheck);
        tv_shop_name = findViewById(R.id.tv_shop_name);
        tv_money = findViewById(R.id.tv_money);
        tv_time = findViewById(R.id.tv_time);
        iv_logo = findViewById(R.id.iv_logo);
        iv_bg = findViewById(R.id.ivBackground);
        header_buy = findViewById(R.id.header_buy);
        header_assess = findViewById(R.id.header_assess);
        header_shoper = findViewById(R.id.header_shoper);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back1);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        tv_goCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, BillActivity.class);
                intent.putExtra("bill_shippingFee",shippingFee);
                intent.putExtra("bill_SumPrice",productSumPrice);
                intent.putExtra("bill_shop_name",shop_name);
                ArrayList<String> strings = getArrayForIntent();
                intent.putStringArrayListExtra("menuList",strings);
                intent.putExtra("bill_bitmap",bitmap);
                startActivity(intent);
            }
        });
        //设置标题文字
//        bindingView.cpToolbar.setTitle(title);
        bindingView.cpToolbar.setCollapsedTitleTextColor(getResources().getColor(R.color.gary));
    }

    private ArrayList<String> getArrayForIntent(){//0 = imgpath 1=ordernum 2=name 3=price
        ArrayList<String> intentStr = new ArrayList<>();
        for(int i = 0;i<menuList.size();i++){

            Product item = menuList.get(i);
            if (item.getOrderNum()!=0){
                intentStr.add(item.getImagePath()+"");
                intentStr.add(item.getOrderNum()+"");
                intentStr.add(item.getName());
                intentStr.add(item.getPrice()+"");
            }
        }
        System.out.println(intentStr.size());
        return intentStr;
    }

    private void setAppBarListener() {
        measureHeight();
        bindingView.barview.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            if (verticalOffset == 0) {
                if (state != CollapsingToolbarLayoutState.EXPANDED) {
                    state = CollapsingToolbarLayoutState.EXPANDED;//修改为展开状态
                    bindingView.headerBuy.setVisibility(View.GONE);
                    bindingView.headerShoper.setVisibility(View.GONE);
                    bindingView.headerAssess.setVisibility(View.GONE);
                    bindingView.toolbar.setNavigationIcon(R.drawable.back1);
                    getWindow().getDecorView().setSystemUiVisibility(
                            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_VISIBLE);
                }
            } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
//                bindingView.titleTv.setVisibility(View.VISIBLE);
                bindingView.toolbar.setNavigationIcon(R.drawable.back2);
                state = CollapsingToolbarLayoutState.COLLAPSED;//修改为折叠状态
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                }
            } else {
                if (Math.abs(verticalOffset) > height) {
                    bindingView.headerBuy.setVisibility(View.VISIBLE);
                    bindingView.headerShoper.setVisibility(View.VISIBLE);
                    bindingView.headerAssess.setVisibility(View.VISIBLE);
                    float scale =  1- height / (float) Math.abs(verticalOffset);
                    if (state != CollapsingToolbarLayoutState.INTERNEDIATE) {
                        if (state == CollapsingToolbarLayoutState.COLLAPSED && scale < 0.55) {//由折叠变为展开
                            bindingView.toolbar.setNavigationIcon(R.drawable.back1);
                            getWindow().getDecorView().setSystemUiVisibility(
                                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_VISIBLE);
                        } else {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                            }
                        }

                        state = CollapsingToolbarLayoutState.INTERNEDIATE;
                    }
                    float alpha = (255 * scale);
                    Log.e("xwf", "alpha = " + alpha + " scale = " + scale);
//                    bindingView.titleTv.setTextColor(Color.argb((int) alpha, 53,55,58));
//                    bindingView.toolbar.setBackgroundColor(Color.argb((int) alpha, 255,255,255));
                    bindingView.toolbar.setNavigationIcon(R.drawable.back2);
                } else {
                    bindingView.headerBuy.setVisibility(View.GONE);
                    bindingView.headerShoper.setVisibility(View.GONE);
                    bindingView.headerAssess.setVisibility(View.GONE);
                    bindingView.toolbar.setNavigationIcon(R.drawable.back1);
                }
            }
        });
    }

    private void measureHeight() {
        ViewTreeObserver vto = bindingView.cdlayout.getViewTreeObserver();
        vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                if (hasMeasured == false) {
                    height = bindingView.toolbar.getMeasuredHeight();
                    hasMeasured = true;
                }
                return true;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
