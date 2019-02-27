package com.hlandim.petbreed.bread

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.hlandim.petbreed.bread.model.Breed

@BindingAdapter("items")
fun setItems(recyclerView: RecyclerView, list: List<Breed>) {
    recyclerView.adapter.let {
        if (it is AdapterItemsContract) {
            it.replaceItems(list)
        }
    }
}
