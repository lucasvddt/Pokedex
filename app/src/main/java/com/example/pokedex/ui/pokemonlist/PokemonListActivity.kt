package com.example.pokedex.ui.pokemonlist

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.adapter.PokemonListAdapter
import com.example.pokedex.model.Pokemon
import com.example.pokedex.network.response.PokemonListResponse
import com.example.pokedex.ui.base.BaseActivity
import com.example.pokedex.ui.pokemondetail.PokemonDetailActivity
import kotlinx.android.synthetic.main.activity_pokemon_list.*

const val KEY_NAME = "name"

class PokemonListActivity : BaseActivity(), PokemonListView, PokemonListAdapter.PokemonListener {
    private var presenter: PokemonListPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)

        presenter = PokemonListPresenterImpl(this, PokemonListInteractorImpl())

        init()
    }

    private fun init() {
        presenter?.getPokemonList()
    }

    override fun setPokemonList(response: PokemonListResponse) {
        setPokemonListAdapter(rvPokemon, response)
    }

    private fun setPokemonListAdapter(recyclerView: RecyclerView?, response: PokemonListResponse) {
        recyclerView?.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        recyclerView?.adapter = PokemonListAdapter(response.results!!, this, this)
    }

    override fun showErrorMessage(errorMessage: String) {

    }

    override fun onPokemonClickedListener(pokemon: Pokemon) {
        val intent = Intent(this, PokemonDetailActivity::class.java)
        intent.putExtra(KEY_NAME, pokemon.name)
        startActivity(intent)
    }
}

