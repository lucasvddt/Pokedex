package com.example.pokedex.network.observer

import android.text.TextUtils
import com.example.pokedex.network.response.PokemonDetailResponse
import com.example.pokedex.ui.pokemondetail.PokemonDetailInteractor

class PokemonDetailObserver(private var listener: PokemonDetailInteractor.PokemonDetailListener) :
    BaseObserver<PokemonDetailResponse>() {

    override fun onNext(response: PokemonDetailResponse) {
        listener.onPokemonDetailSuccess(response)
    }

    override fun onError(e: Throwable) {
        super.onError(e)
        if (!TextUtils.isEmpty(errorMessage)) {
            listener.onPokemonDetailFailed(e, errorMessage)
        }
    }

}