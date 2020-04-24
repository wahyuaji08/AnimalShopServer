package com.example.wahyuajisantoso.animalserver.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wahyuajisantoso.animalserver.Interface.ItemClickListener;
import com.example.wahyuajisantoso.animalserver.Model.Order;
import com.example.wahyuajisantoso.animalserver.R;

import java.util.List;

class MyViewHolder extends RecyclerView.ViewHolder{

    public TextView name,quantity,price;

    public MyViewHolder(View itemView) {
        super(itemView);
        name = (TextView)itemView.findViewById(R.id.product_name);
        quantity = (TextView)itemView.findViewById(R.id.product_quantity);
        price = (TextView)itemView.findViewById(R.id.product_price);

    }
}

public class OrderDetailAdapter extends RecyclerView.Adapter<MyViewHolder>  {

    List<Order> myOrders;

    public OrderDetailAdapter(List<Order> myOrders) {
        this.myOrders = myOrders;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_detail_layout,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Order order = myOrders.get(position);
        holder.name.setText(String.format("Nama : %s",order.getProductName()));
        holder.quantity.setText(String.format("Quantity : %s",order.getQuantity()));
        holder.price.setText(String.format("Harga Satuan : %s",order.getPrice()));
    }

    @Override
    public int getItemCount() {
        return myOrders.size();
    }
}