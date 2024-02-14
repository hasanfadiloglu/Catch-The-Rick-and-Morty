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
import androidx.appcompat.app.AlertDialog
import com.hasanfadiloglu.rickandmortygame.databinding.ActivityMortyScreenBinding
import java.util.ArrayList
import java.util.Random

class mortyScreen : AppCompatActivity() {

    private lateinit var binding: ActivityMortyScreenBinding

    var score = 0
    var mortyArray = ArrayList<ImageView>()
    var runnable = Runnable {}
    var handler = Handler(Looper.getMainLooper())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMortyScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mortyArray.add(binding.morty1)
        mortyArray.add(binding.morty2)
        mortyArray.add(binding.morty3)
        mortyArray.add(binding.morty4)
        mortyArray.add(binding.morty5)
        mortyArray.add(binding.morty6)
        mortyArray.add(binding.morty7)
        mortyArray.add(binding.morty8)
        mortyArray.add(binding.morty9)
        mortyArray.add(binding.morty10)
        mortyArray.add(binding.morty11)
        mortyArray.add(binding.morty12)
        mortyArray.add(binding.morty13)
        mortyArray.add(binding.morty14)
        mortyArray.add(binding.morty15)
        mortyArray.add(binding.morty16)
        mortyArray.add(binding.morty17)
        mortyArray.add(binding.morty18)
        mortyArray.add(binding.morty19)
        mortyArray.add(binding.morty20)
        mortyArray.add(binding.morty21)
        mortyArray.add(binding.morty22)
        mortyArray.add(binding.morty23)
        mortyArray.add(binding.morty24)
        mortyArray.add(binding.morty25)
        mortyArray.add(binding.morty26)
        mortyArray.add(binding.morty27)
        mortyArray.add(binding.morty28)
        mortyArray.add(binding.morty29)
        mortyArray.add(binding.morty30)
        mortyArray.add(binding.morty31)
        mortyArray.add(binding.morty32)
        mortyArray.add(binding.morty33)
        mortyArray.add(binding.morty34)
        mortyArray.add(binding.morty35)

        hideImages()


        object : CountDownTimer(30500, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.timeText2.text = "TIME : ${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                binding.timeText2.text = "TIME OUT!"
                handler.removeCallbacks(runnable)

                for (image in mortyArray) {
                    image.visibility = View.INVISIBLE
                }
                val alert = AlertDialog.Builder(this@mortyScreen)
                alert.setTitle("GAME OVER")
                alert.setMessage("Your Score: ${score}" + "\n" + "Restart Game ?")
                alert.setPositiveButton("YES", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        val intentRick = intent
                        startActivity(intent)
                    }


                })
                alert.setNegativeButton("NO") { dialog, which ->
                    val intent = Intent(this@mortyScreen, MainActivity::class.java)
                    startActivity(intent)
                }

                alert.show()
            }

        }.start()
    }
    fun hideImages(){
        runnable = object : Runnable{
            override fun run() {
                for(image in mortyArray){
                    image.visibility = View.INVISIBLE
                }
                val random = java.util.Random()
                val randomIndex = random.nextInt(35)
                mortyArray[randomIndex].visibility = View.VISIBLE

                handler.postDelayed(runnable,400)
            }

        }
        handler.post(runnable)
    }
    fun increaseScore(view : View){
        score = score + 1
        binding.scoreText2.text = "SCORE : ${score}"
    }
}



