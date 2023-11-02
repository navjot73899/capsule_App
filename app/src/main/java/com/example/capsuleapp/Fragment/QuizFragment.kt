package com.example.capsuleapp.Fragment

import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.capsuleapp.Activites.ResultActivity
import com.example.capsuleapp.R
import com.example.capsuleapp.correctOption
import com.example.capsuleapp.databinding.FragmentQuizBinding
import com.example.capsuleapp.option
import com.example.capsuleapp.question


class QuizFragment : Fragment() {
    lateinit var binding: FragmentQuizBinding
    private var currentQueIndex=0
    var score=0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentQuizBinding.inflate(layoutInflater)

        displayQue()
        binding.apply {
            option1.setOnClickListener {
                checkAnswer(0)
            }
            option2.setOnClickListener {
                checkAnswer(1)
            }
            option3.setOnClickListener {
                checkAnswer(2)
            }
            option4.setOnClickListener {
                checkAnswer(3)
            }
        }
     return binding.root
    }


    fun correctButtonColor(buttonIndex:Int){
        when(buttonIndex){
            0-> binding.option1.setBackgroundColor(Color.GREEN)
            1-> binding.option2.setBackgroundColor(Color.GREEN)
            2-> binding.option3.setBackgroundColor(Color.GREEN)
            3-> binding.option4.setBackgroundColor(Color.GREEN)
        }}
        fun wrongButtonColor(buttonIndex:Int){
            when(buttonIndex){
                0-> binding.option1.setBackgroundColor(Color.RED)
                1-> binding.option2.setBackgroundColor(Color.RED)
                2-> binding.option3.setBackgroundColor(Color.RED)
                3-> binding.option4.setBackgroundColor(Color.RED)
            }
    }

    fun resetbuttonClr(){
        binding.option1.setBackgroundColor(Color.WHITE)
        binding.option2.setBackgroundColor(Color.WHITE)
        binding.option3.setBackgroundColor(Color.WHITE)
        binding.option4.setBackgroundColor(Color.WHITE)
    }

    fun showResult(){
        binding.result.isEnabled
        val intent=Intent(context,ResultActivity::class.java)
        intent.putExtra("score", score.toString())
        activity?.startActivity(intent)
    }

    fun displayQue(){
        binding.que.text= question[currentQueIndex]
        binding.option1.text= option[currentQueIndex][0]
        binding.option2.text= option[currentQueIndex][1]
        binding.option3.text= option[currentQueIndex][2]
        binding.option4.text= option[currentQueIndex][3]
        resetbuttonClr()
    }

    private fun checkAnswer(selectedAnswer:Int){
        val crtAnswerindex= correctOption[currentQueIndex]

        if(selectedAnswer == crtAnswerindex){
            score++
            correctButtonColor(selectedAnswer)
        }else{
            wrongButtonColor(selectedAnswer)
            correctButtonColor(crtAnswerindex)
        }
        if (currentQueIndex < question.size-1){
            currentQueIndex++
            binding.que.postDelayed({displayQue()},1000)
        }else
        { binding.result.isEnabled
          showResult()
        }
    }


}