package com.example.capsuleapp.Fragment

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import com.example.capsuleapp.R
import com.example.capsuleapp.databinding.FragmentVideo2Binding

class VideoFragment : Fragment() {
    lateinit var binding: FragmentVideo2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentVideo2Binding.inflate(layoutInflater)
        val videoUrl = "http://techslides.com/demos/sample-videos/small.mp4"
         binding.apply {
        // Create a MediaController for playback controls
        val mediaController = MediaController(requireContext())
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        try {
            videoView.setVideoURI(Uri.parse(videoUrl))
            videoView.start()
        } catch (e: Exception) {
            //Log.d("nnn", "onCreateView: ${error("errror")}")
            e.printStackTrace()

        }
         }
        return binding.root
    }



}