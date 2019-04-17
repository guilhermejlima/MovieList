package com.arctouch.codechallenge.home

interface HomeInterface {

    interface View{

        fun createAdapter(moviesWithGenres:List<com.arctouch.codechallenge.model.Movie>)
        fun setProgressBar(status:Int)
    }
}