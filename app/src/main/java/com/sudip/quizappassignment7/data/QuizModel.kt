package com.sudip.quizappassignment7.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class QuizModel(
    @PrimaryKey val id: Int,
    val question: String,
    val questionType: String,
    val answerExplanation: String,
    val answer: String,
    val answerDesc: String,
    var userAnswer: String? = null,
    var userAnswerDesc: String? = null,
    var options: MutableList<String>
)


