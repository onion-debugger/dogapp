package com.decagon.mubarak.dog_app

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.decagon.mubarak.dog_app.adapter.DogAdapter
import com.decagon.mubarak.dog_app.data.repository.api.DogApiHelper
import com.decagon.mubarak.dog_app.data.repository.api.RetrofitBuilder
import com.decagon.mubarak.dog_app.data.repository.model.Breeds
import com.decagon.mubarak.dog_app.databinding.ActivityMainBinding
import com.decagon.mubarak.dog_app.util.Status
import com.decagon.mubarak.dog_app.viewmodel.DogViewModel
import com.decagon.mubarak.dog_app.viewmodel.DogViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: DogViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DogAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpViewModel()
        setUpUI()
        setUpObservers()
    }

    private fun setUpViewModel() {
        viewModel = ViewModelProvider(
            this,
            DogViewModelFactory(DogApiHelper(RetrofitBuilder.apiService))
        )[DogViewModel::class.java]
    }

    private fun setUpUI() {
        binding.dogListRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = DogAdapter(arrayListOf())
        binding.dogListRecyclerView.adapter = adapter
    }

    private fun setUpObservers() {
        viewModel.getBreeds().observe(
            this,
            Observer {
                it?.let { resource ->
                    when (resource.status) {
                        Status.SUCCESS -> {
                            binding.dogListRecyclerView.visibility = View.VISIBLE
                            Log.d("MainActivity", "setUpObservers: ${resource.data}")
                            resource.data?.let { breeds -> retrieveList(breeds) }
                        }

                        Status.ERROR -> {
                            binding.dogListRecyclerView.visibility = View.VISIBLE
                            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                        }

                        Status.LOADING -> {
                            binding.dogListRecyclerView.visibility = View.GONE
                            Toast.makeText(this, "Still Loading", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        )
    }

    private fun retrieveList(breeds: List<Breeds>) {
        adapter.addBreeds(breeds)
    }
}
