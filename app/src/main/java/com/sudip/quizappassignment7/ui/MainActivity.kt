package com.sudip.quizappassignment7.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sudip.quizappassignment7.R
import com.sudip.quizappassignment7.data.QuizSampleData
import com.sudip.quizappassignment7.database.QuizAppDB
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initQuizData()
        setContentView(R.layout.activity_main)
    }

    private fun initQuizData() {
        val initialQuestions = QuizSampleData.getQuizQuestions()
        val quizDAO = QuizAppDB(this).getQuizDAO()

        MainScope().launch(Dispatchers.IO) {
            quizDAO.insertQuizQuestions(initialQuestions)
        }
    }

}