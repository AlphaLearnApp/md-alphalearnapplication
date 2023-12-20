package com.aplhaacademy.alphalearn.ui.course

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aplhaacademy.alphalearn.databinding.ActivityCourseDetailBinding
import com.aplhaacademy.alphalearn.ui.fragment.MainFragmentActivity

class CourseDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCourseDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCourseDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ibBack.setOnClickListener {
            val intent = Intent(this@CourseDetailActivity, MainFragmentActivity::class.java)
            startActivity(intent)
        }

        binding.btnJoinCourse.setOnClickListener {
            val intent = Intent(this@CourseDetailActivity, CourseVideoActivity::class.java)
            startActivity(intent)
        }
    }
}