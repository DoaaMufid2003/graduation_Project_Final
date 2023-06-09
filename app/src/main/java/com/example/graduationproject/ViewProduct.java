package com.example.graduationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.graduationproject.databinding.ActivityViewProductBinding;

public class ViewProduct extends AppCompatActivity {
    ActivityViewProductBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        String price = intent.getStringExtra("price");
        String category = intent.getStringExtra("category");
        String description = intent.getStringExtra("description");
        String name = intent.getStringExtra("name");
        String image = intent.getStringExtra("image");
        binding.tvCategoryview.setText(category);
        binding.tvDescriptionview.setText(description);
        binding.tvPriceview.setText(price);
        binding.tvNameview.setText(name);
        Glide.with(getApplicationContext()).load(image).circleCrop().into(binding.uplodeimgview);


    }
}