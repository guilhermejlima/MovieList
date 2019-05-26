package com.guilherme.movieList.data

import com.guilherme.movieList.model.Genre

object Cache {

    var genres = listOf<Genre>()

    fun cacheGenres(genres: List<Genre>) {
        this.genres = genres
    }
}
