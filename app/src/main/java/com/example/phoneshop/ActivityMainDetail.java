package com.example.phoneshop;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

public class ActivityMainDetail extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detail);

        Toolbar toolbar = findViewById(R.id.toolbarMainDetail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Phone Detail");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getIncomingIntent();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void getIncomingIntent(){

            String imageUrl = getIntent().getStringExtra("imageUrl");
            String phoneName = getIntent().getStringExtra("phoneName");
            String phonePrice = getIntent().getStringExtra("phonePrice");
            String Battery = getIntent().getStringExtra("Battery");
            String Brand = getIntent().getStringExtra("Brand");
            String Memory = getIntent().getStringExtra("Memory");
            String Weight = getIntent().getStringExtra("Weight");
            String ScreenSize = getIntent().getStringExtra("ScreenSize");

            setImage(imageUrl, phoneName, phonePrice, Battery, Brand, Memory, Weight, ScreenSize);
    }
    private void setImage(String imageUrl, String phoneName, String phonePrice, String Battery, String Brand, String Memory, String Weight, String ScreenSize){

        ImageView image = findViewById(R.id.imgDetail);
        Picasso.with(this).load(imageUrl).into(image);

        TextView name = findViewById(R.id.txtDetailName);
        name.setText(phoneName);

        TextView price = findViewById(R.id.txtDetailPrice);
        price.setText(phonePrice);

        TextView battery = findViewById(R.id.txtDetailBattery);
        battery.setText(Battery);

        TextView brand = findViewById(R.id.txtDetailBrand);
        brand.setText(Brand);

        TextView memory = findViewById(R.id.txtDetailMemory);
        memory.setText(Memory);

        TextView weight = findViewById(R.id.txtDetailWeight);
        weight.setText(Weight);

        TextView screenSize = findViewById(R.id.txtDetailScreenSize);
        screenSize.setText(ScreenSize);
    }
}