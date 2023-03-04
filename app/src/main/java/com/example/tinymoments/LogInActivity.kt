package com.example.tinymoments

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class LogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        startActivity(Intent(this@LogInActivity, MainActivity::class.java))
    }




}