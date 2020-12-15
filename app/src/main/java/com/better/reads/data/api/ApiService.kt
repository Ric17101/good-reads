package com.better.reads.data.api

import com.better.reads.data.model.User
import io.reactivex.Single

interface ApiService {
    fun getUsers(): Single<List<User>>
}