package com.example.graduationproject;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;

import com.example.graduationproject.ProdativeFamily.InformationProdectiveFamilyFragment;
import com.example.graduationproject.databinding.ActivityProductiveFamilyProfileBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;

public class ProductiveFamilyProfile extends AppCompatActivity {
    ActivityProductiveFamilyProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductiveFamilyProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<String> tabs = new ArrayList<>();
        tabs.add("Products");
        tabs.add("make Profile");


        ArrayList<Fragment> item_productArrayList = new ArrayList<>();
        item_productArrayList.add(ItemProductiveFamily.newInstance("Products"));
        item_productArrayList.add(InformationProdectiveFamilyFragment.newInstance());


        Log.d("productlist", item_productArrayList.toString());
        ItemProductAdapter itemProductAdapter = new ItemProductAdapter(this, item_productArrayList);
        binding.ViewPager.setAdapter(itemProductAdapter);
        new TabLayoutMediator(binding.tab, binding.ViewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(TabLayout.@NonNull Tab tab, int position) {
                tab.setText(tabs.get(position));
            }
        }).attach();
    }
}