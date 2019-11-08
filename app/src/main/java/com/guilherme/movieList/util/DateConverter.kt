package com.guilherme.movieList.util



fun String.converter(): String {
        val data = this.split("-")
        return "${data[2]}/${data[1]}/${data[0]}"

}
