package com.better.reads.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.better.reads.R
import com.better.reads.data.model.User
import com.better.reads.databinding.GridItemLayoutBinding
import com.bumptech.glide.Glide

class GridAdapter(
    private val users: ArrayList<User>
) : RecyclerView.Adapter<GridAdapter.DataViewHolder>() {

    class DataViewHolder(binding: GridItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        private var binding: GridItemLayoutBinding? = null

        init {
            this.binding = binding
        }

        fun bind(user: User) {
            binding?.apply {
                Glide.with(imageViewAvatar.context)
                    .load(user.avatar)
                    .into(imageViewAvatar)
                binding?.executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: GridItemLayoutBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.grid_item_layout, parent, false)
        return DataViewHolder(binding)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(users[position])

    fun addData(list: List<User>) {
        users.addAll(list)
    }
}