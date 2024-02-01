package com.example.wisetask.network


import com.example.wisetask.model.response.CocktailResponse
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("search.php?s=mojito")
//    fun getDataFromApi(): Call<List<Cocktail>>
    fun getDataFromApi(): Call<CocktailResponse>


}

