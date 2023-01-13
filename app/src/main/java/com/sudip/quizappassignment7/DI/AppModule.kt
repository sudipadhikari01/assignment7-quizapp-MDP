package com.sudip.quizappassignment7.DI

import android.app.Application
import androidx.room.Room
import com.sudip.quizappassignment7.constants.Constant.DB_NAME
import com.sudip.quizappassignment7.repository.QuizRepository
import com.sudip.quizappassignment7.repository.QuizRepositoryImpl
import com.sudip.quizappassignment7.database.QuizDatabaseConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideQuizDatabase(context: Application) : QuizDatabaseConfig {
        return Room.databaseBuilder(
            context,
            QuizDatabaseConfig::class.java,
            DB_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideQuizRepository(db: QuizDatabaseConfig) : QuizRepository {
        return QuizRepositoryImpl(db)
    }

 }