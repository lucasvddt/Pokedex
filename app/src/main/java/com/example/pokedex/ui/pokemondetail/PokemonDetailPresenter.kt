package com.example.pokedex.ui.pokemondetail

import com.example.pokedex.ui.base.IPresenter

interface PokemonDetailPresenter : IPresenter {
    fun getPokemonDetail(name: String?)
}