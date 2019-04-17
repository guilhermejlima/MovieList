package com.arctouch.codechallenge.home

import android.view.View
import com.arctouch.codechallenge.api.*
import com.arctouch.codechallenge.data.Cache
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class HomePresenter(private val view: HomeInterface.View){


    fun onCreateCalled(){
        val client = Client()
        val api = client.getClient().create(TmdbApi::class.java)
        loadGenres(api)
        loadMovies(api)
    }

    private fun loadMovies(api: TmdbApi){
        api.upcomingMovies(API_KEY, DEFAULT_LANGUAGE, 1, DEFAULT_REGION)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    val moviesWithGenres = it.results.map { movie ->
                        movie.copy(genres = Cache.genres.filter { movie.genreIds?.contains(it.id) == true })
                    }
                    view.createAdapter(moviesWithGenres)
                    view.setProgressBar(View.GONE)

                }
    }

    private fun loadGenres(api: TmdbApi){
        api.genres(API_KEY, DEFAULT_LANGUAGE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Cache.cacheGenres(it.genres)

                }


    }
}