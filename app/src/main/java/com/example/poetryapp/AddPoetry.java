package com.example.poetryapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.poetryapp.Api.ApiClient;
import com.example.poetryapp.Api.ApiInterface;
import com.example.poetryapp.Response.DeleteResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AddPoetry extends AppCompatActivity {
    EditText poetName;
    EditText poetrydata;
    AppCompatButton submitBtn;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_poetry);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        intialization();

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String poetNameString = poetName.getText().toString();
                String poetryDataString = poetrydata.getText().toString();

                if(poetNameString.equals("")) {
                    poetName.setError("Field is empty");
                } else {
                    if(poetryDataString.equals("")) {
                        poetrydata.setError("Field is empty");
                    } else {
                        callapi(poetryDataString,poetNameString);
                        finish();
                    }
                }
            }
        });

    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void intialization() {
        poetName = findViewById(R.id.poetName);
        poetrydata = findViewById(R.id.poetryName);
        submitBtn = findViewById(R.id.addpoetry);
        Retrofit retrofit = ApiClient.getClient();
        apiInterface = retrofit.create(ApiInterface.class);
    }

    private void callapi(String poetryData,String poetName){
        apiInterface.addpoetry(poetryData,poetName).enqueue(new Callback<DeleteResponse>() {
            @Override
            public void onResponse(Call<DeleteResponse> call, Response<DeleteResponse> response) {
                try {
                    if (response.body().getStatus().equals("1")){
                        Toast.makeText(AddPoetry.this,"Added Successfully",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(AddPoetry.this,"Not Added Successfully",Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Log.e("Exp", e.getLocalizedMessage());
                }
            }

            @Override
            public void onFailure(Call<DeleteResponse> call, Throwable t) {
                Log.e("Failure", t.getLocalizedMessage());
            }
        });
    }
}