package com.sudip.quizappassignment7.repository

import com.sudip.quizappassignment7.data.QuizModel
import com.sudip.quizappassignment7.data.QuizModelDAO
import com.sudip.quizappassignment7.database.QuizDatabaseConfig
import javax.inject.Inject

class QuizRepositoryImpl @Inject constructor(
    private val db: QuizDatabaseConfig
) : QuizRepository {

    private var quizDao: QuizModelDAO = db.quizDAO

    override suspend fun insertQuizQuestions(quizList: MutableList<QuizModel>) {
        quizDao.insertQuizQuestions(quizList)
    }

    override suspend fun insertQuiz(quiz: QuizModel) {
        quizDao.insertQuiz(quiz)
    }

    override suspend fun getQuizList(): MutableList<QuizModel> {
        return quizDao.getQuizList()
    }

    override suspend fun resetQuestionSet() {
        db.clearAllTables()
    }

}