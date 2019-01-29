package com.example.ripple

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View





class MainActivity : AppCompatActivity() {

    private val mHandler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mToastRunnable.run()


    }

    private val mToastRunnable = object : Runnable {
        override fun run() {
            val rippleBackground = findViewById<View>(R.id.content) as RippleBackground
            val reverseRippleBackground = findViewById<View>(R.id.content2) as ReverseRippleBackground

            rippleBackground.startRippleAnimation()
            Handler().postDelayed({
                reverseRippleBackground.reverseRippleAnimation()
            }, 7000)
            mHandler.postDelayed(this, 12000)
        }
    }

 }
