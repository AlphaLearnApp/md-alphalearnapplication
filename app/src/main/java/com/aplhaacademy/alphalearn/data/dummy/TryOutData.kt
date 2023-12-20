package com.aplhaacademy.alphalearn.data.dummy

import com.aplhaacademy.alphalearn.R
import com.aplhaacademy.alphalearn.data.model.Course
import com.aplhaacademy.alphalearn.data.model.TryOut

object TryOutData {

    private val courses = arrayOf(
        "Geography",
        "Geography",
        "Geography",
    )

    private val titleCourses = arrayOf(
        "Title of Try Out",
        "Title of Try Out",
        "Title of Try Out",
    )

    private val imageUrls = intArrayOf(
        R.drawable.geography_pic,
        R.drawable.geography_pic,
        R.drawable.geography_pic,
    )

    private val times = arrayOf(
        120,
        120,
        120
    )

    private val questionTotals = arrayOf(
        50,
        50,
        50
    )

    val listData: ArrayList<TryOut>
        get() {
            val list = arrayListOf<TryOut>()
            for (position in courses.indices) {
                var tryout = TryOut()
                tryout.course = courses[position]
                tryout.titleTryout = titleCourses[position]
                tryout.imageUrl = imageUrls[position]
                tryout.time = times[position]
                tryout.questionTotal = questionTotals[position]

                list.add(tryout)
            }
            return list
        }
}