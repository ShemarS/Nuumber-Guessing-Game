package com.example.numberguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var tries = 0
    val LIMIT = 100
    var correctNumber = generateRandom()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        triesTextView.text = "Tries: $tries"
    }

    private fun generateRandom(): Int {
        val correctNumber = Random.nextInt(LIMIT)

        return correctNumber
    }

    fun guess(view: View) {
        var guessedNumber = userInputTextNumber.text
        tries++
        triesTextView.text = "Tries: $tries"

        textView.text = correctNumber.toString()

    }


}