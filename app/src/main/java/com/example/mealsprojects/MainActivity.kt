package com.example.mealsprojects

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealsprojects.databinding.ActivityMainBinding
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG = this::class.java.simpleName
    private var viewModel: MealsViewModel? = null
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        viewModel = ViewModelProvider(this)[MealsViewModel::class.java]

        lifecycleScope.launchWhenCreated {
            viewModel?.getMeals()
            viewModel?.categories?.collect {
                val adapter = MealsAdapter()
                adapter.submitList(it?.categories)
                binding?.rv?.adapter = adapter
                binding?.rv?.layoutManager = LinearLayoutManager(this@MainActivity)
                Log.d(TAG, "$it")

            }
        }

    }
}