package com.example.sveta.firstapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class APIActivity extends AppCompatActivity{

    private RecyclerView _recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        TextView head_text = (TextView) findViewById(R.id.header);
        head_text.setText("API Activity");

        final EditText enter_text = (EditText) findViewById(R.id.enter_text);
        ImageButton buttonSearch = (ImageButton) findViewById(R.id.buttonSearch);

        View.OnClickListener buttonSearchListener = new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Retrofit retrofit =  new Retrofit.Builder()
                        .baseUrl("http://makeup-api.herokuapp.com/api/v1/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                _recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                ProductService service = retrofit.create(ProductService.class);
                String userText = enter_text.getText().toString();
                Call<List<Product>> call = service.listRepos(userText);

                call.enqueue(new Callback<List<Product>>() {
                    @Override
                    public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                        List<Product> products = response.body();
                        ProductAdapter adapter = new ProductAdapter(APIActivity.this, products);
                        _recyclerView.setAdapter(adapter);
                        _recyclerView.setLayoutManager(new LinearLayoutManager(APIActivity.this));
                    }

                    @Override
                    public void onFailure(Call<List<Product>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error occured " + t.getCause().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
        buttonSearch.setOnClickListener(buttonSearchListener);
    }
}
