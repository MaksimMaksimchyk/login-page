package com.example.login_page

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class EnteredFragment : Fragment(R.layout.fragment_entered) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val logoutButton: Button = view.findViewById<Button>(R.id.logout_button)
        logoutButton.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "You have logged out of your account",
                Toast.LENGTH_LONG
            ).show()
            findNavController().navigate(R.id.action_enteredFragment_to_loginFragment)
        }

        val contentImage: ImageView = view.findViewById<ImageView>(R.id.content_image)
        var imageSwitch = 1
        contentImage.setOnClickListener {
            imageSwitch++
            if (imageSwitch % 2 == 0) {
                (it as ImageView).setImageResource(R.drawable.sticker_third)
            } else (it as ImageView).setImageResource(R.drawable.sticker_second)

        }

    }
}