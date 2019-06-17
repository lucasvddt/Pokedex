package com.example.pokedex.ui.pokemonlist

import com.example.pokedex.network.response.PokemonListResponse
import com.example.pokedex.ui.base.IView

interface PokemonListView : IView {
    fun setPokemonList(response: PokemonListResponse)
}