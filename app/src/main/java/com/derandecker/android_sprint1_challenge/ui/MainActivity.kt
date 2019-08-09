package com.derandecker.android_sprint1_challenge.ui

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.derandecker.android_sprint1_challenge.R
import com.derandecker.android_sprint1_challenge.model.Movie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var movieList = mutableListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       movieList.add(Movie("Back to the Future", true))
        movieList.add(Movie("Crazy crazy", false))

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

    fun createTextView(movie: Movie, index: Int): TextView {
        var newMovieView = TextView(this)
        newMovieView.id = index
        newMovieView.text = movie.title

        when (movie.watched){
            true -> newMovieView.paintFlags = STRIKE_THRU_TEXT_FLAG
        }

        return newMovieView
    }
}

