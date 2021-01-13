package com.better.reads.ui.main.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.better.reads.R
import com.better.reads.data.api.ApiHelper
import com.better.reads.data.api.ApiServiceImpl
import com.better.reads.data.model.User
import com.better.reads.databinding.ActivityGridBinding
import com.better.reads.ui.base.ViewModelFactory
import com.better.reads.ui.main.adapter.GridAdapter
import com.better.reads.ui.main.viewmodel.GridViewModel
import com.better.reads.utils.SpannedGridLayoutManager
import com.better.reads.utils.SpannedGridLayoutManager.GridSpanLookup
import com.better.reads.utils.SpannedGridLayoutManager.SpanInfo
import com.better.reads.utils.Status

class GridListMVVMActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGridBinding
    private lateinit var mainViewModel: GridViewModel
    private lateinit var adapter: GridAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_grid)

        //setupUI()
        setupSpannedGridLayout()
        setupViewModel()
        setupObserver()
    }

    private fun setupSpannedGridLayout() {
        val manager = SpannedGridLayoutManager(
            object : GridSpanLookup {
                override fun getSpanInfo(position: Int): SpanInfo {
                    // Conditions for 2x2 items
                    return if (position % 6 == 0 || position % 6 == 4) {
                        SpanInfo(2, 2)
                    } else {
                        SpanInfo(1, 1)
                    }
                }
            },
            3,  // number of columns
            1f // how big is default item
        )
        binding.recyclerView.layoutManager = manager
        adapter = GridAdapter(arrayListOf())
        binding.recyclerView.adapter = adapter
    }

    // private fun setupUI() {
    //     binding.recyclerView.layoutManager = LinearLayoutManager(this)
    //     adapter = MainAdapter(arrayListOf())
    //     binding.recyclerView.addItemDecoration(
    //         DividerItemDecoration(
    //             binding.recyclerView.context,
    //             (binding.recyclerView.layoutManager as LinearLayoutManager).orientation
    //         )
    //     )
    //     binding.recyclerView.adapter = adapter
    // }

    private fun setupObserver() {
        mainViewModel.getUsers().observe(this, {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    it.data?.let { users -> renderList(users) }
                    binding.recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(users: List<User>) {
        adapter.addData(users)
        adapter.notifyDataSetChanged()
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(ApiServiceImpl()))
        ).get(GridViewModel::class.java)
    }
}