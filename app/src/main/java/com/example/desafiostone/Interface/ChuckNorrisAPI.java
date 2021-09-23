package com.example.desafiostone.Interface;

import com.example.desafiostone.model.FreeTextSearch;
import com.example.desafiostone.model.Piada;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ChuckNorrisAPI {
        @GET("jokes/random")
        Call<Piada> buscarPiadaPorCategoria(@Query("category") String category);

        @GET("jokes/categories")
        Call<String[]> listaDeCategoria();

        @GET("jokes/search")
        Call<FreeTextSearch> listaDePesquisaEscrita(@Query("query") String query);
    }

