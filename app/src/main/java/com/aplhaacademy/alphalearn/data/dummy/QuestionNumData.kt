package com.aplhaacademy.alphalearn.data.dummy

import com.aplhaacademy.alphalearn.data.model.QuestionNum

object QuestionNumData {

    // saat ingin menggunakan data ini silahkan isi dahulu total questionnya dengan panjang soal yang ada, sudah saya beri contoh di activity work quiz
    var totalQestion = 0

    val listData: ArrayList<QuestionNum>
        get() {
            val list = arrayListOf<QuestionNum>()

            for (i in 1..totalQestion) {
                val question = QuestionNum(number = i)
                list.add(question)
            }

            return list
        }

}