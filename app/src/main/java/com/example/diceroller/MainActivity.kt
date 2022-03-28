package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView


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

        // Roll dice when the app first starts
        rollDice()
    }

    /**
     * Rolls the dice and shows the result on the screen
     */
    private fun rollDice() {

        // Create new Dice object with 6 sides and roll the dice.
        val dice = Dice(6)
        var diceRoll = dice.roll()

        // Target the ImageView
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determine which image to use for each roll
        val drawableDiceResource = when(diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableDiceResource)

        // Update the content description of the ImageView
        diceImage.contentDescription = diceRoll.toString()

    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
