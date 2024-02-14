package com.hasanfadiloglu.rickandmortygame

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.hasanfadiloglu.rickandmortygame.databinding.ActivityRickScreenBinding
import kotlin.random.Random

class rickScreen : AppCompatActivity() {

    private lateinit var binding: ActivityRickScreenBinding
    var score = 0
    var rickArray = ArrayList<ImageView>()
    var runnable = Runnable {}
    var handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRickScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        rickArray.add(binding.rick1)
        rickArray.add(binding.rick2)
        rickArray.add(binding.rick3)
        rickArray.add(binding.rick4)
        rickArray.add(binding.rick5)
        rickArray.add(binding.rick6)
        rickArray.add(binding.rick7)
        rickArray.add(binding.rick8)
        rickArray.add(binding.rick9)
        rickArray.add(binding.rick10)
        rickArray.add(binding.rick11)
        rickArray.add(binding.rick12)
        rickArray.add(binding.rick13)
        rickArray.add(binding.rick14)
        rickArray.add(binding.rick15)
        rickArray.add(binding.rick16)
        rickArray.add(binding.rick17)
        rickArray.add(binding.rick18)
        rickArray.add(binding.rick19)
        rickArray.add(binding.rick20)
        rickArray.add(binding.rick21)
        rickArray.add(binding.rick22)
        rickArray.add(binding.rick23)
        rickArray.add(binding.rick24)
        rickArray.add(binding.rick25)
        rickArray.add(binding.rick26)
        rickArray.add(binding.rick27)
        rickArray.add(binding.rick28)
        rickArray.add(binding.rick29)
        rickArray.add(binding.rick30)
        rickArray.add(binding.rick31)
        rickArray.add(binding.rick32)
        rickArray.add(binding.rick33)
        rickArray.add(binding.rick34)
        rickArray.add(binding.rick35)

        hideImages()

        object : CountDownTimer(30500,1000){
            override fun onTick(millisUntilFinished: Long) {
                binding.timeText.text = "TIME : ${millisUntilFinished/1000}"
            }

            override fun onFinish() {
                binding.timeText.text = "TIME OUT!"
                handler.removeCallbacks(runnable)

                for(image in rickArray){
                    image.visibility = View.INVISIBLE
                }
                val alert = AlertDialog.Builder(this@rickScreen)
                alert.setTitle("GAME OVER")
                alert.setMessage("Your Score: ${score}" + "\n" + "Restart Game ?")
                alert.setPositiveButton("YES",object : DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        val intentRick = intent
                        startActivity(intent)
                    }


                })
                alert.setNegativeButton("NO"){ dialog , which ->
                    val intent = Intent(this@rickScreen, MainActivity::class.java)
                    startActivity(intent)
                }

                alert.show()
            }

        }.start()
    }
    fun hideImages(){
        runnable = object : Runnable{
            override fun run() {
                for(image in rickArray){
                    image.visibility = View.INVISIBLE
                }
                val random = java.util.Random()
                val randomIndex = random.nextInt(35)
                rickArray[randomIndex].visibility = View.VISIBLE

                handler.postDelayed(runnable,400)
            }

        }
        handler.post(runnable)
    }
    fun increaseScore(view : View){
        score = score + 1
        binding.scoreText.text = "SCORE : ${score}"
    }
}