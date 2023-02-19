package com.example.ageenminuteapp

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var tvDateSelectionner: TextView?= null
    private  var tvDateEnMinute: TextView? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDatapicker = findViewById<Button>(R.id.btnDatapicker)
            tvDateSelectionner = findViewById(R.id.tvDateSelectionner)
            tvDateEnMinute = findViewById(R.id.tvDateEnMinute)

        btnDatapicker.setOnClickListener{
            Datepicker()
        }
    }

    private fun Datepicker(){
        val mycalendar = Calendar.getInstance()
        val annee = mycalendar.get(Calendar.YEAR)
        val mois = mycalendar.get(Calendar.MONTH)
        val jour = mycalendar.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(this,
           {_,anneeSelectionner,moisSelectionner,jourSelectionner ->

                // Toast.makeText(this,"L'annee est $anneeSelectionner", Toast.LENGTH_SHORT).show()

                val DateSelectionner= "$jourSelectionner/${moisSelectionner+1}/$anneeSelectionner"
                tvDateSelectionner?.text = DateSelectionner

                val sdf= SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val ladate =sdf.parse(DateSelectionner)
                ladate?.let {
                    val laDateEnMinute= ladate.time/60000

                    val dateActuelle= sdf.parse(sdf.format(System.currentTimeMillis()))
                    dateActuelle?.let {
                        val dateActuelleEnMinute= dateActuelle.time/60000

                        val diffenceEnMinute= dateActuelleEnMinute - laDateEnMinute
                        tvDateEnMinute?.text= diffenceEnMinute.toString()
                    }
                }
            },
            annee,
            mois,
            jour
        )
        dpd.datePicker.maxDate = System.currentTimeMillis() -86400000
        dpd.show()
    }
}