package com.example.pokedex.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pokedex.R
import com.example.pokedex.model.Ability
import kotlinx.android.synthetic.main.item_ability.view.*

class  PokemonAbilityListAdapter(
    private val dataList: ArrayList<Ability>,
    private val context: Context
) :
    RecyclerView.Adapter<PokemonAbilityListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_ability, parent, false))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = dataList[position].ability?.name
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.tvAbilityName!!
    }
}