package com.example.pokedex.model

import com.google.gson.annotations.SerializedName

class Move {
    @SerializedName("move")
    var move: MoveDetail? = null
}