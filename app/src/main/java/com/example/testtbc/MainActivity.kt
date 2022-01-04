package com.example.testtbc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.testtbc.databinding.ActivityMainBinding
import com.example.testtbc.network.NetworkClient
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


binding.btnStart.setOnClickListener {
    lifecycleScope.launchWhenStarted {
        withContext(IO){
            val response = NetworkClient.api.getCurrency()
            val body = response.body()
            if (response.isSuccessful && body !=null){
                Log.d("---", "$body")

            }else{
                Log.d("---", "${response.code()}")
            }
        }

    }
}








    }
}