package com.example.letslearnactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FifthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)

        val firstFrag = FirstFragment()
        val secondFrag = SecondFragment()

        val fragButton1 : Button = findViewById(R.id.fragmentButton1)
        val fragButton2 : Button = findViewById(R.id.fragmentButton2)
        val gotoSix : Button = findViewById(R.id.gotoSix)


        fragButton1.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment,firstFrag)
                addToBackStack(null)
                commit()
            }
        }

        fragButton2.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment,secondFrag)
                addToBackStack(null)
                commit()
            }
        }

        gotoSix.setOnClickListener{
            Intent(this,SixthActivity::class.java).also {
                startActivity(it)
            }
        }


    }
}