package com.sudip.quizappassignment7.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sudip.quizappassignment7.data.QuizModel
import com.sudip.quizappassignment7.data.QuizModelDAO
import com.sudip.quizappassignment7.util.Converter

@Database(
    entities = [QuizModel::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converter::class)
abstract class QuizDatabaseConfig: RoomDatabase() {
    abstract val quizDAO: QuizModelDAO
}