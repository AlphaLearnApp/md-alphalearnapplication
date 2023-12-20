package com.aplhaacademy.alphalearn.data.dummy

import com.aplhaacademy.alphalearn.data.model.Course

object CourseData {
    private val courses = arrayOf(
        "All",
        "Astronomics",
        "Geography",
        "Biology",
    )

    private val titleCourses = arrayOf(
        "Nature of Light Waves",
        "Genetic Material Substance",
        "System of Linear Equations",
        "Nature of Light Waves",
    )

    private val authors = arrayOf(
        "Sarah William",
        "Sarah William",
        "Sarah William",
        "Sarah William",
    )

    private val imageUrls = arrayOf(
        "https://images.unsplash.com/photo-1432888498266-38ffec3eaf0a?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8c3R1ZHl8ZW58MHwwfDB8fHww",
        "https://images.unsplash.com/photo-1432888498266-38ffec3eaf0a?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8c3R1ZHl8ZW58MHwwfDB8fHww",
        "https://images.unsplash.com/photo-1432888498266-38ffec3eaf0a?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8c3R1ZHl8ZW58MHwwfDB8fHww",
        "https://images.unsplash.com/photo-1432888498266-38ffec3eaf0a?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8c3R1ZHl8ZW58MHwwfDB8fHww",
    )

    private val rates = arrayOf(
        5.0,
        4.8,
        4.8,
        5.0
    )

    val listData: ArrayList<Course>
        get() {
            val list = arrayListOf<Course>()
            for (position in courses.indices) {
                var course = Course()
                course.course = courses[position]
                course.titleCourse = titleCourses[position]
                course.author = authors[position]
                course.imageUrl = imageUrls[position]
                course.rating = rates[position]

                list.add(course)
            }
            return list
        }

}