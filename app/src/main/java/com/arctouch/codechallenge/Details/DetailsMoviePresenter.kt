package com.arctouch.codechallenge.Details

import com.arctouch.codechallenge.api.API_KEY
import com.arctouch.codechallenge.api.Client
import com.arctouch.codechallenge.api.DEFAULT_LANGUAGE
import com.arctouch.codechallenge.api.TmdbApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DetailsMoviePresenter(

    private val view: DetailsMovieInterface.View){

    fun onCreateCalled(){
        val client = Client()
        val api = client.getClient().create(TmdbApi::class.java)
        loadMovieDetail(api)
    }

    fun loadMovieDetail(api:TmdbApi){
        api.movie(view.receiveId(), API_KEY, DEFAULT_LANGUAGE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    view.createDetailScreen(it)

                }
    }

}