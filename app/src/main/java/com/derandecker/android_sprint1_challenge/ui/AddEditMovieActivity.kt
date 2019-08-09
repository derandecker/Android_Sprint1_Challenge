package com.derandecker.android_sprint1_challenge.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
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
            loadMovieInfo(bundle!!.getSerializable(MainActivity.TEXTVIEW_MOVIE_CODE) as Movie)
        }

        button_save.setOnClickListener {
           var intent = Intent()
            intent.putExtra(MainActivity.TEXTVIEW_MOVIE_CODE, createMovie())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        button_delete.setOnClickListener {
            finish()
        }


    }

    fun loadMovieInfo (movie: Movie){
        et_movie_title.setText(movie.title)
    }

    fun createMovie(): Movie {
        return Movie(et_movie_title.text.toString(), checkbox_seen_movie.isChecked)
    }
}



