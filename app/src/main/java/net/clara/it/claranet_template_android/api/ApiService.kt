package net.clara.it.claranet_template_android.api

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ApiService {
    @GET("getItems")
    @Headers("Content-Type: application/json")
    fun getItems(): Any
}