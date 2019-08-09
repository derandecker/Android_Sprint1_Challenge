package com.derandecker.android_sprint1_challenge.ui

import android.app.Activity
import android.content.Intent
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

    companion object {
        const val ADD_EDIT_MOVIE_REQUEST_CODE = 2

        const val TEXTVIEW_MOVIE_CODE = "textview_movie"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_add_movie.setOnClickListener {
            var intent = Intent(this, AddEditMovieActivity::class.java)
            startActivityForResult(intent, ADD_EDIT_MOVIE_REQUEST_CODE)
        }

//       movieList.add(Movie("Back to the Future", false))
//        movieList.add(Movie("Crazy crazy", false))

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
        newMovieView.textSize = 28f

        when (movie.watched){
            true -> newMovieView.paintFlags = STRIKE_THRU_TEXT_FLAG
        }

        newMovieView.setOnClickListener {
            var intent = Intent(this, AddEditMovieActivity::class.java)
            intent.putExtra(TEXTVIEW_MOVIE_CODE, movieList[index])

            movieList.removeAt(index)

            startActivityForResult(intent, ADD_EDIT_MOVIE_REQUEST_CODE)
        }

        return newMovieView
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == ADD_EDIT_MOVIE_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            val newMovieResult = data!!.getSerializableExtra(TEXTVIEW_MOVIE_CODE) as Movie
            movieList.add(newMovieResult)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}

