package com.example.imsimplegary.waimaiapp.ClassOrAdapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imsimplegary.waimaiapp.Activity.BillActivity;
import com.example.imsimplegary.waimaiapp.Activity.MenuActivity;
import com.example.imsimplegary.waimaiapp.R;

import java.util.List;

/**
 * Created by IMSIMPLEGARY on 2018/12/26.
 */

public class ProductListAdapter extends RecyclerView.Adapter {
    private List<Product> productList;
    private Activity activity;

    public ProductListAdapter(List<Product> productList,Activity activity) {
        this.productList = productList;
        this.activity = activity;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_Product_pic,iv_addProduct,iv_delProduct,iv_shifu;
        TextView tv_name,tv_content,tv_sale,tv_zan,tv_price,tv_orderNum,tv_tag;
        public ViewHolder(View itemView,int viewType) {
            super(itemView);
            switch (viewType){
                case 0:
                    tv_tag = itemView.findViewById(R.id.tv_tagTitle);
                    break;
                case 1:
                    iv_Product_pic = itemView.findViewById(R.id.iv_product_pic);
                    iv_addProduct = itemView.findViewById(R.id.iv_addProduct);
                    iv_delProduct = itemView.findViewById(R.id.iv_delProduct);
                    tv_name = itemView.findViewById(R.id.tv_product_name);
                    tv_content = itemView.findViewById(R.id.tv_product_content);
                    tv_sale = itemView.findViewById(R.id.tv_product_sale);
                    tv_zan = itemView.findViewById(R.id.tv_product_zan);
                    tv_price = itemView.findViewById(R.id.tv_product_price);
                    tv_orderNum = itemView.findViewById(R.id.tv_orderNum);
                    iv_shifu = itemView.findViewById(R.id.iv_shifu);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType){
            case 0:
                view = View.inflate(parent.getContext(),R.layout.item_productlist_title,null);
                break;
            case 1:
                view = View.inflate(parent.getContext(),R.layout.item_productlist,null);
                break;
            default:
                break;
        }
        ViewHolder holder = new ViewHolder(view,viewType);
        //防止RecyclerView条目发生错乱，需要设置不复用ViewHolder
        holder.setIsRecyclable(false);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        Product product = productList.get(position);
        switch (viewType){
            case 0:
                ((ViewHolder)holder).tv_tag.setText(product.getTag());
                break;
            case 1:
                ((ViewHolder)holder).iv_Product_pic.setImageResource(product.getImagePath());
                ((ViewHolder)holder).tv_name.setText(product.getName());
                ((ViewHolder)holder).tv_content.setText(product.getContent());
                ((ViewHolder)holder).tv_sale.setText(product.getSale());
                ((ViewHolder)holder).tv_zan.setText(product.getZan());
                ((ViewHolder)holder).tv_price.setText("￥"+product.getPrice());
                ((ViewHolder)holder).tv_orderNum.setText(product.getOrderNum()+"");
                if (product.getOrderNum()>0) {
                    ((ViewHolder) holder).iv_delProduct.setVisibility(View.VISIBLE);
                    ((ViewHolder)holder).tv_orderNum.setVisibility(View.VISIBLE);
                }
                ((ViewHolder)holder).iv_addProduct.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        product.setOrderNum(product.getOrderNum()+1);
                        //product改变了就意味着list数据内容改变了，需要重新渲染RecyclerView
                        //让设配器通知RecyclerView数据发生更改
                        ProductListAdapter.this.notifyDataSetChanged();
                        ((MenuActivity)activity).setBottomView(product.getPrice());
                        ((MenuActivity)activity).setOrderView(product);


                    }
                });
                ((ViewHolder)holder).iv_delProduct.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        product.setOrderNum(product.getOrderNum()-1);
                        //product改变了就意味着list数据内容改变了，需要重新渲染RecyclerView
                        //让设配器通知RecyclerView数据发生更改
                        ProductListAdapter.this.notifyDataSetChanged();
                        ((MenuActivity)activity).setBottomView(-product.getPrice());
                        ((MenuActivity)activity).delOrderView(product);
                    }
                });
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return productList.get(position).isTitle() ? 0 : 1 ;
    }
}
