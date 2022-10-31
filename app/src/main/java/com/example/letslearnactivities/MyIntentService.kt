package com.example.letslearnactivities

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService : IntentService("myIntentService") {

    init {
        instance = this
    }

    companion object{
        private lateinit var instance : MyIntentService
        var isRunning = false

        fun stop(){
            Log.d("myIntentService","Service is Stopping.")
            isRunning = false
            instance.stopSelf()
        }
    }

    override fun onHandleIntent(intent: Intent?) {
        try {
            isRunning = true
            while (isRunning){
                Log.d(("myIntentService"),"Service is running.")
                Thread.sleep(1000)
            }
        }
        catch(e:InterruptedException){
            Thread.currentThread().interrupt()
        }
    }
}