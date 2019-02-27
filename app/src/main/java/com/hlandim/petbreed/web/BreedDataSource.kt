package com.hlandim.petbreed.web

import com.hlandim.petbreed.bread.model.Breed

interface BreedDataSource {
    fun listAll(success: (List<Breed>) -> Unit, failure: () -> Unit)
}