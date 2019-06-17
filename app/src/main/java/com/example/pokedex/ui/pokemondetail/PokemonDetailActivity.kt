package com.example.pokedex.ui.pokemondetail

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.pokedex.R
import com.example.pokedex.adapter.PokemonAbilityListAdapter
import com.example.pokedex.adapter.PokemonMoveListAdapter
import com.example.pokedex.model.Ability
import com.example.pokedex.model.Move
import com.example.pokedex.network.response.PokemonDetailResponse
import com.example.pokedex.ui.base.BaseActivity
import com.example.pokedex.ui.pokemonlist.KEY_NAME
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pokemon_detail.*


class PokemonDetailActivity : BaseActivity(), PokemonDetailView {
    private var presenter: PokemonDetailPresenter? = null
    private var pokemonName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)
        pokemonName = intent.getStringExtra(KEY_NAME)

        presenter = PokemonDetailPresenterImpl(this, PokemonDetailInteractorImpl())

        init()
    }

    private fun init() {
        presenter?.getPokemonDetail(pokemonName)
    }

    override fun setPokemonDetail(response: PokemonDetailResponse) {
        Picasso.with(this).load(response.sprites?.frontImage).into(ivImage)

        YoYo.with(Techniques.Tada)
            .duration(700)
            .repeat(5)
            .playOn(findViewById(R.id.ivImage))

        tvName.text = response.name
        tvWeight.text = "weight: ${response.weight.toString()}"
        tvHeight.text = "height: ${response.height.toString()}"
        setPokemonMoveListAdapter(rvMoves, response.moves)
        setPokemonAbilityListAdapter(rvAbilities, response.abilities)
    }

    private fun setPokemonAbilityListAdapter(recyclerView: RecyclerView?, abilities: ArrayList<Ability>?) {
        recyclerView?.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        recyclerView?.adapter = abilities?.let { PokemonAbilityListAdapter(it, this) }
    }

    private fun setPokemonMoveListAdapter(recyclerView: RecyclerView?, moves: ArrayList<Move>?) {

        recyclerView?.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        recyclerView?.adapter = moves?.let { PokemonMoveListAdapter(it, this) }

    }

    override fun showErrorMessage(errorMessage: String) {
        Log.e("error", "errorMessage: $errorMessage")
    }
}

