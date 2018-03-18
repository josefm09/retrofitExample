package com.example.flariz.retrofitexample.service;

import com.example.flariz.retrofitexample.model.PokemonFeed;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestClient {
    @GET("pokemon")
    Call<PokemonFeed> getData();

}