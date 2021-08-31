package com.example.desafiostone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.desafiostone.network.Retrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SegundaTela extends AppCompatActivity {

    public TextView Games;
    public TextView Sports;
    public TextView Dev;
    public TextView Science;
    public TextView Technology;
    public TextView Music;
    public TextView Travel;
    public TextView Carrer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segundatela);

        Games = findViewById(R.id.games1);
        Sports = findViewById(R.id.sports1);
        Dev = findViewById(R.id.dev1);
        Science = findViewById(R.id.science1);
        Technology = findViewById(R.id.technology1);
        Music = findViewById(R.id.music1);
        Travel = findViewById(R.id.travel1);
        Carrer = findViewById(R.id.label);

        new Retrofit().createRetrofit().listaDeCategoria().enqueue(new Callback<String[]> () {

            @Override
            public void onResponse(Call<String[]> call, Response<String[]> response) {

               if (response.isSuccessful()) {


               }

            }

            @Override
            public void onFailure(Call<String[]> call,Throwable t) {


            }
        });;

        Games.setOnClickListener(v -> {

            startActivity(
                    new Intent(this,MainActivity.class).putExtra("pesquisaTela1","games"));
        });

        Sports.setOnClickListener(v -> {
            startActivity(
                    new Intent(this,MainActivity.class).putExtra("pesquisaTela1","sports"));
       });

        Dev.setOnClickListener(v -> {

            startActivity(
                    new Intent(this,MainActivity.class).putExtra("pesquisaTela1","dev"));
        });

        Science.setOnClickListener(v -> {

            startActivity(
                    new Intent(this,MainActivity.class).putExtra("pesquisaTela1","science"));
        });

        Technology.setOnClickListener(v -> {

            startActivity(
                    new Intent(this,MainActivity.class).putExtra("pesquisaTela1","technology"));
        });

        Music.setOnClickListener(v -> {

            startActivity(
                    new Intent(this,MainActivity.class).putExtra("pesquisaTela1","music"));
        });

        Travel.setOnClickListener(v -> {

            startActivity(
                    new Intent(this,MainActivity.class).putExtra("pesquisaTela1","travel"));
        });

        Carrer.setOnClickListener(v -> {

            startActivity(
                    new Intent(this,MainActivity.class).putExtra("pesquisaTela1","carrer"));
        });
    }

}
