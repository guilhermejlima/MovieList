package com.arctouch.codechallenge.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.arctouch.codechallenge.R
import com.arctouch.codechallenge.data.Repository
import kotlinx.android.synthetic.main.home_activity.*

class HomeActivity:AppCompatActivity(),HomeInterface.View {

    lateinit var homePresenter: HomePresenter
    lateinit var repository: Repository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        homePresenter = HomePresenter(this)
        repository = Repository()
        homePresenter.onCreateCalled(repository)

    }

    override fun createAdapter(moviesWithGenres:List<com.arctouch.codechallenge.model.Movie>) {
        recyclerView.adapter = HomeAdapter(moviesWithGenres)

    }

    override fun setProgressBar(status:Int) {
        progressBar.visibility = status
    }


}
