package com.hlandim.petbreed.bread

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.hlandim.petbreed.R
import com.hlandim.petbreed.bread.fragment.BreedsFragment
import com.hlandim.petbreed.bread.viewmodel.BreedsViewModel
import com.hlandim.petbreed.web.ApiService
import com.hlandim.petbreed.web.BreedRepository
import com.hlandim.petbreed.web.dogceo.DogBreedDataSource
import com.hlandim.petbreed.web.dogceo.DogCeoApi
import kotlinx.android.synthetic.main.activity_breeds.*

class BreedsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breeds)

        addFragmentTo(R.id.content_frame, createFragment())
        setSupportActionBar(toolbar)

    }

    private fun createViewModel(): BreedsViewModel {

        val api = ApiService("http://dog.ceo/api/").retrofit.create(DogCeoApi::class.java)

        val dogDataSource = DogBreedDataSource(api)

        val repository = BreedRepository(dogDataSource)

        return BreedsViewModel(repository, this)
    }

    private fun createFragment(): BreedsFragment {
        return BreedsFragment.newInstance(createViewModel())
    }

    private fun AppCompatActivity.addFragmentTo(containerId: Int, fragment: Fragment, tag: String = "") {
        supportFragmentManager.beginTransaction().add(containerId, fragment, tag).commit()

    }
}
