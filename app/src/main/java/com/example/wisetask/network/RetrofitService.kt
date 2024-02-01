package com.example.wisetask.network


import com.example.wisetask.model.response.CocktailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("json/v1/1/search.php")
//    fun getDataFromApi(): Call<List<Cocktail>>
    fun getDataFromApi(@Query("s") drink: String): Call<CocktailResponse>


}

