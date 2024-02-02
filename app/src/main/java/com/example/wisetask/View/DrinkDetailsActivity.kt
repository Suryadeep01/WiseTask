package com.example.wisetask.View

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.wisetask.R
import com.example.wisetask.model.response.Cocktail

class DrinkDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink_details)

        if (intent.hasExtra("cocktail")) {
            val cocktail = intent.getSerializableExtra("cocktail") as? Cocktail

            val imageViewDetails: ImageView = findViewById(R.id.imageViewDetails)
            val textNameDetails: TextView = findViewById(R.id.textNameDetails)
            val textInstructionsDetails: TextView = findViewById(R.id.textInstructionsDetails)
            val textIngredientsDetails: TextView = findViewById(R.id.textIngredientsDetails)

            Glide.with(this)
                .load(cocktail?.strDrinkThumb) // Replace with actual property
                .into(imageViewDetails)

            textNameDetails.text = cocktail?.strDrink
            textInstructionsDetails.text = cocktail?.strInstructions

            val ingredientsBuilder = StringBuilder()
            for (i in 1..15) {
                val ingredient = getIngredient(cocktail, i)
                val measure = getMeasure(cocktail, i)

                if (!ingredient.isNullOrBlank() && !measure.isNullOrBlank()) {
                    ingredientsBuilder.append("$ingredient: $measure\n")
                }
            }
            textIngredientsDetails.text = ingredientsBuilder.toString()
        }

        val fabBack: ImageView = findViewById(R.id.fabBack)
        fabBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun getIngredient(cocktail: Cocktail?, index: Int): String? {
        return when (index) {
            1 -> cocktail?.strIngredient1
            2 -> cocktail?.strIngredient2
            3 -> cocktail?.strIngredient3
            4 -> cocktail?.strIngredient4
            5 -> cocktail?.strIngredient5
            6 -> cocktail?.strIngredient6
            7 -> cocktail?.strIngredient7
            8 -> cocktail?.strIngredient8
            9 -> cocktail?.strIngredient9
            10 -> cocktail?.strIngredient10
            11 -> cocktail?.strIngredient11
            12 -> cocktail?.strIngredient12
            13 -> cocktail?.strIngredient13
            14 -> cocktail?.strIngredient14
            15 -> cocktail?.strIngredient15
            else -> null
        }
    }

    private fun getMeasure(cocktail: Cocktail?, index: Int): String? {
        return when (index) {
            1 -> cocktail?.strMeasure1
            2 -> cocktail?.strMeasure2
            3 -> cocktail?.strMeasure3
            4 -> cocktail?.strMeasure4
            5 -> cocktail?.strMeasure5
            6 -> cocktail?.strMeasure6
            7 -> cocktail?.strMeasure7
            8 -> cocktail?.strMeasure8
            9 -> cocktail?.strMeasure9
            10 -> cocktail?.strMeasure10
            11 -> cocktail?.strMeasure11
            12 -> cocktail?.strMeasure12
            13 -> cocktail?.strMeasure13
            14 -> cocktail?.strMeasure14
            15 -> cocktail?.strMeasure15
            else -> null
        }
    }
}
