package br.com.google.google_labs_dice_roller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rowButton: Button = findViewById(R.id.button)
        rowButton.setOnClickListener { rollDice() }
        rollDice()
    }

    private fun rollDice() {

        val dice = Dice(6)
        val diceRow = dice.roll()
        //Atualização da aplicação para uso das imagens do dado
/*
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRow.toString()
*/
        val diceImage: ImageView = findViewById(R.id.imageView)

        val drawableResource =  when (diceRow){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRow.toString()

        //Código relativo à prática extra
/*
        val resultTextView2: TextView = findViewById(R.id.textView3)
        val dice2 = Dice(20)
        resultTextView2.text = dice2.roll().toString()
*/
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}