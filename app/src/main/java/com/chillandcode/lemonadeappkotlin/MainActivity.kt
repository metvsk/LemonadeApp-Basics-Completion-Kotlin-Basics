package com.chillandcode.lemonadeappkotlin

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var directionsTextView: TextView? = null
    private var imageView: ImageView? = null

    //preparing list of scenes in android app with corresponding directions
    private var scene = listOf<SceneData>(
        SceneData("Tap to pluck Lemon", R.drawable.lemon_tree),
        SceneData("Tap squeeze lemon", R.drawable.lemon_squeeze),
        SceneData("Tap to drink lemon", R.drawable.lemon_drink),
        SceneData("Tap to prepare lemonade again", R.drawable.lemonade_restart),
    )

    //setting initial scene to 0
    private var currentScene: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //finding views
        directionsTextView = findViewById(R.id.textView)
        imageView = findViewById(R.id.imageView)

        //implementing touch listener to call next scene by updating the UI as the listener is invoked
        findViewById<ImageView>(R.id.imageView).setOnClickListener {
            currentScene++;
            if(currentScene>=scene.size)
                currentScene=0
            updateScene(currentScene)
        }
        //setting the initial scene
        updateScene(currentScene)
    }




    //called to update the scene according to the active scene int
    private fun updateScene(activeScene: Int) {
        setScene(scene[activeScene].direction, scene[activeScene].imageResource)
    }


    //function to set scene text directions and image
    private fun setScene(direction: String, resId: Int) {
        setDirections(direction)
        updateImage(resId)
    }


    private fun setDirections(message: String) {
        directionsTextView!!.text = message
    }

    private fun updateImage(resourceID: Int) {
        imageView!!.setImageResource(resourceID)
    }
}