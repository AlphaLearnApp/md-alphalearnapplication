package com.aplhaacademy.alphalearn.ui.register

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.aplhaacademy.alphalearn.custom.ButtonCustom
import com.aplhaacademy.alphalearn.custom.EmailEditText
import com.aplhaacademy.alphalearn.custom.PasswordEditText
import com.aplhaacademy.alphalearn.custom.UsernameEditText
import com.aplhaacademy.alphalearn.databinding.ActivityRegisterBinding
import com.aplhaacademy.alphalearn.model.ViewModelFactory
import com.aplhaacademy.alphalearn.repository.Result
import com.aplhaacademy.alphalearn.response.Test

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var passwordEditText: PasswordEditText
    private lateinit var emailEditText: EmailEditText
    private lateinit var buttonCustom: ButtonCustom
    private lateinit var usernameEditText: UsernameEditText

    private val registerViewModel by viewModels<RegisterViewModel> {
        ViewModelFactory.getInstance(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        passwordEditText = binding.passwordEditText
        buttonCustom = binding.signupButton
        emailEditText = binding.emailEditText
        usernameEditText = binding.nameEditText

        setupView()
        setupAction()
        playAnimation()
        setMyButtonEnable()

        passwordEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }

            override fun afterTextChanged(s: Editable) {

            }
        })
        emailEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }

            override fun afterTextChanged(s: Editable) {

            }
        })
        usernameEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }

            override fun afterTextChanged(s: Editable) {

            }
        })
    }

    private fun setMyButtonEnable() {
        val result = passwordEditText.text
        val resultt = emailEditText.text
        val resulttt = usernameEditText.text
        buttonCustom.isEnabled = result != null && result.toString().length >= 8 &&
                resultt != null && Patterns.EMAIL_ADDRESS.matcher(resultt).matches() &&
                resulttt != null && resulttt.toString().isNotEmpty()
    }

    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }

    private fun setupAction() {
        buttonCustom.setOnClickListener {
            registerViewModel.register(Test(
                binding.nameEditText.text.toString(),
                binding.emailEditText.text.toString(),
                binding.passwordEditText.text.toString())
            ).observe(this){ result ->
                when(result){
                    is Result.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                    is Result.Success -> {
                        binding.progressBar.visibility = View.GONE
                        val email = binding.emailEditText.text.toString()
                        AlertDialog.Builder(this).apply {
                            setTitle("Yeah!")
                            setMessage("The account with $email is ready, log in first!")
                            setPositiveButton("Continue") { _, _ ->
                                finish()
                            }
                            create()
                            show()
                        }
                    }
                    is Result.Error -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this, "Email is already taken", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun playAnimation() {

        val title = ObjectAnimator.ofFloat(binding.titleTextView, View.ALPHA, 1f).setDuration(100)
        val nameTextView =
            ObjectAnimator.ofFloat(binding.nameTextView, View.ALPHA, 1f).setDuration(100)
        val emailTextView =
            ObjectAnimator.ofFloat(binding.emailTextView, View.ALPHA, 1f).setDuration(100)
        val passwordTextView =
            ObjectAnimator.ofFloat(binding.passwordTextView, View.ALPHA, 1f).setDuration(100)
        val signup = ObjectAnimator.ofFloat(buttonCustom, View.ALPHA, 1f).setDuration(100)


        AnimatorSet().apply {
            playSequentially(
                title,
                nameTextView,
                emailTextView,
                passwordTextView,
                signup
            )
            startDelay = 100
        }.start()
    }
}