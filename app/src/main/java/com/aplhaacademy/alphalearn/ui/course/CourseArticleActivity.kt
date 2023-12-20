package com.aplhaacademy.alphalearn.ui.course

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aplhaacademy.alphalearn.databinding.ActivityCourseArticleBinding

class CourseArticleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCourseArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCourseArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            val intent = Intent(this@CourseArticleActivity, CourseVideoActivity::class.java)
            startActivity(intent)
        }
    }
}