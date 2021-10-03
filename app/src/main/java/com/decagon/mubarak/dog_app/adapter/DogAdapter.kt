package com.decagon.mubarak.dog_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decagon.mubarak.dog_app.data.repository.model.Breeds
import com.decagon.mubarak.dog_app.databinding.DogListLayoutBinding

class DogAdapter(private val dogList: ArrayList<Breeds>) :
    RecyclerView.Adapter<DogAdapter.DogViewHolder>() {

    class DogViewHolder(private val binding: DogListLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(breeds: Breeds) {
            binding.dogNameTextView.text = breeds.name
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        return DogViewHolder(
            DogListLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.bind(dogList[position])
    }

    override fun getItemCount(): Int = dogList.size

    fun addBreeds(breeds: List<Breeds>) {
        dogList.addAll(breeds)
    }
}
