package com.example.listadapters_and_diffutils_components.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.listadapters_and_diffutils_components.R
import com.example.listadapters_and_diffutils_components.databinding.ItemViewBinding
import com.example.listadapters_and_diffutils_components.model.ProgramItem
import androidx.recyclerview.widget.DiffUtil as DiffUtil1

class ProgramAdapter : ListAdapter<ProgramItem, ProgramAdapter.ViewHolder>(DiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = getItem(position)
        holder.bind(item)

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: ItemViewBinding = ItemViewBinding.bind(view)

        fun bind(item: ProgramItem){
            binding.tvName.text = item.name
            binding.tvInitial.text = item.initial
        }

    }

    class DiffUtil : DiffUtil1.ItemCallback<ProgramItem>(){
        override fun areItemsTheSame(oldItem: ProgramItem, newItem: ProgramItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProgramItem, newItem: ProgramItem): Boolean {
            return oldItem == newItem }

    }

}