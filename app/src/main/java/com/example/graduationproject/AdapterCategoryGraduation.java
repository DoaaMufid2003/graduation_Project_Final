package com.example.graduationproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.graduationproject.databinding.ItemCategoryGraduationBinding;
import com.example.graduationproject.model.Category;


import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

class AdapterCategoryGraduation extends RecyclerView.Adapter<AdapterCategoryGraduation.MyViewHolder> {
   List<Category> categories;
   Context context;
   Listener listener;

   //ListenerFavarite listenerFavarite;



   public AdapterCategoryGraduation(List<Category> categories, Context context,Listener listener) {
       this.categories = categories;
       this.context = context;
       this.listener=listener;


   }

   @NonNull
   @Override
   public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       ItemCategoryGraduationBinding binding = ItemCategoryGraduationBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
       return new MyViewHolder(binding);


   }


   @Override
   public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       int pos = position;
       holder.category_name.setText(categories.get(pos).getName());
       Glide.with(context).load(categories.get(position).getImage()).circleCrop().into(holder.imageView);
       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               listener.onClick(holder.category_name.getText().toString());
           }
       });



   }


   @Override
   public int getItemCount() {
       return categories.size();
   }

 public   class MyViewHolder extends RecyclerView.ViewHolder {
       TextView category_name;
       ImageView imageView;


       public MyViewHolder(@NonNull ItemCategoryGraduationBinding binding) {
           super(binding.getRoot());

           category_name = binding.textView;
           imageView = binding.image;



       }

   }
}
