package com.example.fcm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fcm.databinding.ActivityMainBinding

class notification : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}

