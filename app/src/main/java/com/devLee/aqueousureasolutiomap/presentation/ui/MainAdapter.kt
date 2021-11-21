package com.devLee.aqueousureasolutiomap.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.devLee.aqueousureasolutiomap.common.AdapterDiffUtil
import com.devLee.aqueousureasolutiomap.data.remote.Data
import com.devLee.aqueousureasolutiomap.databinding.ItemMainBinding

class MainAdapter: RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var aus32DataList = emptyList<Data>()

    inner class ViewHolder(private val binding: ItemMainBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Data) {
            binding.apply {
                this.aus32Data = data
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMainBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(aus32DataList[position])
    }

    override fun getItemCount(): Int = aus32DataList.size

    fun setData(newData: List<Data>) {
        val aus32DataDiffUtil = AdapterDiffUtil(aus32DataList, newData)
        val diffResult = DiffUtil.calculateDiff(aus32DataDiffUtil)
        aus32DataList = newData
        diffResult.dispatchUpdatesTo(this)
    }
}