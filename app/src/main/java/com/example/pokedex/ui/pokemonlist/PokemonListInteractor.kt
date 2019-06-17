package com.example.pokedex.ui.pokemonlist

import com.example.pokedex.network.response.PokemonListResponse

interface PokemonListInteractor {
    interface PokemonListListener {

        fun onPokemonListFailed(e: Throwable, errorMessage: String)

        fun onPokemonListSuccess(response: PokemonListResponse)
    }

    fun getPokemonList(listener: PokemonListListener)
}
