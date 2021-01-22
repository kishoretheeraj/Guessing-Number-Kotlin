package com.example.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.guess.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    var number: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val min = 1
        val max = 100

        number = getRandomNumber(min, max)


        binding.playagain.setOnClickListener {
            onBackPressed()
        }

        binding.buttonguess.setOnClickListener {

            val userguess = binding.userguess.text.toString().toInt()
            when {
                userguess < number -> {
                    makeToast("Think of Higher Number, Try again")
                }
                userguess > number -> {
                    makeToast("Think of Lower Number, Try again")
                }
                else -> {
                    makeToast("Congratulations, You Guessed it's $number!!!")
                }
            }
        }


    }

    private fun getRandomNumber(max: Int, min: Int): Int {
        return ((Math.random() * (max - min)) + min).toInt()
    }

    private fun makeToast(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }
}