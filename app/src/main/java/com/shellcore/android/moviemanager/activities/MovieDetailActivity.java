package com.shellcore.android.moviemanager.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shellcore.android.moviemanager.R;
import com.shellcore.android.moviemanager.model.Movie;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailActivity extends AppCompatActivity {

    // Components
    @BindView(R.id.img_movie_backdrop)
    ImageView imgMovieBackdrop;
    @BindView(R.id.txt_overview)
    TextView txtOverview;

    // Variables
    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Movie saved as favorite", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            movie = (Movie) extras.getSerializable("MOVIE");
            this.setTitle(movie.getTitle());
            txtOverview.setText(movie.getOverview());
            Picasso.with(this)
                    .load(movie.getBackdropPath())
                    .into(imgMovieBackdrop);
        }
    }
}
