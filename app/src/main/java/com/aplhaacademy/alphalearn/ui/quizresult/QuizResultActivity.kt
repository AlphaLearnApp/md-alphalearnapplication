package com.aplhaacademy.alphalearn.ui.quizresult

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aplhaacademy.alphalearn.databinding.ActivityQuizResultBinding
import com.aplhaacademy.alphalearn.ui.fragment.MainFragmentActivity
import com.aplhaacademy.alphalearn.ui.quiz.QuizDetailActivity
import com.aplhaacademy.alphalearn.ui.quizrecommendation.QuizRecomActivity

class QuizResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val score = intent.getIntExtra(EXTRA_SCORE, 0)
        binding.tvScore.text = "$score %"

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

    companion object{
        const val EXTRA_SCORE = "extra_score"
    }
}