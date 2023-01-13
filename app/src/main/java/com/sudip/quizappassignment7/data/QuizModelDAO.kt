package com.sudip.quizappassignment7.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface QuizModelDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuizQuestions(quizList : MutableList<QuizModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuiz(quiz: QuizModel)

    @Query("SELECT * FROM quizmodel")
    suspend fun getQuizList(): MutableList<QuizModel>

    @Query("SELECT * FROM quizmodel WHERE id= :id")
    suspend fun getQuiz(id: Int): QuizModel

}