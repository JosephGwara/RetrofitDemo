package com.josephgwara.retrofitexample.network
import com.squareup.moshi.Json

//Model Class
//good practice to name the properties as the Json objects
data class Character (
    @Json(name ="name")
    val name:String,
    @Json(name = "image")
    val image:String
        )

data class CharacterResponse(@Json(name = "results")
val result:List<Character>
)