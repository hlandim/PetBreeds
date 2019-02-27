package com.hlandim.petbreed.bread.viewmodel

import android.content.Context
import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import com.hlandim.petbreed.R
import com.hlandim.petbreed.bread.model.Breed
import com.hlandim.petbreed.web.BreedRepository
import java.io.Serializable

class BreedsViewModel(private val repository: BreedRepository, private val context: Context) : Serializable {

    val breeds = ObservableArrayList<Breed>()
    val loadingVisibility = ObservableBoolean(false)
    val message = ObservableField<String>()

    fun load() {
        loadingVisibility.set(true)
        message.set("")
        repository.listAll({ items ->
            breeds.clear()
            breeds.addAll(items)
            if (items.isEmpty()) {
                message.set(context.getString(R.string.breed_request_empty))
            }
        }, {
            message.set(context.getString(R.string.breed_request_error));
        })
    }
}