package com.example.graduationproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.example.graduationproject.databinding.ActivityHomeBinding;
import com.example.graduationproject.model.Category;
import com.example.graduationproject.model.Product;
import com.example.graduationproject.model.ProductiveFamily;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding binding;
    FirebaseFirestore firestore;
    ArrayList<Category> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firestore = FirebaseFirestore.getInstance();

        firestore.collection("Category").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {

                    binding.progressBar2.setVisibility(View.GONE);

                    categories = (ArrayList<Category>) task.getResult().toObjects(Category.class);

                    AdapterCategoryGraduation adapterCategoryGraduation = new AdapterCategoryGraduation(categories, getBaseContext(), new Listener() {
                        @Override
                        public void onClick(String categoryName) {

                        }

                        @Override
                        public void onClickImage(String categoryName) {

                        }
                    });



                    binding.rv.setAdapter(adapterCategoryGraduation);

                    binding.rv.setLayoutManager(new GridLayoutManager(getBaseContext(), 2));
                    adapterCategoryGraduation.notifyDataSetChanged();


                }

            }
        });
    }

}