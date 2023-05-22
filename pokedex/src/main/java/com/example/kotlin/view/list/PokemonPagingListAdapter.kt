package com.example.kotlin.view.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.R
import com.example.kotlin.data.model.PokemonListEntryResult

class PokemonPagingListAdapter :
    PagingDataAdapter<PokemonListEntryResult, PokemonPagingListAdapter.PokemonListEntryViewHolder>(
        PokemonDiffer
    ) {

    override fun onBindViewHolder(holder: PokemonListEntryViewHolder, position: Int) {
        getItem(position)?.let { holder.bindView(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListEntryViewHolder {
        return PokemonListEntryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_pokemon_list_entry, parent, false)
        )
    }

    class PokemonListEntryViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bindView(item: PokemonListEntryResult) {
            view.findViewById<TextView>(R.id.pokemon_name).text = item.name
        }
    }

    object PokemonDiffer : DiffUtil.ItemCallback<PokemonListEntryResult>() {
        override fun areItemsTheSame(
            oldItem: PokemonListEntryResult,
            newItem: PokemonListEntryResult
        ): Boolean {
            return oldItem.name == newItem.name && oldItem.url == newItem.url
        }

        override fun areContentsTheSame(
            oldItem: PokemonListEntryResult,
            newItem: PokemonListEntryResult
        ): Boolean {
            return oldItem.name == newItem.name && oldItem.url == newItem.url
        }
    }
}