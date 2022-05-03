package com.ruthwikkk.fibonaccigenerator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ruthwikkk.fibonaccigenerator.database.FibNumber

class MainAdapter: ListAdapter<FibNumber, MainAdapter.SongsViewHolder>(NumberComparator()) {

    inner class SongsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        private val tvDesc: TextView = itemView.findViewById(R.id.tv_desc)

        fun bind(number: FibNumber) {
            tvTitle.text = number.number.toString()
            tvDesc.text = Utils.toPrettyTime(number.timeStamp)
        }
    }

    class NumberComparator : DiffUtil.ItemCallback<FibNumber>() {
        override fun areItemsTheSame(oldItem: FibNumber, newItem: FibNumber): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: FibNumber, newItem: FibNumber): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongsViewHolder {
        val view :View = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_cell_number, parent, false)
        return SongsViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongsViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }
}