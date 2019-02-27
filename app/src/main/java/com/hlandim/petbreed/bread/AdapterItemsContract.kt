package com.hlandim.petbreed.bread

import com.hlandim.petbreed.bread.model.Breed

interface AdapterItemsContract {
    fun replaceItems(list: List<Breed>)
}