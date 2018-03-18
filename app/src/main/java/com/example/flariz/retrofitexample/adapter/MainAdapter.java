package com.example.flariz.retrofitexample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.flariz.retrofitexample.R;
import com.example.flariz.retrofitexample.model.Result;
import com.example.flariz.retrofitexample.view.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.PokemonViewHolder> {

    private List<Result> list;
    private Context context;
    private MainActivity view;

    public MainAdapter(Context context, MainActivity view) {
        this.list = new ArrayList<>();

        this.context = context;
        this.view = view;
    }

    public void swap(List<Result> newList) {
        list.clear();
        list.addAll(newList);
        notifyDataSetChanged();

    }

    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PokemonViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false));
    }

    @Override
    public void onBindViewHolder(PokemonViewHolder holder, final int position) {
        final Result pokemon = list.get(position);
        holder.tvName.setText(pokemon.getName());
        holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view != null) {
                    view.navigateToDetails(position+1);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class PokemonViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;

        public PokemonViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView)itemView.findViewById(R.id.tv_name);
        }

    }
}
