package com.aplhaacademy.alphalearn.data.dummy

import com.aplhaacademy.alphalearn.data.model.Question

object QuestionNumData {

    val listData: ArrayList<Question>
        get() {
            val list = arrayListOf<Question>()

            for (i in 1..50) {
                val question = Question(number = i)
                list.add(question)
            }

            return list
        }

}