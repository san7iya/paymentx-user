package com.iste.paymentx.ui.auth

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.iste.paymentx.R

class Phonenumber : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_phonenumber)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val confirmButton = findViewById<Button>(R.id.confirmButton)
        val textField = findViewById<EditText>(R.id.phoneNumberEditText)

        // Always enable the confirm button
        confirmButton.isEnabled = true

        // Optional: Add a TextWatcher to provide real-time feedback (not mandatory for logic)
        textField.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                // You can add real-time feedback logic here if needed
            }
        })

        confirmButton.setOnClickListener {
            val number = textField.text.toString()
            if (number.length == 10) {
                // Valid phone number, proceed to the next activity
                val intent = Intent(this, OtpVerification::class.java)
                intent.putExtra("phoneNumber", number)
                startActivity(intent)
            } else {
                // Invalid phone number, show a toast
                Toast.makeText(this, "Please enter a valid 10-digit phone number", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
