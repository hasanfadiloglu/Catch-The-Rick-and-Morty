package com.hasanfadiloglu.rickandmortygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hasanfadiloglu.rickandmortygame.databinding.ActivityChoiseScreenBinding
import com.hasanfadiloglu.rickandmortygame.databinding.ActivityMainBinding

class choiseScreen : AppCompatActivity() {

    private lateinit var binding: ActivityChoiseScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChoiseScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun selectRick(view: View){
        val intent = Intent(this, rickScreen::class.java)
        startActivity(intent)
    }

    fun selectmorty(view: View){
        val intent = Intent(this, mortyScreen::class.java)
        startActivity(intent)
    }

}

