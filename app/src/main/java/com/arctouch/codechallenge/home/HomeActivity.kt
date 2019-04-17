package com.arctouch.codechallenge.home

import android.graphics.Movie
import android.os.Bundle
import android.view.View
import com.arctouch.codechallenge.R
import com.arctouch.codechallenge.api.API_KEY
import com.arctouch.codechallenge.api.DEFAULT_LANGUAGE
import com.arctouch.codechallenge.api.DEFAULT_REGION
import com.arctouch.codechallenge.api.TmdbApi
import com.arctouch.codechallenge.base.BaseActivity
import com.arctouch.codechallenge.data.Cache
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.home_activity.*

class HomeActivity:BaseActivity(),HomeInterface.View {

    lateinit var homePresenter: HomePresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        homePresenter = HomePresenter(this)
        homePresenter.onCreateCalled()

    }

    override fun createAdapter(moviesWithGenres:List<com.arctouch.codechallenge.model.Movie>) {
        recyclerView.adapter = HomeAdapter(moviesWithGenres)

    }

    override fun setProgressBar(status:Int) {
        progressBar.visibility = status
    }


}
