package com.example.pokedex.ui.pokemondetail

import com.example.pokedex.network.response.PokemonDetailResponse
import com.example.pokedex.ui.base.IView

interface PokemonDetailView : IView {
    fun setPokemonDetail(response: PokemonDetailResponse)
}