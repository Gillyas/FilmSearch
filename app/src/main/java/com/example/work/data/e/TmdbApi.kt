package com.example.work.data.e


import com.example.work.data.e.Enity.TmdbResultsDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query




interface TmdbApi {
    @GET("3/movie/popular")
    fun getFilms(
        //наш ключ API, который мы получили.
        @Query("api_key") apiKey: String,
        // язык, на котором будет сформирован список
        @Query("language") language: String,
        //страница списка, это задел для пагинации.
        @Query("page") page: Int
    ): Call<TmdbResultsDto>
}

