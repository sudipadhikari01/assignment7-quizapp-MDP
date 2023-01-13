package com.sudip.quizappassignment7.util

import com.sudip.quizappassignment7.data.AnswerModelFormat

interface CheckClickInterface {
    fun onCheckBoxChecked(answerModel: AnswerModelFormat)
    fun onCheckBoxUnChecked(answerModel: AnswerModelFormat)
}