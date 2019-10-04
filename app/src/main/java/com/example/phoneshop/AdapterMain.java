package com.example.phoneshop;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class AdapterMain extends RecyclerView.Adapter<AdapterMain.DrawerViewHolder> {

    private Context context;
    private String[] phoneNames;
    private String[] phonePrices;
    private String[] phoneImageUrls;
    private String[] phoneBattery;
    private String[] phoneBrand;
    private String[] phoneMemory;
    private String[] phoneWeight;
    private String[] phoneScreenSize;

    public void setPhoneNames(String[] phoneNames) {
        this.phoneNames = phoneNames;
        notifyDataSetChanged();
    }

    public void setPhonePrices(String[] phonePrices) {
        this.phonePrices = phonePrices;
        notifyDataSetChanged();
    }

    public void setPhoneImageUrls(String[] phoneImageUrls) {
        this.phoneImageUrls = phoneImageUrls;
        notifyDataSetChanged();
    }

    public void setPhoneBattery(String[] phoneBattery) {
        this.phoneBattery = phoneBattery;
        notifyDataSetChanged();
    }

    public void setPhoneBrand(String[] phoneBrand) {
        this.phoneBrand = phoneBrand;
        notifyDataSetChanged();
    }

    public void setPhoneMemory(String[] phoneMemory) {
        this.phoneMemory = phoneMemory;
        notifyDataSetChanged();
    }

    public void setPhoneWeight(String[] phoneWeight) {
        this.phoneWeight = phoneWeight;
        notifyDataSetChanged();
    }

    public void setPhoneScreenSize(String[] phoneScreenSize) {
        this.phoneScreenSize = phoneScreenSize;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DrawerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = layoutInflater.inflate(R.layout.viewholder_phone_main, viewGroup, false);
        DrawerViewHolder viewHolder = new DrawerViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DrawerViewHolder drawerViewHolder, final int i) {
        String phoneName = phoneNames[i];
        String phonePrice = phonePrices[i];
        String imageUrl = phoneImageUrls[i];
        String Battery = phoneBattery[i];
        String Brand = phoneBrand[i];
        String Memory = phoneMemory[i];
        String Weight = phoneWeight[i];
        String ScreenSize = phoneScreenSize[i];

        drawerViewHolder.txtPhoneName.setText(phoneName);
        drawerViewHolder.txtPhonePrice.setText(phonePrice);
        context = drawerViewHolder.imgUrl.getContext();
        Picasso.with(context).load(imageUrl).into(drawerViewHolder.imgUrl);

        drawerViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ActivityMainDetail.class);
                intent.putExtra("imageUrl", phoneImageUrls[i]);
                intent.putExtra("phoneName", phoneNames[i]);
                intent.putExtra("phonePrice", phonePrices[i]);
                intent.putExtra("Battery", phoneBattery[i]);
                intent.putExtra("Brand", phoneBrand[i]);
                intent.putExtra("Memory", phoneMemory[i]);
                intent.putExtra("Weight", phoneWeight[i]);
                intent.putExtra("ScreenSize", phoneScreenSize[i]);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (phoneNames == null){
            return 0;
        }else {
            return phoneNames.length;
        }
    }

    class DrawerViewHolder extends RecyclerView.ViewHolder {

        private TextView txtPhoneName;
        private TextView txtPhonePrice;
        private ImageView imgUrl;
        private CardView cardView;

        public DrawerViewHolder(@NonNull View itemView) {
            super(itemView);

            txtPhoneName = itemView.findViewById(R.id.txtName);
            txtPhonePrice = itemView.findViewById(R.id.txtPrice);
            imgUrl = itemView.findViewById(R.id.imgViewHolder);
            cardView = itemView.findViewById(R.id.cardView);

        }

    }
}
