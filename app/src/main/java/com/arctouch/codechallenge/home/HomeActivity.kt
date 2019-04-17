package com.arctouch.codechallenge.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.arctouch.codechallenge.R
import kotlinx.android.synthetic.main.home_activity.*

class HomeActivity:AppCompatActivity(),HomeInterface.View {

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
