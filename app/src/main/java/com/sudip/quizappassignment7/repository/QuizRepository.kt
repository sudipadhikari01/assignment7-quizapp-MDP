package com.sudip.quizappassignment7.repository

import com.sudip.quizappassignment7.data.QuizModel

interface QuizRepository {
    suspend fun insertQuizQuestions(quizList : MutableList<QuizModel>)
    suspend fun insertQuiz(quiz: QuizModel)
    suspend fun getQuizList(): MutableList<QuizModel>
    suspend fun resetQuestionSet()
}