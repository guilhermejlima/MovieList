package com.arctouch.codechallenge.Details

import com.arctouch.codechallenge.api.API_KEY
import com.arctouch.codechallenge.api.DEFAULT_LANGUAGE
import com.arctouch.codechallenge.base.BaseActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DetailsMoviePresenter(

    private val view: DetailsMovieInterface.View):BaseActivity() {

    fun onCreateCalled(){
        api.movie(view.receiveId(), API_KEY, DEFAULT_LANGUAGE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    view.createDetailScreen(it)

                }
    }

}