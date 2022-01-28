package com.example.numberguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
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
        return Random.nextInt(LIMIT)
    }

    fun guess(view: View) {
        promptTextView.visibility = View.VISIBLE
/*        userInputTextNumber.doAfterTextChanged {
            Toast.makeText(this, "Please enter correct value!", Toast.LENGTH_SHORT).show()
        }*/
        var guessedNumber = userInputTextNumber.text.toString().toInt()

        if (userInputTextNumber.text.toString() == ""){
            Toast.makeText(this, "Please enter correct value!", Toast.LENGTH_SHORT).show()
        }
        if (guessedNumber == correctNumber) {
            promptTextView.text = "Great job you won! $guessedNumber was the right number!"
        }
        else if (guessedNumber < correctNumber) {
            promptTextView.text = "Guess higher!"
        }
        else if (guessedNumber > correctNumber) {
            promptTextView.text = "Guess lower!"
        }
        tries++
        triesTextView.text = "Tries: $tries"
    }

    fun playAgain() {
        tries = 0
        promptTextView.visibility = View.INVISIBLE
        promptTextView.text = ""
        triesTextView.text = "Tries: $tries"
    }


}