package com.better.reads.data.repository

import com.better.reads.data.api.ApiHelper
import com.better.reads.data.model.User
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper) {

    fun getUsers(): Single<List<User>> {
        return apiHelper.getUsers()
    }
}