package com.example.desafiostone;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ChuckNorrisAPI {
        @GET("jokes/random")
        Call<Piada> listRepos(@Query("category") String category);
    }

