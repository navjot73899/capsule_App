package com.example.capsuleapp.Activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.capsuleapp.R
import com.example.capsuleapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = getIntent()
        val value = intent.getStringExtra("score")
        binding.score.text ="You Score "+value+" out 5 "
    }
}