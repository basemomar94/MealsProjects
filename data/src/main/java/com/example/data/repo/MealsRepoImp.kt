package com.example.data.repo

import com.example.data.remote.ApiService
import com.example.domain.models.CategoryResponse
import com.example.domain.repo.MealsRepo
import com.example.domain.usecases.GetMeals

class MealsRepoImp(private val apiService: ApiService) : MealsRepo {
    override suspend fun getMealsFromRemote() = apiService.getMeals()

}