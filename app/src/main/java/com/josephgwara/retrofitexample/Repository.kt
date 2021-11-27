package com.josephgwara.retrofitexample

import com.josephgwara.retrofitexample.network.ApiService

/**
 * In MVVM THE REPOSITORY CLASS IS USUALLY THE SINGLE SOURCE OF TRUTH (SSOT) MEANING THAT ALL DATA
 * SOURCES INTERACT WITH IT*/

class Repository(private  val apiService: ApiService) {
    fun getCharacter(page:String) = apiService.fetchCharacters(page)


}