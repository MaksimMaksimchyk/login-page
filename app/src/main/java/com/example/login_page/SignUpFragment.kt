package com.example.login_page

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Скрытие всплывающих подсказок
        val emailHintFrame: FrameLayout = view.findViewById<FrameLayout>(R.id.email_hint_frame)
        emailHintFrame.visibility = View.GONE
        val passwordHintFrame: FrameLayout =
            view.findViewById<FrameLayout>(R.id.password_hint_frame)
        passwordHintFrame.visibility = View.GONE
        val phoneHintFrame: FrameLayout = view.findViewById<FrameLayout>(R.id.phone_hint_frame)
        phoneHintFrame.visibility = View.GONE

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

        val editPhone: EditText = view.findViewById<EditText>(R.id.editTextPhone)
        editPhone.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                phoneHintFrame.visibility = View.VISIBLE
            } else phoneHintFrame.visibility = View.GONE
        }


        //Кнопка регистрации
        val regButton: Button = view.findViewById<Button>(R.id.registration_button)
        regButton.setOnClickListener {
            Toast.makeText(requireContext(), "You have registered successfully!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        }

    }

}