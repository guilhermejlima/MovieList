package com.guilherme.movieList.home

interface HomeInterface {

    interface View{

        fun createAdapter(moviesWithGenres:List<com.guilherme.movieList.model.Movie>)
        fun setProgressBar(status:Int)
    }
}