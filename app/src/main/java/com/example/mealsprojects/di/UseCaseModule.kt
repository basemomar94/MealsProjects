package com.example.mealsprojects.di

import com.example.domain.repo.MealsRepo
import com.example.domain.usecases.GetMeals
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideUseCases(mealsRepo: MealsRepo) = GetMeals(mealsRepo)
}