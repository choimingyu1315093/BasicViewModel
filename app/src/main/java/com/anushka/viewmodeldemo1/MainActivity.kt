package com.anushka.viewmodeldemo1

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.anushka.viewmodeldemo1.databinding.ActivityMainBinding

const val TAG = "MainActivity"
//LiveData 사용하고 안하고 코드 차이 보여준다.
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModelFactory: MainViewModelFactory
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModelFactory = MainViewModelFactory(125)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        //LiveData 안 쓸 때
//        binding.tvNumber.text = viewModel.getTotal().toString()
//        binding.btnAdd.setOnClickListener {
//            viewModel.setTotal(binding.etNumber.text.toString().toInt())
//            binding.tvNumber.text = viewModel.getTotal().toString()
//        }


        //LiveData 쓸 때
        viewModel.total.observe(this) {
            binding.tvNumber.text = it.toString()
        }
        binding.btnAdd.setOnClickListener {
            viewModel.setTotal(binding.etNumber.text.toString().toInt())
        }
    }
}