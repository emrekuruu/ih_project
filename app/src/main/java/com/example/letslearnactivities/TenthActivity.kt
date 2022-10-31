package com.example.letslearnactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class TenthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tenth)

        findViewById<Button>(R.id.start).setOnClickListener{
            Intent(this,MyService::class.java).also {
                startService(it)
                findViewById<TextView>(R.id.ServiceText).text = "Service running"
            }
        }


        findViewById<Button>(R.id.sendData).setOnClickListener{
            Intent(this,MyService::class.java).also {
                val dataStream = findViewById<TextView>(R.id.dataString).text.toString()
                it.putExtra("EXTRA_DATA",dataStream)
                startService(it)
            }
        }

        findViewById<Button>(R.id.stop).setOnClickListener{

            //one way of stopping service
            //MyIntentService.stop()
            //findViewById<TextView>(R.id.ServiceText).text = "Service stopped"

            //other way
            Intent(this,MyService::class.java).also {
                stopService(it)
                findViewById<TextView>(R.id.dataString).text = "Service Stopped"
            }

        }

    }
}