package com.example.twelfthtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        val animals = intent.getParcelableExtra<Animals>("animals")
        if (animals != null) {
            val title : TextView = findViewById(R.id.titleDetailedID)
            val imageView : ImageView = findViewById(R.id.imageDetailedID)
            val description : TextView = findViewById(R.id.descriptionDetailedID)

            title.text = animals.title
            description.text = animals.description
            imageView.setImageResource(animals.image)
        }
    }
}