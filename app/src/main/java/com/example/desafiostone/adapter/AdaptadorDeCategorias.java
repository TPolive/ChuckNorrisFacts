package com.example.desafiostone.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desafiostone.Interface.OnSelectCategories;
import com.example.desafiostone.R;

public class AdaptadorDeCategorias extends RecyclerView.Adapter<AdaptadorDeCategorias.ViewHolder> {
    public String[] categorias;
    public OnSelectCategories onSelectCategories;

    public AdaptadorDeCategorias(String[]categorias,OnSelectCategories onSelectCategories){

    this.categorias = categorias;
    this.onSelectCategories = onSelectCategories;
}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.itemcategoria, parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        TextView label1 = holder.itemView.findViewById(R.id.label);
        label1.setText(categorias[position]);
        label1.setOnClickListener(v -> {
            onSelectCategories.onSelectCategories(categorias[position]);
        });
    }

    @Override
    public int getItemCount() {
        return categorias.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
