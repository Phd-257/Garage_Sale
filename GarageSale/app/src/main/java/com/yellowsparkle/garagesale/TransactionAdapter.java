package com.yellowsparkle.garagesale;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yellowsparkle.garagesale.models.Product;

import org.jetbrains.annotations.NotNull;

import java.util.List;



public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.MyAllTransactionViewHolder> {

    private final List<Product> mTransactionList;

    // 1st called
    // getting list from the constructor
    public TransactionAdapter(List<Product> TransactionList) {
        mTransactionList = TransactionList;
    }

    // 3rd called
    @NonNull
    @NotNull
    @Override
    public TransactionAdapter.MyAllTransactionViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_transaction, parent, false);
        return new MyAllTransactionViewHolder(mView);
    }

    //5th called
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull @NotNull TransactionAdapter.MyAllTransactionViewHolder holder, int position) {
        Product product = mTransactionList.get(position);
        holder.mTvProductName.setText(product.getProductName());
        holder.mTvProductPrice.setText("$ " + product.getProductPrice());
        holder.mTvSoldByName.setText("Sold by : " + product.getOwnerName());
        holder.mTvReservedByName.setText("Reserved by : " + product.getCustomerName());
        Glide.with(holder.itemView).load(product.getProductImage()).into(holder.mImageView);
    }

    // 2nd called
    @Override
    public int getItemCount() {
        return mTransactionList.size();
    }

    // 4th called
    public static class MyAllTransactionViewHolder extends RecyclerView.ViewHolder{

        private final TextView mTvProductName;
        private final TextView mTvProductPrice;
        private final TextView mTvSoldByName;
        private final TextView mTvReservedByName;
        private final ImageView mImageView;

        public MyAllTransactionViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            mTvProductName = itemView.findViewById(R.id.tv_product_name);
            mTvProductPrice = itemView.findViewById(R.id.tv_product_price);
            mTvSoldByName = itemView.findViewById(R.id.tv_sold_by_name);
            mTvReservedByName = itemView.findViewById(R.id.tv_reserved_by_name);
            mImageView = itemView.findViewById(R.id.iv_product);
        }
    }
}

