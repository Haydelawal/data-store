package com.infinity.preferencesdatastoreexample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.infinity.preferencesdatastoreexample.databinding.ActivitySecondBinding
import com.infinity.preferencesdatastoreexample.viewmodel.ActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.infinity.preferencesdatastoreexample.databinding.ActivityMainBinding
import com.infinity.preferencesdatastoreexample.repository.ImplRepository
import com.infinity.preferencesdatastoreexample.repository.datastore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first

@AndroidEntryPoint
class SecondActivity : AppCompatActivity() {

//    private var mainViewModel: ActivityViewModel ?= null
//
//    private var context: Context ?= null

    private lateinit var binding: ActivitySecondBinding

//    private  var repository: ImplRepository ?= null


    private val activityViewModel: ActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)



//        binding.textView.text = activityViewModel.phone.toString()
//        binding.textView2.text = activityViewModel.name.observe(this, {
//
//
//                NAME -> activityViewModel.address.value = NAME
//        }).toString()
//        binding.textView3.text = activityViewModel.name.toString()

        val viewModel = ViewModelProvider(this).get(ActivityViewModel::class.java)
        viewModel.retrieveDate()

        viewModel.showTheData().observe(this, Observer {
            binding.textView.text = it.phone
            binding.textView2.text = it.address
            binding.textView3.text = it.name
        })

    }

}