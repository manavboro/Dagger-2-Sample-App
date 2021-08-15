package manabboro.roomdatabase.daggertest.di

import manabboro.roomdatabase.daggertest.model.DataOutput
import retrofit2.Call
import retrofit2.http.GET

interface RetroServiceInterface {

    @GET("random")
    fun getDogImage(): Call<DataOutput>
}