package com.example.desafiostone.network;

import com.example.desafiostone.Interface.ChuckNorrisAPI;

import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit {

    public ChuckNorrisAPI createRetrofit () {

        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl("https://api.chucknorris.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ChuckNorrisAPI.class);
    }
}
