package com.guilherme.movieList.data

import com.guilherme.movieList.api.API_KEY
import com.guilherme.movieList.api.DEFAULT_LANGUAGE
import com.guilherme.movieList.api.DEFAULT_REGION
import com.guilherme.movieList.api.TmdbApi
import com.guilherme.movieList.model.GenreResponse
import com.guilherme.movieList.model.Movie
import com.guilherme.movieList.model.UpcomingMoviesResponse
import io.reactivex.Observable

class Repository() {
    fun callMovie(api:TmdbApi,id:Long):Observable<Movie>{
        return api.movie(id, API_KEY, DEFAULT_LANGUAGE)
    }

    fun callListOfMovies(api:TmdbApi, page:Long):Observable<UpcomingMoviesResponse>{
        return api.upcomingMovies(API_KEY, DEFAULT_LANGUAGE,page, DEFAULT_REGION)
    }

    fun callListOfGenres(api:TmdbApi): Observable<GenreResponse> {
        return api.genres(API_KEY, DEFAULT_LANGUAGE)
    }
}