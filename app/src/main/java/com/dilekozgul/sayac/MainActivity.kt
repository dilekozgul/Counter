package com.dilekozgul.sayac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var number: Int =0
    var runnable : Runnable = Runnable {  }
    var handler : Handler = Handler(Looper.getMainLooper()!!)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


      /*  object : CountDownTimer(10000,1000){
            override fun onTick(millisUntilFinished: Long) {

                tvSayac.text="Left: ${millisUntilFinished/1000}"
            }

            override fun onFinish() {

                tvSayac.text="Left : 0"

            }

        }.start()*/
    }

    fun start(view: View){

        number=0

        runnable = object :Runnable{
            override fun run() {
                number = number +1
                tvSayac.text="Time : $number "

                handler.postDelayed(this,1000)
            }
        }
        handler.post(runnable)




    }


    fun stop(view: View){

        handler.removeCallbacks(runnable)
        number=0
        tvSayac.text="Time : 0"

    }

}