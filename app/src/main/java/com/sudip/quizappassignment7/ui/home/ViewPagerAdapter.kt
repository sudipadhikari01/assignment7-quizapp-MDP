package com.sudip.quizappassignment7.ui.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sudip.quizappassignment7.constants.Constant.IS_CHECK_BOX
import com.sudip.quizappassignment7.constants.Constant.IS_RADIO_BUTTON
import com.sudip.quizappassignment7.data.QuizModel
import com.sudip.quizappassignment7.ui.checkBoxQuestions.CheckBoxQuestionFragment
import com.sudip.quizappassignment7.ui.radioButtonQuestions.RadioButtonQuestionFragment
import com.sudip.quizappassignment7.ui.result.ResultFragment
import com.google.gson.Gson

class ViewPagerAdapter(
    fragment: Fragment,
    private val questionList: List<QuizModel>
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = questionList.size + 1

    override fun createFragment(position: Int): Fragment {
        val fragment: Fragment = if (position == 15) {
            ResultFragment.newInstance()
        }else {
            val quiz = questionList[position]
            //creating fragment object according to position
            when(quiz.questionType) {

                IS_CHECK_BOX -> CheckBoxQuestionFragment.newInstance(Gson().toJson(quiz))

                IS_RADIO_BUTTON -> RadioButtonQuestionFragment.newInstance(Gson().toJson(quiz))

                else -> ResultFragment.newInstance()
            }
        }

        return fragment
    }

}