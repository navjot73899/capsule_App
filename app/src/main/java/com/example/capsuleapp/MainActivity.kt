package com.example.capsuleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.capsuleapp.Adapter.ViewPageAdapter
import com.example.capsuleapp.Fragment.NotesFragment
import com.example.capsuleapp.Fragment.QuizFragment
import com.example.capsuleapp.Fragment.VideoFragment
import com.example.capsuleapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragmentArrayList = ArrayList<Fragment>()

        fragmentArrayList.add(VideoFragment())
        fragmentArrayList.add(NotesFragment())
        fragmentArrayList.add(QuizFragment())

        val adapter=
           ViewPageAdapter(this, supportFragmentManager, fragmentArrayList)
        binding!!.viewPager.adapter= adapter
        binding!!.tabs.setupWithViewPager(binding!!.viewPager)
    }
}