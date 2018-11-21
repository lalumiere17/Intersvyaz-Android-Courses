package com.example.sveta.firstapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ProductService
{
    @GET("products.json?")
    Call<List<Product>> listRepos(@Query("brand") String name);
}
