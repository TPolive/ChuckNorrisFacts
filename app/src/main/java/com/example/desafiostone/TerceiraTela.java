package com.example.desafiostone;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desafiostone.Adapter.AdaptadorDeCategorias;
import com.example.desafiostone.Interface.OnSelectCategories;
import com.example.desafiostone.network.Retrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;

public class TerceiraTela extends AppCompatActivity implements OnSelectCategories {

    public RecyclerView recyclerView;
    public EditText editTextPersonName;
    public Button botaoDePesquisa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terceiratela);

        recyclerView = findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        editTextPersonName = findViewById(R.id.editTextPersonName);
        botaoDePesquisa = findViewById(R.id.botaoDePesquisa);
        editTextPersonName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                startActivity(
                        new Intent(TerceiraTela.this, MainActivity.class)
                                .putExtra("textoPesquisado", editTextPersonName.getText().toString()));
                return true;
            }
        });

        botaoDePesquisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(
                        new Intent(TerceiraTela.this, MainActivity.class)
                                .putExtra("textoPesquisado", editTextPersonName.getText().toString()));



            }
        });

        new Retrofit().createRetrofit().listaDeCategoria().enqueue(new Callback<String[]>() {

            @Override
            public void onResponse(Call<String[]> call, Response<String[]> response) {

                if (response.isSuccessful()) {

                    recyclerView.setAdapter(new AdaptadorDeCategorias(response.body(), TerceiraTela.this));

                }

            }

            @Override
            public void onFailure(Call<String[]> call, Throwable t) {


            }
        });
    }

    @Override
    public void onSelectCategories(String categories) {

        startActivity(
                new Intent(this, MainActivity.class).putExtra("pesquisaTela1", categories));
    }
}

