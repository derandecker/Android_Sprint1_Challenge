package com.derandecker.android_sprint1_challenge.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.derandecker.android_sprint1_challenge.R
import com.derandecker.android_sprint1_challenge.model.Movie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var movieList = mutableListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        linear_layout_movie_list.addView(view)
    }


    override fun onPostResume() {
        refreshMovies()
        super.onPostResume()
    }

    fun refreshMovies() {
        linear_layout_movie_list.removeAllViews()
        movieList.forEachIndexed { index, movie ->
            val view: View = createTextView(movie, index)
            linear_layout_movie_list.addView(view)
        }

    }
}

