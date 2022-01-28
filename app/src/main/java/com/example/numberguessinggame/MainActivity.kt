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
        textView.text = "$correctNumber"
    }

    private fun generateRandom(): Int {
        return Random.nextInt(LIMIT)
    }

    private fun clear() {
        userInputTextNumber.setText("")

    }
    private fun restart() {
        tries = 0
        triesTextView.text = "Tries: $tries"
        correctNumber = generateRandom()
    }

    fun guess(view: View) {
        if (userInputTextNumber.text.toString() == ""){
            Toast.makeText(this, "Please enter a correct number!", Toast.LENGTH_SHORT).show()
            return
        }
        promptTextView.visibility = View.VISIBLE
        var guessedNumber = userInputTextNumber.text.toString().toInt()

        if (guessedNumber == correctNumber) {
            promptTextView.text = "$guessedNumber was the right number! \n To play again, press play again!"
            restart()
        }
        else if (guessedNumber < correctNumber) {
            promptTextView.text = "Guess higher!"
            clear()
        }
        else if (guessedNumber > correctNumber) {
            promptTextView.text = "Guess lower!"
            clear()
        }
        tries++
        triesTextView.text = "Tries: $tries"
    }

}