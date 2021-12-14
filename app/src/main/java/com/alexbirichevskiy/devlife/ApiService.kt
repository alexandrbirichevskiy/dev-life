package com.alexbirichevskiy.devlife

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("{category}/0?json=true")
    fun getDataModel(@Path("category") category:String): Single<DataModel>
}