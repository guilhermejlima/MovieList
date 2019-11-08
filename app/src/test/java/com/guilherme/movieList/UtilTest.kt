package com.guilherme.movieList

import com.guilherme.movieList.util.converter
import org.junit.Assert.assertEquals
import org.junit.Test


class UtilTest {
    @Test
    fun `test converter date`(){
        val a = "2019-11-14"

        assertEquals("14/11/2019", a.converter() )
    }
}