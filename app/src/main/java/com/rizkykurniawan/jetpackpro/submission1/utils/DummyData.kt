package com.rizkykurniawan.jetpackpro.submission1.utils

import com.rizkykurniawan.jetpackpro.submission1.R
import com.rizkykurniawan.jetpackpro.submission1.data.MovieEntity

object DummyData {
    fun generateDummyMovies(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        movies.add(MovieEntity(
                1,
                "A Star Is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "75%",
                "10/05/2018",
                R.drawable.poster_a_star_is_born
        ))
        movies.add(MovieEntity(
                2,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "73%",
                "02/14/2019",
                R.drawable.poster_alita
        ))
        movies.add(MovieEntity(
            3,
            "Aquaman",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
            "69%",
            "12/21/2018",
            R.drawable.poster_aquaman
        ))
        return movies
    }
}