package com.josephgwara.retrofitexample.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object ApiClient {
    /**
     *Creating a base URL for the Retrofit builder
     * */
private  val baseURL:String = "https://rickandmortyapi.com/api/"

    /**
     * Creating a variable for the Moshi builder and adding a converter to it*/

    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    /**
     * Creating an instance of retrofit by lazy so it can be initialized only when it is needed
     * pass the base url and the moshi variable created above*/

    private val retroFit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }
    val apiService:ApiService by lazy {
        retroFit.create(ApiService::class.java)
    }
}
/**
 * Create an interface to define how Retrofit talks to the service using GET method*/

//An interface called Api service
interface ApiService{
    /**
     * Creating a fetch characters method annotated with @GET passing the character
     * path just like in the api link to tell the server to send the characters*/
@GET("character")
    fun fetchCharacters(@Query("page")page:String): Call<CharacterResponse>

}