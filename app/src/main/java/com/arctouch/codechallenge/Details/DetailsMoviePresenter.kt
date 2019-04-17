package com.arctouch.codechallenge.Details

import com.arctouch.codechallenge.api.API_KEY
import com.arctouch.codechallenge.api.Client
import com.arctouch.codechallenge.api.DEFAULT_LANGUAGE
import com.arctouch.codechallenge.api.TmdbApi
import com.arctouch.codechallenge.data.Repository
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
                view.createDetailScreen(it)

            }
    }

}