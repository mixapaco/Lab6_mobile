package com.example.lab6.data.api

import com.example.lab6.data.model.JsonData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface GeterApi {
    @GET("{link}")
    fun getData(@Header("secret-key") secretKey: String, @Path("link") link: String?): Call<JsonData>

}