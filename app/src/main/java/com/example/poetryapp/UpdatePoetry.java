package com.example.poetryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.Toast;

import com.example.poetryapp.Api.ApiClient;
import com.example.poetryapp.Api.ApiInterface;
import com.example.poetryapp.Response.DeleteResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UpdatePoetry extends AppCompatActivity {
    EditText poetryData;
    AppCompatButton submitBtn;
    int poetryId;
    String poetryDataString;
    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_poetry);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        intialization();

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p_data = poetryData.getText().toString();
                if (p_data.equals("")){
                    poetryData.setError("Field is Empty");
                }
                else{
                    callApi(p_data,poetryId+"");
                    finish();
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
        poetryData = findViewById(R.id.update_poetry_data_edittext);
        submitBtn = findViewById(R.id.update_submit_data_btn);
        Retrofit retrofit = ApiClient.getClient();
        apiInterface = retrofit.create(ApiInterface.class);

        poetryId = getIntent().getIntExtra("p_id",0);
        poetryDataString = getIntent().getStringExtra("p_data");
        poetryData.setText(poetryDataString);
    }

    private void callApi(String pData,String pid){
        apiInterface.updatepoetry(pData,pid).enqueue(new Callback<DeleteResponse>() {
            @Override
            public void onResponse(Call<DeleteResponse> call, Response<DeleteResponse> response) {
                try {
                    if (response.body().getStatus().equals("1")){
                        Toast.makeText(UpdatePoetry.this,"Updated Successfully",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(UpdatePoetry.this,"Not Updated Successfully",Toast.LENGTH_SHORT).show();
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