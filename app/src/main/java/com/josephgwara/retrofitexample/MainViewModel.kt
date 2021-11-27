package com.josephgwara.retrofitexample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.josephgwara.retrofitexample.network.ApiClient
import com.josephgwara.retrofitexample.network.Character
import com.josephgwara.retrofitexample.network.CharacterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel(private  val repository:Repository = Repository(ApiClient.apiService)):ViewModel() {

    private var charactersLiveData = MutableLiveData<List<Character>>()
    val characterLiveData:LiveData<List<Character>>
    get() = charactersLiveData


    init {
        fetchCharater()
    }

    private fun fetchCharater(){

        val client = repository.getCharacter("1")
        client.enqueue(object:Callback<CharacterResponse>{
            override fun onResponse(
                call: Call<CharacterResponse>,
                response: Response<CharacterResponse>
            ) {
                if (response.isSuccessful){
                    charactersLiveData.postValue(response.body()?.result)


                }
            }

            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                Log.d("Failure",""+t.message.toString())
            }
        })
    }



}