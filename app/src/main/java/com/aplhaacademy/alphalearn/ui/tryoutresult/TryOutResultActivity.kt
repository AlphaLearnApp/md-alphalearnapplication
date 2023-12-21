package com.aplhaacademy.alphalearn.ui.tryoutresult

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aplhaacademy.alphalearn.databinding.ActivityTryOutResultBinding
import com.aplhaacademy.alphalearn.ui.main.MainActivity
import com.aplhaacademy.alphalearn.ui.quizresult.QuizResultActivity
import com.aplhaacademy.alphalearn.ui.tryoutdiscuss.TryOutDiscussActivity

class TryOutResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTryOutResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTryOutResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val score = intent.getIntExtra(EXTRA_SCORE, 0)
        binding.tvScore.text = "$score %"

        onAction()
    }

    private fun onAction() {
        binding.apply {
            btnBackToHome.setOnClickListener {
                startActivity(
                    Intent(this@TryOutResultActivity, MainActivity::class.java)
                )
                finishAffinity()
            }

            btnSeeDetails.setOnClickListener {
                startActivity(
                    Intent(this@TryOutResultActivity, TryOutDiscussActivity::class.java)
                )
            }
        }
    }

    companion object{
        const val EXTRA_SCORE = "extra_score"
    }
}