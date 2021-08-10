package com.example.startup.activities.adaptars;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.startup.R;
import com.example.startup.activities.Models.prods;
import com.example.startup.activities.utils.colorPicker;
import com.example.startup.activities.utils.iconPicker;

import java.util.ArrayList;

public class prodAdapter extends RecyclerView.Adapter<prodAdapter.viewHolder> {

    ArrayList<prods> productsadapt;

    public prodAdapter(ArrayList<prods> productsadapt) {
        this.productsadapt = productsadapt;

    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.buyers_item, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.textViewTitle.setText(productsadapt.get(position).title);
        colorPicker colorP = new colorPicker();
        iconPicker iconP = new iconPicker();
        holder.cardContainer.setCardBackgroundColor(Color.parseColor(colorP.getColor()));
        holder.iconView.setImageResource(iconP.getIcon());
    }

    @Override
    public int getItemCount() {
        return productsadapt.size();
    }


    public static class viewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle,prodprice;
        ImageView iconView;
        CardView cardContainer;


        public viewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.prodtitle);
            iconView = itemView.findViewById(R.id.prodIcon);
            cardContainer = itemView.findViewById(R.id.cardContainer);
            prodprice=itemView.findViewById(R.id.prodprice);

        }

    }


}
