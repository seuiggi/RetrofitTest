package com.seuiggi.retrofittest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.seuiggi.retrofittest.BR
import com.seuiggi.retrofittest.R
import com.seuiggi.retrofittest.databinding.LayoutWeakdemonBinding
import com.seuiggi.retrofittest.pojo.demon.ListedDemonData

class DataListAdapter(private val list: List<ListedDemonData>) : RecyclerView.Adapter<DataListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<LayoutWeakdemonBinding>(
            LayoutInflater.from(parent.context),
            R.layout.layout_weakdemon,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(private val binding: LayoutWeakdemonBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: ListedDemonData) {
            binding.setVariable(BR.data, data)
        }
    }
}