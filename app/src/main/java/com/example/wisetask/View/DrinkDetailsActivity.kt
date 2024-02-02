// DrinkDetailsActivity.kt

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

        // Check if data is passed through intent
        if (intent.hasExtra("cocktail")) {
            // Retrieve Cocktail object from intent
            val cocktail = intent.getSerializableExtra("cocktail") as? Cocktail

            // Initialize views
            val imageViewDetails: ImageView = findViewById(R.id.imageViewDetails)
            val textNameDetails: TextView = findViewById(R.id.textNameDetails)
            val textInstructionsDetails: TextView = findViewById(R.id.textInstructionsDetails)

            // Display image using Glide
            Glide.with(this)
                .load(cocktail?.strDrinkThumb)
                .into(imageViewDetails)

            // Display text data
            textNameDetails.text = cocktail?.strDrink
            textInstructionsDetails.text = cocktail?.strInstructions
        }
    }
}
