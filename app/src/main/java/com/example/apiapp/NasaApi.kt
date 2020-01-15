package com.example.apiapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaApi {


    @GET("apod?api_key=$API_KEY")
    fun getApods(@Query("start_date") StartDate: String, @Query("end_date") EndDate: String): Call<List<POJO>>

    companion object {

        const val BASE_URL = "https://api.nasa.gov/planetary/"
        const val API_KEY = "LdXwPsRpQRgrkpAIX8DuFn64n5tiaWqk20mC5qTs"

    }


}
