package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.google.android.material.textfield.TextInputEditText
import org.w3c.dom.Text
import java.sql.Struct

class NextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        findViewById<Button>(R.id.reg_btn).setOnClickListener {
            val email = findViewById<TextInputEditText>(R.id.mail).text.toString()
            val pas = findViewById<TextInputEditText>(R.id.pas).text.toString()
            val rep_pas = findViewById<TextInputEditText>(R.id.rep_pas).text.toString()

            val intent = Intent()
            if (pas == rep_pas) {
                intent.putExtra("mail", email)
                intent.putExtra("pas", pas)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }

    companion object {
        fun getIntent(context: Context) : Intent {
            val intent = Intent(context, NextActivity::class.java)
            return intent
        }
    }
}