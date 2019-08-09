package com.derandecker.android_sprint1_challenge.ui

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import com.derandecker.android_sprint1_challenge.R
import com.derandecker.android_sprint1_challenge.model.Movie

import kotlinx.android.synthetic.main.activity_add_edit_movie.*

class AddEditMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_movie)

        var bundle: Bundle? = intent.extras
        if (bundle != null) {
            loadMovieInfo(bundle!!.getSerializable(MainActivity.TEXTVIEW_MOVIE) as Movie)
        }


    }

    fun loadMovieInfo (movie: Movie){
        et_movie_title.setText(movie.title)

    }
}

