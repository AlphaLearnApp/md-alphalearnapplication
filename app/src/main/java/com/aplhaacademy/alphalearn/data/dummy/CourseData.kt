package com.aplhaacademy.alphalearn.data.dummy

import com.aplhaacademy.alphalearn.R
import com.aplhaacademy.alphalearn.data.model.Course
import com.aplhaacademy.alphalearn.data.model.CourseTopic

object CourseData {

    fun getAllData(): List<CourseTopic> {
        return listOf(
            CourseTopic("Title of Astronomics Course", "Astronomics", R.drawable.photodummy),
            CourseTopic("Title of Chemistry Course", "Chemistry", R.drawable.photodummy),
            CourseTopic("Title of Biology Course", "Biology", R.drawable.photodummy),
            CourseTopic("Iklim dan Perubahan Iklim", "Geography", R.drawable.photodummy),
            CourseTopic("Oseanografi dan Pengelolaan Wilayah DAS, Pesisir, dan Laut", "Geography", R.drawable.photodummy),
            CourseTopic("Kebencanaan dan Manajemen Bencana", "Geography", R.drawable.photodummy),
            CourseTopic("Title of Physics Course", "Physics", R.drawable.photodummy),
            CourseTopic("Title of Mathematics Course", "Mathematics", R.drawable.photodummy),
            CourseTopic("Title of Informatics Course", "Informatics", R.drawable.photodummy),
            CourseTopic("Title of Earthiness Course", "Earthiness", R.drawable.photodummy),
            CourseTopic("Title of Economy Course", "Economy", R.drawable.photodummy),
        )
    }
    fun getAstronomyData(): List<CourseTopic> {
        return listOf(
            CourseTopic("Title of Astronomics Course", "Astronomics", R.drawable.photodummy),
            CourseTopic("Title of Astronomics Course", "Astronomics", R.drawable.photodummy),
            CourseTopic("Title of Astronomics Course", "Astronomics", R.drawable.photodummy),
        )
    }

    fun getChemistryData(): List<CourseTopic> {
        return listOf(
            CourseTopic("Title of Chemistry Course", "Chemistry", R.drawable.photodummy),
            CourseTopic("Title of Chemistry Course", "Chemistry", R.drawable.photodummy),
            CourseTopic("Title of Chemistry Course", "Chemistry", R.drawable.photodummy),
        )
    }

    fun getBiologyData(): List<CourseTopic> {
        return listOf(
            CourseTopic("Title of Biology Course", "Biology", R.drawable.photodummy),
            CourseTopic("Title of Biology Course", "Biology", R.drawable.photodummy),
            CourseTopic("Title of Biology Course", "Biology", R.drawable.photodummy),
        )
    }

    fun getGeographyData(): List<CourseTopic> {
        return listOf(
            CourseTopic("Iklim dan Perubahan Iklim", "Geography", R.drawable.photodummy),
            CourseTopic("Oseanografi dan Pengelolaan Wilayah DAS, Pesisir, dan Laut", "Geography", R.drawable.photodummy),
            CourseTopic("Kebencanaan dan Manajemen Bencana", "Geography", R.drawable.photodummy),
        )
    }

    fun getPhysicsData(): List<CourseTopic> {
        return listOf(
            CourseTopic("Title of Physics Course", "Physics", R.drawable.photodummy),
            CourseTopic("Title of Physics Course", "Physics", R.drawable.photodummy),
            CourseTopic("Title of Physics Course", "Physics", R.drawable.photodummy),
        )
    }

    fun getMathematicsData(): List<CourseTopic> {
        return listOf(
            CourseTopic("Title of Mathematics Course", "Mathematics", R.drawable.photodummy),
            CourseTopic("Title of Mathematics Course", "Mathematics", R.drawable.photodummy),
            CourseTopic("Title of Mathematics Course", "Mathematics", R.drawable.photodummy),
        )
    }

    fun getInformaticsData(): List<CourseTopic> {
        return listOf(
            CourseTopic("Title of Informatics Course", "Informatics", R.drawable.photodummy),
            CourseTopic("Title of Informatics Course", "Informatics", R.drawable.photodummy),
            CourseTopic("Title of Informatics Course", "Informatics", R.drawable.photodummy),
        )
    }

    fun getEarthinessData(): List<CourseTopic> {
        return listOf(
            CourseTopic("Title of Earthiness Course", "Earthiness", R.drawable.photodummy),
            CourseTopic("Title of Earthiness Course", "Earthiness", R.drawable.photodummy),
            CourseTopic("Title of Earthiness Course", "Earthiness", R.drawable.photodummy),
        )
    }

    fun getEconomyData(): List<CourseTopic> {
        return listOf(
            CourseTopic("Title of Economy Course", "Economy", R.drawable.photodummy),
            CourseTopic("Title of Economy Course", "Economy", R.drawable.photodummy),
            CourseTopic("Title of Economy Course", "Economy", R.drawable.photodummy),
        )
    }

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