package com.guilherme.movieList.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.guilherme.movieList.R
import com.guilherme.movieList.data.Repository
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

    override fun createAdapter(moviesWithGenres:List<com.guilherme.movieList.model.Movie>) {
        recyclerView.adapter = HomeAdapter(moviesWithGenres)

    }

    override fun setProgressBar(status:Int) {
        progressBar.visibility = status
    }


}
