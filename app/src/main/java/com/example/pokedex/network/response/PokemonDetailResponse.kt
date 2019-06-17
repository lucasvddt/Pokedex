package com.example.pokedex.network.response

import com.google.gson.annotations.SerializedName
import com.example.pokedex.model.Ability
import com.example.pokedex.model.Move
import com.example.pokedex.model.Sprite

class PokemonDetailResponse : BaseResponse() {

    @SerializedName("id")
    var id: Int? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("sprites")
    var sprites: Sprite? = null

    @SerializedName("moves")
    var moves: ArrayList<Move>? = null

    @SerializedName("weight")
    var weight: Int? = null

    @SerializedName("height")
    var height: Int? = null

    @SerializedName("abilities")
    var abilities: ArrayList<Ability>? = null
}