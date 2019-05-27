package com.guilherme.movieList.Details

import com.guilherme.movieList.model.Movie

interface DetailsMovieInterface {
    interface View{
        fun createDetailScreen(movie:Movie)
        fun receiveId():Long
        fun setProgressBar(status:Int)
    }

}