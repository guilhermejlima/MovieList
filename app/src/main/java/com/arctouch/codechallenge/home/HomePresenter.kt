package com.arctouch.codechallenge.home

import android.util.Log
import android.view.View
import com.arctouch.codechallenge.api.API_KEY
import com.arctouch.codechallenge.api.DEFAULT_LANGUAGE
import com.arctouch.codechallenge.api.DEFAULT_REGION
import com.arctouch.codechallenge.base.BaseActivity
import com.arctouch.codechallenge.data.Cache
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class HomePresenter(private val view: HomeInterface.View): BaseActivity(){

    fun onCreateCalled(){
        loadGenres()
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

    private fun loadGenres(){
        api.genres(API_KEY, DEFAULT_LANGUAGE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Cache.cacheGenres(it.genres)

                }


    }
}