package com.devLee.aqueousureasolutiomap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.devLee.aqueousureasolutiomap.databinding.ActivityMainBinding
import com.devLee.aqueousureasolutiomap.presentation.ui.MainAdapter
import com.devLee.aqueousureasolutiomap.presentation.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private val mainAdapter: MainAdapter by lazy { MainAdapter() }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRecyclerView()

        lifecycleScope.launchWhenStarted {
            viewModel.aus32Response.collect {
                if (!it.aus32.isNullOrEmpty()) {
                    mainAdapter.setData(it.aus32)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAUS32SafeCall(1)
    }

    private fun setRecyclerView() {
        binding.mainRecyclerView.adapter = mainAdapter
    }
}