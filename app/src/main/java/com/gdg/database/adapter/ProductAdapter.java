package com.gdg.database.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gdg.database.R;
import com.gdg.database.model.Product;

import java.util.List;

/**
 * Created by hqthao on 6/5/16.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<Product> mProductList;

    public ProductAdapter(List<Product> productList) {
        mProductList = productList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_card, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Product product = mProductList.get(position);
        holder.mProductNameTextView.setText(product.getProductName());
        holder.mCompanyTextView.setText(product.getProductCompany());
        holder.mQuantityTextView.setText(product.getQuantity() + "");
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

     static class ViewHolder extends RecyclerView.ViewHolder {

         TextView mProductNameTextView;
         TextView mQuantityTextView;
         TextView mCompanyTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mProductNameTextView = (TextView) itemView.findViewById(R.id.product_name);
            mQuantityTextView = (TextView) itemView.findViewById(R.id.product_quantity);
            mCompanyTextView = (TextView) itemView.findViewById(R.id.product_company);
        }
    }
}
