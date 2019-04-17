package com.arctouch.codechallenge.data

import com.arctouch.codechallenge.api.API_KEY
import com.arctouch.codechallenge.api.DEFAULT_LANGUAGE
import com.arctouch.codechallenge.api.DEFAULT_REGION
import com.arctouch.codechallenge.api.TmdbApi
import com.arctouch.codechallenge.model.GenreResponse
import com.arctouch.codechallenge.model.Movie
import com.arctouch.codechallenge.model.UpcomingMoviesResponse
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