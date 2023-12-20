package com.aplhaacademy.alphalearn.ui.login

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
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
import com.aplhaacademy.alphalearn.databinding.ActivityLoginBinding
import com.aplhaacademy.alphalearn.model.ViewModelFactory
import com.aplhaacademy.alphalearn.pref.UserModel
import com.aplhaacademy.alphalearn.repository.Result
import com.aplhaacademy.alphalearn.response.LoginRequest
import com.aplhaacademy.alphalearn.ui.main.MainActivity
import com.aplhaacademy.alphalearn.ui.register.RegisterActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var passwordEditText: PasswordEditText
    private lateinit var buttonCustom: ButtonCustom
    private lateinit var emailEditText: EmailEditText

    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel by viewModels<LoginViewModel> {
        ViewModelFactory.getInstance(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        passwordEditText = binding.passwordEditText
        buttonCustom = binding.loginButton
        emailEditText = binding.emailEditText

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
    }

    private fun setMyButtonEnable() {
        val result = passwordEditText.text
        val resultt = emailEditText.text
        buttonCustom.isEnabled = result != null && result.toString().length >= 8 &&
                resultt != null && Patterns.EMAIL_ADDRESS.matcher(resultt).matches()
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
        binding.tvSignup.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }

        buttonCustom.setOnClickListener {
            loginViewModel.login(LoginRequest(
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
                        val token = result.data.token
                        val userModel = UserModel(email, token)
                        loginViewModel.saveSession(userModel)
                        AlertDialog.Builder(this).apply {
                            setTitle("Yeah!")
                            setMessage("Login Successfully")
                            setPositiveButton("Continue") { _, _ ->
                                val intent = Intent(context, MainActivity::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                                startActivity(intent)
                                finish()
                            }
                            create()
                            show()
                        }
                    }
                    is Result.Error -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun playAnimation() {

        val title =
            ObjectAnimator.ofFloat(binding.tvTitle, View.ALPHA, 1f).setDuration(100)
        val emailTextView =
            ObjectAnimator.ofFloat(binding.emailTextView, View.ALPHA, 1f).setDuration(100)
        val passwordTextView =
            ObjectAnimator.ofFloat(binding.passwordTextView, View.ALPHA, 1f).setDuration(100)
        val login = ObjectAnimator.ofFloat(buttonCustom, View.ALPHA, 1f).setDuration(100)

        AnimatorSet().apply {
            playSequentially(
                title,
                emailTextView,
                passwordTextView,
                login
            )
            startDelay = 100
        }.start()
    }
}