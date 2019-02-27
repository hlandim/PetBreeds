package com.hlandim.petbreed.bread.fragment

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.hlandim.petbreed.bread.AdapterItemsContract
import com.hlandim.petbreed.databinding.BreedItemBinding
import com.hlandim.petbreed.bread.model.Breed

class BreedsAdapter(var items: List<Breed>) : RecyclerView.Adapter<BreedsAdapter.ViewHolder>(), AdapterItemsContract {

    override fun replaceItems(list: List<Breed>) {
        this.items = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: BreedItemBinding = BreedItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }


    class ViewHolder(val binding: BreedItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(breed: Breed) {
            binding.breed = breed
            binding.executePendingBindings()
        }
    }
}