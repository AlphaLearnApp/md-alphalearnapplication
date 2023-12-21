package com.aplhaacademy.alphalearn.data.dummy

import com.aplhaacademy.alphalearn.data.model.TitleCourse

object TitleCourseData {

    private val titleCourses = arrayOf(
        "All",
        "Astronomics",
        "Geography",
        "Biology",
        "Chemistry",
        "Physics",
        "Mathematics",
        "Earthiness",
        "Informatics",
        "Economy"
    )

    private val status = arrayOf(
        true,
        false,
        false,
        false,
        false,
        false,
        false,
        false,
        false,
        false,
    )

    val listData : ArrayList<TitleCourse>
        get() {
            val list = arrayListOf<TitleCourse>()
            for (position in titleCourses.indices) {
                var titleCourse = TitleCourse()
                titleCourse.title = titleCourses[position]
                titleCourse.status = status[position]

                list.add(titleCourse)
            }
            return list
        }
}