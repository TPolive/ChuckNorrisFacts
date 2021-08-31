package com.example.desafiostone;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desafiostone.model.Piada;
import com.example.desafiostone.network.Retrofit;

import java.net.UnknownHostException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TerceiraTela extends AppCompatActivity implements OnSelectCategories {

    public RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terceiratela);

        recyclerView = findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));

        new Retrofit().createRetrofit().listaDeCategoria().enqueue(new Callback<String[]> () {

            @Override
            public void onResponse(Call<String[]> call, Response<String[]> response) {

                if (response.isSuccessful()) {

                    recyclerView.setAdapter(new AdaptadorDeCategorias(response.body(),TerceiraTela.this));

                }

            }

            @Override
            public void onFailure(Call<String[]> call,Throwable t) {


            }
        });
    }

    @Override
    public void onSelectCategories(String categories) {

        startActivity(
                new Intent(this,MainActivity.class).putExtra("pesquisaTela1",categories));
    }
}

interface OnSelectCategories {

    public void onSelectCategories(String categories);
}