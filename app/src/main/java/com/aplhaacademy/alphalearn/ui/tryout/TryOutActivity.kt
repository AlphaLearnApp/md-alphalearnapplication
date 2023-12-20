package com.aplhaacademy.alphalearn.ui.tryout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aplhaacademy.alphalearn.R
import com.aplhaacademy.alphalearn.databinding.ActivityTryOutBinding
import com.aplhaacademy.alphalearn.ui.tryoutdetail.TryOutDetailActivity
import com.aplhaacademy.alphalearn.utils.Constant.COURSE

class TryOutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTryOutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTryOutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onAction()

    }

    private fun onAction() {
        binding.apply {
            ibBack.setOnClickListener {
                finish()
            }

            cardAstronomics.setOnClickListener {
                startActivity(
                    Intent(this@TryOutActivity, TryOutDetailActivity::class.java)
                        .putExtra(COURSE, "Astronomics")
                )
            }

            cardGeography.setOnClickListener {
                startActivity(
                    Intent(this@TryOutActivity, TryOutDetailActivity::class.java)
                        .putExtra(COURSE, "Geography")
                )
            }

            cardBiology.setOnClickListener {
                startActivity(
                    Intent(this@TryOutActivity, TryOutDetailActivity::class.java)
                        .putExtra(COURSE, "Biology")
                )
            }

            cardChemistry.setOnClickListener {
                startActivity(
                    Intent(this@TryOutActivity, TryOutDetailActivity::class.java)
                        .putExtra(COURSE, "Chemistry")
                )
            }

            cardPhysics.setOnClickListener {
                startActivity(
                    Intent(this@TryOutActivity, TryOutDetailActivity::class.java)
                        .putExtra(COURSE, "Physics")
                )
            }

            cardMathematics.setOnClickListener {
                startActivity(
                    Intent(this@TryOutActivity, TryOutDetailActivity::class.java)
                        .putExtra(COURSE, "Mathematics")
                )
            }

            cardEarthiness.setOnClickListener {
                startActivity(
                    Intent(this@TryOutActivity, TryOutDetailActivity::class.java)
                        .putExtra(COURSE, "earthiness")
                )
            }

            cardInformatics.setOnClickListener {
                startActivity(
                    Intent(this@TryOutActivity, TryOutDetailActivity::class.java)
                        .putExtra(COURSE, "informatics")
                )
            }

            cardEconomy.setOnClickListener {
                startActivity(
                    Intent(this@TryOutActivity, TryOutDetailActivity::class.java)
                        .putExtra(COURSE, "economy")
                )
            }

        }
    }
}