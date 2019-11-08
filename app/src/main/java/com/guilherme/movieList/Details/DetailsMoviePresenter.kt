package com.guilherme.movieList.Details

import android.annotation.SuppressLint
import android.view.View
import com.guilherme.movieList.api.Client
import com.guilherme.movieList.api.TmdbApi
import com.guilherme.movieList.data.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class DetailsMoviePresenter(

    private val view: DetailsMovieInterface.View){

    fun onCreateCalled(repository: Repository){
        val client = Client()
        client.getClient().create(TmdbApi::class.java).also {
            loadMovieDetail(it,repository)
        }
    }

    @SuppressLint("CheckResult")
    fun loadMovieDetail(api:TmdbApi, repository: Repository){
        repository.callMovie(api = api, id = view.receiveId())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    view.setProgressBar(View.GONE)
                    view.createDetailScreen(it)
                }
    }

}