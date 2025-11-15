package com.example.login_page

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Скрытие всплывающих подсказок
        val emailHintFrame: FrameLayout = view.findViewById<FrameLayout>(R.id.email_hint_frame)
        emailHintFrame.visibility = View.GONE
        val passwordHintFrame: FrameLayout =
            view.findViewById<FrameLayout>(R.id.password_hint_frame)
        passwordHintFrame.visibility = View.GONE

        //Показать всплывающую подсказку при начале ввода
        val editTextTextEmailAddress: EditText =
            view.findViewById<EditText>(R.id.editTextTextEmailAddress)
        editTextTextEmailAddress.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                emailHintFrame.visibility = View.VISIBLE
            } else emailHintFrame.visibility = View.GONE
        }

        val editTextPassword: EditText = view.findViewById<EditText>(R.id.editTextPassword)
        editTextPassword.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                passwordHintFrame.visibility = View.VISIBLE
            } else passwordHintFrame.visibility = View.GONE

        }

        val signUp: TextView = view.findViewById<TextView>(R.id.sign_up_text_button)
        signUp.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }


    }

}