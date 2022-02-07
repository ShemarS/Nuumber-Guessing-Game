package com.example.numberguessinggame

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var tries = 0
    val LOWER_LIMIT = 0
    val UPPER_LIMIT = 100
    var correctNumber = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        winImageView.visibility = View.VISIBLE
        initialize()
    }

    private fun generateRandom(): Int {
        return Random.nextInt(LOWER_LIMIT, UPPER_LIMIT)
    }

    private fun clear() {
        userInputTextNumber.setText("")
    }

    private fun View.hideKeyboard() {
        val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as
                InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
    }
    fun playAgain(view: View) {
        tries = 0
        correctNumber = generateRandom()
        winImageView.visibility = View.INVISIBLE
        playAgainButton.visibility = View.INVISIBLE
        promptTextView.visibility = View.INVISIBLE
        triesTextView.text = "Tries: $tries"
        winTextView.text = correctNumber.toString()
        guessButton.text = "Guess"
    }
    fun initialize() {
        correctNumber = generateRandom()
        winImageView.visibility = View.INVISIBLE
        triesTextView.text = "Tries: $tries"
    }

    fun guess(view: View) {
        winImageView.visibility = View.INVISIBLE
        userInputTextNumber.hideKeyboard()
        if (userInputTextNumber.text.toString() == ""){
            Toast.makeText(this, "Please enter a correct number!", Toast.LENGTH_SHORT).show()
            return
        }
        promptTextView.visibility = View.VISIBLE
        var guessedNumber = userInputTextNumber.text.toString().toInt()

        if (guessedNumber == correctNumber) {
            promptTextView.text = "$guessedNumber was the right number!"
            winTextView.text = "To play again, press play again!"
            winImageView.visibility = View.VISIBLE
            playAgainButton.visibility = View.VISIBLE

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