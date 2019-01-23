package com.example.android.food_order;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateAccount extends AppCompatActivity implements View.OnClickListener{
    Button button;
    EditText editTextName, editTextMobileNumber, editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        button = (Button) findViewById(R.id.createAccount2);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextMobileNumber = (EditText) findViewById(R.id.editTextMobileNumber);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        button.setOnClickListener(this);
    }



    private void userSignUp() {

        Intent intent =new Intent(this,otpPage.class);
        startActivity(intent);
        String name = editTextName.getText().toString().trim();
        String mobileNumber = editTextMobileNumber.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
       /* if(!email.isEmpty()){
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }*/
       if(!email.isEmpty()) {
           if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
               editTextEmail.setError("Enter a valid email");
               editTextEmail.requestFocus();
               return;
           }
       }
        if (password.isEmpty()) {
            editTextPassword.setError("Password required");
            editTextPassword.requestFocus();
            return;
        }
        if (password.length() < 6) {
            editTextPassword.setError("Password should be atleast 6 character long");
            editTextPassword.requestFocus();
            return;
        }
        if (name.isEmpty()) {
            editTextName.setError("Name required");
            editTextName.requestFocus();
            return;
        }
        if (mobileNumber.isEmpty()) {
            editTextMobileNumber.setError("School required");
            editTextMobileNumber.requestFocus();
            return;
        }
        Call<ResponseBody> call = ApiClient
                .getInstance()
                .getApi()
                .createUser(name, mobileNumber, email, password);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String s = response.body().string();
                    Toast.makeText(CreateAccount.this,"dahdakjdku",Toast.LENGTH_SHORT).show();
                    Toast.makeText(CreateAccount.this, s, Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            /* Do user registration using the api call*/
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(CreateAccount.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.createAccount2:
                userSignUp();
                break;
                }
                }
}
