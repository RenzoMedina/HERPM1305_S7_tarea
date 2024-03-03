package com.example.renzo_steve_medina_seccioncurso.data

import com.example.renzo_steve_medina_seccioncurso.data.model.FeriadosResult
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface RetroServices {
    @GET("2024")
    suspend fun listDays ():FeriadosResult

}
object RetrofitServicesFactory{
    fun makeRetrofitServices():RetroServices{
        return Retrofit.Builder()
            .baseUrl("https://apis.digital.gob.cl/fl/feriados")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetroServices::class.java)
    }
}