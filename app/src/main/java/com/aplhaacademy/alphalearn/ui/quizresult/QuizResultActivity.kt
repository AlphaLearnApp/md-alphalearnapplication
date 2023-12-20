package com.aplhaacademy.alphalearn.ui.quizresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aplhaacademy.alphalearn.R
import com.aplhaacademy.alphalearn.databinding.ActivityQuizResultBinding
import com.aplhaacademy.alphalearn.ui.fragment.MainFragmentActivity
import com.aplhaacademy.alphalearn.ui.main.MainActivity
import com.aplhaacademy.alphalearn.ui.quiz.QuizDetailActivity
import com.aplhaacademy.alphalearn.ui.quizrecommendation.QuizRecomActivity
import com.aplhaacademy.alphalearn.ui.tryoutdiscuss.TryOutDiscussActivity

class QuizResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onAction()
    }

    private fun onAction() {
        binding.apply {
            btnRetake.setOnClickListener {
                startActivity(
                    Intent(this@QuizResultActivity, QuizDetailActivity::class.java)
                )
                finish()
            }

            btnBackToCourse.setOnClickListener {
                startActivity(
                    Intent(this@QuizResultActivity, MainFragmentActivity::class.java)
                )
                finish()
            }

            btnSeeDetails.setOnClickListener {
                startActivity(
                    Intent(this@QuizResultActivity, QuizRecomActivity::class.java)
                )
            }
        }
    }
}