package com.aplhaacademy.alphalearn.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.aplhaacademy.alphalearn.R
import com.aplhaacademy.alphalearn.databinding.ActivityMainFragmentBinding
import com.aplhaacademy.alphalearn.ui.main.MainActivity

class MainFragmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadFragment(AllCourseFragment())

        binding.backButton.setOnClickListener {
            val intent = Intent(this@MainFragmentActivity, MainActivity::class.java)
            startActivity(intent)
        }

        binding.astronomicsButton.setOnClickListener {
            loadFragment(AstronomyFragment())
        }

        binding.chemistryButton.setOnClickListener {
            loadFragment(ChemistryFragment())
        }

        binding.allButton.setOnClickListener {
            loadFragment(AllCourseFragment())
        }

        binding.biologyButton.setOnClickListener {
            loadFragment(BiologyFragment())
        }

        binding.informaticsButton.setOnClickListener {
            loadFragment(InformaticsFragment())
        }

        binding.geographyButton.setOnClickListener {
            loadFragment(GeographyFragment())
        }

        binding.physicButton.setOnClickListener {
            loadFragment(PhysicsFragment())
        }

        binding.mathematicsButton.setOnClickListener {
            loadFragment(MathematicsFragment())
        }

        binding.earthinessButton.setOnClickListener {
            loadFragment(EarthinessFragment())
        }

        binding.economyButton.setOnClickListener {
            loadFragment(EconomyFragment())
        }

    }

    private fun loadFragment(fragment: Fragment) {
        val fm: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fm.beginTransaction()
        fragmentTransaction.replace(R.id.frame_container, fragment)
        fragmentTransaction.commit()

        when (fragment) {
            is AstronomyFragment -> setBackground(binding.astronomicsButton)
            is ChemistryFragment -> setBackground(binding.chemistryButton)
            is AllCourseFragment -> setBackground(binding.allButton)
            is BiologyFragment -> setBackground(binding.biologyButton)
            is GeographyFragment -> setBackground(binding.geographyButton)
            is PhysicsFragment -> setBackground(binding.physicButton)
            is MathematicsFragment -> setBackground(binding.mathematicsButton)
            is InformaticsFragment -> setBackground(binding.informaticsButton)
            is EarthinessFragment -> setBackground(binding.earthinessButton)
            is EconomyFragment -> setBackground(binding.economyButton)
        }
    }

    private fun setBackground(button: Button) {

        binding.astronomicsButton.setBackgroundResource(R.drawable.bg_rounded_soft_mustard)
        binding.chemistryButton.setBackgroundResource(R.drawable.bg_rounded_soft_mustard)
        binding.allButton.setBackgroundResource(R.drawable.bg_rounded_soft_mustard)
        binding.biologyButton.setBackgroundResource(R.drawable.bg_rounded_soft_mustard)
        binding.geographyButton.setBackgroundResource(R.drawable.bg_rounded_soft_mustard)
        binding.physicButton.setBackgroundResource(R.drawable.bg_rounded_soft_mustard)
        binding.mathematicsButton.setBackgroundResource(R.drawable.bg_rounded_soft_mustard)
        binding.informaticsButton.setBackgroundResource(R.drawable.bg_rounded_soft_mustard)
        binding.earthinessButton.setBackgroundResource(R.drawable.bg_rounded_soft_mustard)
        binding.economyButton.setBackgroundResource(R.drawable.bg_rounded_soft_mustard)

        binding.astronomicsButton.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
        binding.chemistryButton.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
        binding.allButton.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
        binding.biologyButton.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
        binding.geographyButton.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
        binding.physicButton.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
        binding.mathematicsButton.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
        binding.informaticsButton.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
        binding.earthinessButton.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
        binding.economyButton.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))

        button.setBackgroundResource(R.drawable.bg_rounded_mustard)
        button.setTextColor(ContextCompat.getColor(this, R.color.white))
    }
}