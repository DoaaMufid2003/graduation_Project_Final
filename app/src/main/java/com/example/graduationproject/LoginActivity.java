package com.example.graduationproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.graduationproject.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
ActivityLoginBinding binding;
FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseAuth=FirebaseAuth.getInstance();

        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();

        if (user!=null){
            startActivity(new Intent(getApplicationContext(), HomeActivity.class));

        }
        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

startActivity(new Intent(LoginActivity.this,RegisterActivity.class));

            }
        });
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password=binding.etPassword.getText().toString();
                String email=binding.etPassword.getText().toString();

if (password.isEmpty()&&email.isEmpty()){
    Toast.makeText(LoginActivity.this, "All fields must be filled in", Toast.LENGTH_SHORT).show();


}else {
    login();
}


            }
        });

    }

    private void login(){


        String password=binding.etPassword.getText().toString();
        String email=binding.etEmail.getText().toString();

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Log.d("Login",task.getResult().getUser().toString());
                    startActivity(new Intent(getApplicationContext(), ProductiveFamilyProfile.class));
                }else {
                    Log.d("Login",task.getException().getMessage());

                    Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        })
        ;
    }

}

