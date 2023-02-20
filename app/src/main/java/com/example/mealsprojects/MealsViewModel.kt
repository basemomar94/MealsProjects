package com.example.mealsprojects

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.CategoryResponse
import com.example.domain.usecases.GetMeals
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(private val getMealsUseCase: GetMeals) : ViewModel() {
    private val TAG = this::class.java.simpleName
    private val _categories: MutableStateFlow<CategoryResponse?> = MutableStateFlow(null)
    val categories = _categories
    fun getMeals() {
        viewModelScope.launch {
            try {
                categories.value = getMealsUseCase()

            } catch (e: java.lang.Exception) {
                Log.d(TAG, "${e.message}")
            }
        }
    }

}