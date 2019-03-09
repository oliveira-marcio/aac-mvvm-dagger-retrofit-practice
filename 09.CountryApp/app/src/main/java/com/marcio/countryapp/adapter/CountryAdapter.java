package com.marcio.countryapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.marcio.countryapp.R;
import com.marcio.countryapp.model.Result;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    List<Result> countriesList;

    public CountryAdapter(List<Result> countriesList) {
        this.countriesList = countriesList;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_country, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.coutryNameTextView.setText(countriesList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return countriesList != null ? countriesList.size() : 0;
    }

    class CountryViewHolder extends RecyclerView.ViewHolder {

        TextView coutryNameTextView;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);

            coutryNameTextView = itemView.findViewById(R.id.tv_country_name);
        }
    }
}
