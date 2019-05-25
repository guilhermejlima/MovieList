package com.arctouch.codechallenge.home

import android.view.View
import com.arctouch.codechallenge.api.*
import com.arctouch.codechallenge.data.Cache
import com.arctouch.codechallenge.data.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class HomePresenter(private val view: HomeInterface.View){


    fun onCreateCalled(repository: Repository){
        val client = Client()
        val api = client.getClient().create(TmdbApi::class.java)
        loadGenres(api, repository)
        loadMovies(api, repository)
    }

    private fun loadMovies(api: TmdbApi,repository: Repository){
        repository.callListOfMovies(api,1)
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

    private fun loadGenres(api: TmdbApi,repository: Repository){
        repository.callListOfGenres(api)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Cache.cacheGenres(it.genres)

            }


    }
}