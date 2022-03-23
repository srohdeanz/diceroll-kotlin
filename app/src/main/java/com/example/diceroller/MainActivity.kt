package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

/**
 * This activity allows the user to roll a dice and view the result on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the Button View and assign it to a value
        val rollButton: Button = findViewById(R.id.button)

        // Set click event listener to rollButton, which calls the rollDice when the button is clicked.
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Rolls the dice and shows the result on the screen
     */
    private fun rollDice() {

        // Create new Dice object with 6 sides
        val dice = Dice(6)

        // Call the roll method of dice and save the value to 'diceRoll'
        var diceRoll = dice.roll()

        // Find the TextView and assign it to a value
        val resultTextView: TextView = findViewById(R.id.textView)

        // Save the dice roll to the text of the TextView object. We need to change it to a string first.
        resultTextView.text = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
