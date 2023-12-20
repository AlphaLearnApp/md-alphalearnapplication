package com.aplhaacademy.alphalearn.ui.tryoutresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aplhaacademy.alphalearn.R
import com.aplhaacademy.alphalearn.databinding.ActivityTryOutResultBinding
import com.aplhaacademy.alphalearn.ui.main.MainActivity
import com.aplhaacademy.alphalearn.ui.tryoutdiscuss.TryOutDiscussActivity

class TryOutResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTryOutResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTryOutResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
}