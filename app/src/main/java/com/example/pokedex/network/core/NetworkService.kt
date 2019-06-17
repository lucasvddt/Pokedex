package com.example.pokedex.network.core

import com.example.pokedex.util.ConfigurationUtils

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkService {
    private var service: PokemonApi? = null

    fun service(): PokemonApi? {

        if (service == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(ConfigurationUtils.baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            service = retrofit.create(PokemonApi::class.java)
        }

        return service
    }
}