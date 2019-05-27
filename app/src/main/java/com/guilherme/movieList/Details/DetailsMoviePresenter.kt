package com.guilherme.movieList.Details

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
        val api = client.getClient().create(TmdbApi::class.java)
        loadMovieDetail(api,repository)
    }

    fun loadMovieDetail(api:TmdbApi, repository: Repository){
        repository.callMovie(api,view.receiveId())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    view.setProgressBar(View.GONE)
                    view.createDetailScreen(it)
                }
    }

}