package com.aplhaacademy.alphalearn.ui.quiz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aplhaacademy.alphalearn.databinding.ActivityQuizDetailBinding
import com.aplhaacademy.alphalearn.ui.course.CourseArticleActivity

class QuizDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            val intent = Intent(this@QuizDetailActivity, QuizWorkingActivity::class.java)
            startActivity(intent)
        }

        binding.backButton.setOnClickListener {
            val intent = Intent(this@QuizDetailActivity, CourseArticleActivity::class.java)
            startActivity(intent)
        }
    }
}