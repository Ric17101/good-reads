package com.better.reads.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.better.reads.data.api.ApiHelper
import com.better.reads.data.repository.GridRepository
import com.better.reads.ui.main.viewmodel.GridViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GridViewModel::class.java)) {
            return GridViewModel(GridRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}