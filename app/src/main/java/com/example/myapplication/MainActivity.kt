package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    var email: String = null.toString();
    var pas: String = null.toString();


    val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            email = it.data?.getStringExtra("mail").toString()
            pas = it.data?.getStringExtra("pas").toString()
            findViewById<TextInputEditText>(R.id.mail).setText(email)
            findViewById<TextInputEditText>(R.id.password).setText("")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.enter_btn).setOnClickListener {
            if (findViewById<TextInputEditText>(R.id.password).text.toString() == pas &&
                findViewById<TextInputEditText>(R.id.mail).text.toString() == email) {
                setContentView(R.layout.very_good)
            }
        }

        findViewById<Button>(R.id.reg_btn).setOnClickListener {
            launcher.launch(NextActivity.getIntent(this))
        }
    }
}