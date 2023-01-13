package com.sudip.quizappassignment7.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sudip.quizappassignment7.data.QuizModel
import com.sudip.quizappassignment7.repository.QuizRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val repository: QuizRepository
) : ViewModel(){

    private val _data: MutableLiveData<List<QuizModel>> = MutableLiveData()
    val data: LiveData<List<QuizModel>> = _data

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            _data.postValue(repository.getQuizList())
        }
    }

    fun resetDatabase(newList: MutableList<QuizModel>) {
        viewModelScope.launch(Dispatchers.IO) {
            _data.postValue(newList)
        }
    }

    fun saveUserAnswer(quiz: QuizModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertQuiz(quiz)
        }
    }
}