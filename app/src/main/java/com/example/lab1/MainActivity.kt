package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.lab1.R.id.*
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.IOException



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculations = Calculations()

        val result3: TextView = findViewById(R.id.textViewRes3)
        result3.setText("Числа з рекурсивним кроком: %s".format( calculations.task3()))

    }


    fun butCalc1(view: View) {
        val result1: TextView = findViewById(R.id.textViewResult1)
        val userInputC: EditText = findViewById(R.id.editTextc1)
        val userInputG: EditText = findViewById(R.id.editTextg1)

        val calculations = Calculations()


        try {
            result1.text = " "

            val c = userInputC.text.toString().toDouble()
            val g = userInputG.text.toString().toDouble()

            val res1 = calculations.task1(c, g).toDouble()

            result1.append("%.3f".format(res1))
        } catch (e: Exception) {
            result1.append("Неможливо! \n")
        }
    }

    fun butFile1(view: View) {
        val textView: TextView = findViewById(R.id.textViewResult1)
        val userInputC: EditText = findViewById(R.id.editTextc1)
        val userInputG: EditText = findViewById(R.id.editTextg1)
        val calculations = Calculations()


        var string = ""
        try {
            val inputStream = assets.open("test.txt")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)

            string = String(buffer)

        } catch (e: IOException) {
            e.printStackTrace()
        }


        var list =
            string.split("(,)|(,\\s)".toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()

        userInputC.setText(list[0])
        userInputG.setText(list[1])

        textView.setText(calculations.task1(list[0].toDouble(), list[1].toDouble()))
        println(calculations.task1(list[0].toDouble(), list[1].toDouble()))

    }

    fun butFile2(view: View) {
        val textView2: TextView = findViewById(R.id.textViewResult2)
        val userInputX: EditText = findViewById(R.id.editTextx2)
        val userInputZ: EditText = findViewById(R.id.editTextz2)
        val calculations = Calculations()


        var string = ""
        try {
            val inputStream = assets.open("test.txt")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)

            string = String(buffer)

        } catch (e: IOException) {
            e.printStackTrace()
        }


        val list =
            string.split("(,)|(,\\s)".toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()
        userInputX.setText(list[2])
        userInputZ.setText(list[3])
        textView2.setText(calculations.task2(list[2].toDouble(), list[3].toDouble()))
        println(calculations.task1(list[2].toDouble(), list[3].toDouble()))


    }

    //val butCalc1: Button = findViewById(R.id.butCalc1)


    fun butCalc2(view: View) {

        val userInputX: EditText = findViewById(R.id.editTextx2)
        val userInputZ: EditText = findViewById(R.id.editTextz2)
        val result2: TextView = findViewById(R.id.textViewResult2)
        val calculations = Calculations()

        try {
            result2.text = " "

            val x = userInputX.text.toString().toDouble()
            val z = userInputZ.text.toString().toDouble()

            val res2 = calculations.task2(x, z).toDouble()
            result2.append("%.3f".format(res2))
        } catch (e: Exception) {
            result2.append("Неможливо! \n")
        }

    }
}