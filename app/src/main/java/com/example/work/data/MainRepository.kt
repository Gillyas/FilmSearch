package com.example.work.data

import com.example.work.R
import com.example.work.domain.Film

class MainRepository {
    val filmsDataBase = listOf(
        Film(
            "The Shawshank Redemption",
            R.drawable.pic,
            "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
            7.4f
        ),
        Film(
            "The Godfather",
            R.drawable.pic2,
            "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
            8.9f
        ),
        Film(
            "The Dark Knight",
            R.drawable.pic3,
            "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
            9.3f
        ),
        Film(
            "Pulp Fiction",
            R.drawable.pic4,
            "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
            9.9f
        ),
        Film(
            "Inception",
            R.drawable.pic5,
            "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.",
            5.9f
        ),
        Film(
            "Hamilton",
            R.drawable.pic6,
            "The real life of one of America's foremost founding fathers and first Secretary of the Treasury, Alexander Hamilton. Captured live on Broadway from the Richard Rodgers Theater with the original Broadway cast.",
            8.0f
        ),
        Film(
            "Gisaengchung",
            R.drawable.pic7,
            "Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan.",
            9.9f
        ),
    )

}