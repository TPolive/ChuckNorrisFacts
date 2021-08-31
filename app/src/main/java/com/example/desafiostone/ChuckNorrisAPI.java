package com.example.desafiostone;

import com.example.desafiostone.model.Piada;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ChuckNorrisAPI {
        @GET("jokes/random")
        Call<Piada> buscarPiadaPorCategoria(@Query("category") String category);

        @GET("jokes/categories")
        Call<String[]> listaDeCategoria();
    }

