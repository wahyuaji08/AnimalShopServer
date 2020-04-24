package com.example.wahyuajisantoso.animalserver.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wahyuajisantoso.animalserver.Common.Common;
import com.example.wahyuajisantoso.animalserver.Interface.ItemClickListener;
import com.example.wahyuajisantoso.animalserver.R;


public class AnimalViewHolder extends RecyclerView.ViewHolder implements
        View.OnClickListener,
        View.OnCreateContextMenuListener
{

    public TextView animal_name;
    public ImageView animal_image;

    private ItemClickListener itemClickListener;

    public AnimalViewHolder(View itemView) {
        super(itemView);

        animal_name = (TextView)itemView.findViewById(R.id.animal_name);
        animal_image = (ImageView) itemView.findViewById(R.id.animal_image);

        itemView.setOnCreateContextMenuListener(this);
        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);

    }

    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        contextMenu.setHeaderTitle("Select Action");

        contextMenu.add(0,0,getAdapterPosition(), Common.UPDATE);
        contextMenu.add(0,1,getAdapterPosition(), Common.DELETE);
    }
}
