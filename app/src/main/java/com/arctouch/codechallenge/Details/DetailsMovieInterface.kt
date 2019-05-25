package com.arctouch.codechallenge.Details

import com.arctouch.codechallenge.model.Movie

interface DetailsMovieInterface {
    interface View{
        fun createDetailScreen(movie:Movie)
        fun receiveId():Long
    }

}