package com.hlandim.petbreed.web

import com.hlandim.petbreed.bread.model.Breed

class BreedRepository(private val dataSource: BreedDataSource) : BreedDataSource {

    override fun listAll(success: (List<Breed>) -> Unit, failure: () -> Unit) {
        dataSource.listAll(success, failure)
    }

}