package com.sudip.quizappassignment7.database

import android.content.Context
import androidx.room.Room
import com.sudip.quizappassignment7.constants.Constant
import com.sudip.quizappassignment7.data.QuizModelDAO

class QuizAppDB(context: Context) {

    private var quizDatabase: QuizDatabaseConfig = Room.databaseBuilder(
        context,
        QuizDatabaseConfig::class.java,
        Constant.DB_NAME
    ).build()

    fun getQuizDAO(): QuizModelDAO = quizDatabase.quizDAO
}