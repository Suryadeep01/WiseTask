package com.example.wisetask.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wisetask.model.response.Cocktail
import com.example.wisetask.model.response.CocktailResponse
import com.example.wisetask.network.RetrofitInstance
import com.example.wisetask.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class mojitoViewModel : ViewModel() {
    var mojitoDataList = MutableLiveData<List<Cocktail>>()

    fun getApiData(query: String?) {
        val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)
        if (query != null) {
            retrofitInstance.getDataFromApi(query,).enqueue(object : Callback<CocktailResponse> {
                override fun onResponse(call: Call<CocktailResponse>, response: Response<CocktailResponse>) {
                    val cocktailResponse = response.body()
                    cocktailResponse?.let {
                        mojitoDataList.value = it.drinks
                    }
                }

                override fun onFailure(call: Call<CocktailResponse>, t: Throwable) {
                }
            })
        }
    }
}
