package com.example.application_teste

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        var btnnext = findViewById<Button>(R.id.second_act_btn)
        btnnext.setOnClickListener {
            val intent = Intent (this, MainActivity4::class.java)
            startActivity(intent)
        }
        var btnnext1 = findViewById<Button>(R.id.button)
        btnnext1.setOnClickListener {
            val intent = Intent (this, MainActivity5::class.java)
            startActivity(intent)
        }

        var btnnext2 = findViewById<Button>(R.id.button8)
        btnnext2.setOnClickListener {
            val intent = Intent (this, MainActivity6::class.java)
            startActivity(intent)
        }

        var btnnext3 = findViewById<Button>(R.id.button9)
        btnnext3.setOnClickListener {
            val intent = Intent (this, MainActivity2::class.java)
            startActivity(intent)
        }

        var btnnext4 = findViewById<Button>(R.id.button5)
        btnnext4.setOnClickListener {
            val intent = Intent (this, MainActivity7::class.java)
            startActivity(intent)
        }

        var btnnext5 = findViewById<Button>(R.id.button13)
        btnnext5.setOnClickListener {
            val intent = Intent (this, MainActivity3::class.java)
            startActivity(intent)
        }
        var btnnext6 = findViewById<Button>(R.id.button14)
        btnnext6.setOnClickListener {
            val intent = Intent (this, MainActivity8::class.java)
            startActivity(intent)
        }
    }
}