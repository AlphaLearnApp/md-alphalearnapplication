package com.aplhaacademy.alphalearn.data.model

// isSolve berarti itu sudah terjawab belum, nanti kalau sudah kejawab bisa diganti true saja, biar di adapter bisa dipake ganti warna backgroundnya
data class QuestionNum (
    var number: Int = 0,
    var isSolve: Boolean = false
)