package com.example.desafiostone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.UnknownHostException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public ImageView pesquisar;
    public TextView piadaNaTela1;
    public TextView categoriaNaTela1;
    public ConstraintLayout constrainPiada1;
    public TextView erroInternet1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        piadaNaTela1 = findViewById(R.id.piadaNaTela);
        categoriaNaTela1 = findViewById(R.id.categoriaNaTela);
        constrainPiada1 = findViewById(R.id.constrainPiada);
        erroInternet1 = findViewById(R.id.erroInternet);

        String categorias = getIntent().getStringExtra("pesquisaTela1");
        Toast.makeText(this,categorias, Toast.LENGTH_SHORT).show();

        if (categorias != null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.chucknorris.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ChuckNorrisAPI service = retrofit.create(ChuckNorrisAPI.class);

            service.listRepos(categorias).enqueue(new Callback<Piada>() {
                @Override
                public void onResponse(Call<Piada> call, Response<Piada> response) {

                    if (response.isSuccessful()) {
                        Piada piada = response.body();
                        piadaNaTela1.setText(response.body().value);
                        constrainPiada1.setVisibility(View.VISIBLE);
                        categoriaNaTela1.setText(piada.categories[0]);

                    } else if (response.code() == 404) {

                        erroInternet1.setVisibility(View.VISIBLE);
                        erroInternet1.setText("Esta categoria não está disponível");

                    } else if (response.code() >= 400) {

                        erroInternet1.setVisibility(View.VISIBLE);
                        erroInternet1.setText("Houve algum erro de conexão");
                    }
                }

                @Override
                public void onFailure(Call<Piada> call,Throwable t) {

                 if (t instanceof UnknownHostException){

                     erroInternet1.setVisibility(View.VISIBLE);

                 }
                }
            });

        }

    }

    public void telaPesquisa (View view){
        pesquisar = findViewById(R.id.search1);

        startActivity(new Intent(this,SegundaTela.class));

        //Toast.makeText(this,"Clicado", Toast.LENGTH_SHORT).show();
    }
}