package com.androidtutz.anushka.tmdbclient.adapter;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidtutz.anushka.tmdbclient.R;
import com.androidtutz.anushka.tmdbclient.databinding.MovieListItemBinding;
import com.androidtutz.anushka.tmdbclient.model.Movie;
import com.androidtutz.anushka.tmdbclient.view.MovieActivity;

/**
 * Created by K. A. ANUSHKA MADUSANKA on 7/10/2018.
 */
public class MovieAdapter extends PagedListAdapter<Movie,MovieAdapter.MovieViewHolder> {

    private Context context;

    public MovieAdapter(Context context) {
        super(Movie.CALLBACK);
        this.context = context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         MovieListItemBinding movieListItemBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
         ,R.layout.movie_list_item,parent,false);

        return new MovieViewHolder(movieListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.movieListItemBinding.setMovie(getItem(position));
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
     private MovieListItemBinding movieListItemBinding;


        public MovieViewHolder(@NonNull MovieListItemBinding movieListItemBinding) {
            super(movieListItemBinding.getRoot());
            this.movieListItemBinding=movieListItemBinding;

            movieListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int position=getAdapterPosition();

                    if(position!=RecyclerView.NO_POSITION) {

                        Movie selctedMovie = getItem(position);

                        Intent intent=new Intent(context, MovieActivity.class);
                        intent.putExtra("movie",selctedMovie);
                        context.startActivity(intent);



                    }


                }
            });


        }
    }
}
