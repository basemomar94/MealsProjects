package com.example.domain.repo

import com.example.domain.models.CategoryResponse

interface MealsRepo {

   suspend fun getMealsFromRemote(): CategoryResponse
}