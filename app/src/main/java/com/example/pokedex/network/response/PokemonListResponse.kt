package com.example.pokedex.network.response

import com.google.gson.annotations.SerializedName
import com.example.pokedex.model.Pokemon

class PokemonListResponse : BaseResponse() {

    @SerializedName("count")
    var count: Int? = null

    @SerializedName("results")
    var results: ArrayList<Pokemon>? = null

}