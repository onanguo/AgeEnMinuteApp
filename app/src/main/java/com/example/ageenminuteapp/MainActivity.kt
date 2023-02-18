package com.example.ageenminuteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDatapicker = findViewById<Button>(R.id.btnDatapicker)

        btnDatapicker.setOnClickListener{
            Toast.makeText(this,"Vous avez clicquer sur le bouton",Toast.LENGTH_SHORT).show()
        }
    }
}